package com.lzc.thinkingInJava.exceptions;

class BaseBallException extends Exception {}
class Foul extends BaseBallException {}
class Strike extends BaseBallException {}
abstract class Inning {
    public Inning() throws BaseBallException{}
    public void event() throws BaseBallException {}
    public abstract void atBat() throws Strike, Foul;
    public void walk() {};
}
class StormException extends Exception {}
class RainedOut extends StormException {}
class PopFoul extends Foul {}
interface Storm {
    void event() throws RainedOut;
    void rainHard() throws RainedOut;
}
public class StormyInning extends Inning implements Storm {


    public StormyInning() throws RainedOut, BaseBallException {
    }
    public StormyInning(String s) throws Foul, BaseBallException {

    }
    //public void walk() throws PopFoul {}
    //public void event() throws RainedOut {}
    public void event(){};
    @Override
    public void atBat() throws PopFoul {

    }

    @Override
    public void rainHard() throws RainedOut {

    }
    public static void main(String[] args){
        try {
            StormyInning s = new StormyInning();
            s.atBat();
        } catch (RainedOut rainedOut) {
            rainedOut.printStackTrace();
        } catch (PopFoul popFoul) {
            popFoul.printStackTrace();
        } catch (BaseBallException e) {
            e.printStackTrace();
        }
        try {
            Inning i = new StormyInning();
            i.atBat();
        } catch (RainedOut rainedOut) {
            rainedOut.printStackTrace();
        } catch (Strike strike) {
            strike.printStackTrace();
        } catch (Foul foul) {
            foul.printStackTrace();
        } catch (BaseBallException e) {
            e.printStackTrace();
        }
    }
}
