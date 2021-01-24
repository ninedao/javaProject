package com.lzc.thinkingInJava.enumerated;

import com.lzc.thinkingInJava.util.Generator;
import com.lzc.thinkingInJava.util.TextFile;

import java.io.File;
import java.util.EnumMap;
import java.util.Iterator;

import static com.lzc.thinkingInJava.enumerated.Input.*;

enum Category{
    MONEY(NICKEL,DIME,QUARTER,DOLLAR),
    ITEM_SELECTION(TOOTHPASTE,CHIPS,SODA,SOAP),
    QUIT_TRANSACTION(ABORT_TRANSACTION),
    SHUT_DOWN(STOP);
    private Input[] values;
    Category(Input... inputs){
        this.values = inputs;
    }
    private static EnumMap<Input, Category> inputCategoryEnumMap = new EnumMap<Input, Category>(Input.class);
    static{
        for(Category c : Category.class.getEnumConstants()){
            for(Input i : c.values){
                inputCategoryEnumMap.put(i,c);
            }
        }
    }
    public static Category categorize(Input input) {
        return inputCategoryEnumMap.get(input);
    }
}

public class VendingMachine {
    private static State state = State.RESTING;
    private static int amount = 0;
    private static Input selection = null;
    enum StateDuration{
        TRANSIENT
    }
    enum State{
        RESTING{
            @Override
            void next(Input input) {
                switch(Category.categorize(input)) {
                    case MONEY:
                        amount += input.amount();
                        state = ADDING_MONEY;
                        break;
                    case SHUT_DOWN:
                        state = TERMINAL;
                    default:
                }
            }
        },ADDING_MONEY{
            @Override
            void next(Input input) {
                switch(Category.categorize(input)) {
                    case MONEY:
                        amount += input.amount();
                        break;
                    case ITEM_SELECTION:
                        selection = input;
                        if(amount < selection.amount()) {
                            System.out.println("Insufficient money for " + selection);
                        }else{
                            state = DISPENSING;
                        }
                        break;
                    case QUIT_TRANSACTION:
                        state = GIVING_CHANGE;
                        break;
                    case SHUT_DOWN:
                        state = TERMINAL;
                        break;
                    default:
                }
            }
        },DISPENSING(StateDuration.TRANSIENT){
            @Override
            void next() {
                System.out.println("here is you " + selection);
                amount -= selection.amount();
                state = GIVING_CHANGE;
            }
        },GIVING_CHANGE(StateDuration.TRANSIENT){
            @Override
            void next() {
                if(amount > 0){
                    System.out.println("Your change: " + amount);
                    amount = 0;
                }
                state = RESTING;
            }
        },TERMINAL{
            @Override
            void output() {
                System.out.println("Halted");
            }
        };
        State(){}
        private boolean isTransient = false;
        State(StateDuration stateDuration){
            this.isTransient = true;
        }
        void next(Input input) {
            throw new RuntimeException("Only call " + "next(Input input) for non-transient states");
        }
        void next() {
            throw new RuntimeException("Only call " + "next(Input input) for " + StateDuration.TRANSIENT + " states");
        }
        void output(){
            System.out.println(amount);
        }
    }
    static void run(Generator<Input> gen){
        while(state != State.TERMINAL){
            state.next(gen.next());
            while(state.isTransient){
                state.next();
            }
            state.output();
        }
    }
    public static void main(String[] args) {
        Generator<Input> generator = new RandomInputGenerator();
        generator = new FileInputGenerator("out/production/javaProject/com/lzc/thinkingInJava/enumerated/VendingMachineInput");

        run(generator);
    }

}
class RandomInputGenerator implements Generator<Input> {

    @Override
    public Input next() {
        return Input.randomSelection();
    }
}
class FileInputGenerator implements Generator<Input> {
    private Iterator<String> iterator;
    public FileInputGenerator(String filename){
        iterator = new TextFile(filename,";").iterator();
    }
    @Override
    public Input next() {
        if(!iterator.hasNext()){
            return null;
        }
        return Enum.valueOf(Input.class, iterator.next());
    }
}
