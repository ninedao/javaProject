package com.lzc.thinkingInJava.util;

import java.util.Iterator;

class Mail{
    enum GeneralDelivery{YES,NO1,NO2,NO3,NO4,NO5}
    enum Scannability{UNSCANNABLE,YES1,YES2,YES3,YES4}
    enum Readability{ILLEGIBLE,YES1,YES2,YES3,YES4}
    enum Address{INCORRECT,OK1,OK2,OK3,OK4,OK5,OK6}
    enum ReturnAddress{MISSING,OK1,OK2,OK3,OK4,OK5}
    GeneralDelivery generalDelivery;
    Scannability scannability;
    Readability readability;
    Address address;
    ReturnAddress returnAddress;
    static long counter = 0;
    long id = counter++;

    @Override
    public String toString() {
        return "Mail " + id;
    }
    public String details(){
        return "Mail{" +
                "generalDelivery=" + generalDelivery +
                ", scannability=" + scannability +
                ", readability=" + readability +
                ", address=" + address +
                ", returnAddress=" + returnAddress +
                ", id=" + id +
                '}';
    }
    public static Mail randomMail(){
        Mail m = new Mail();
        m.generalDelivery = Enums.random(GeneralDelivery.class);
        m.scannability = Enums.random(Scannability.class);
        m.readability = Enums.random(Readability.class);
        m.address = Enums.random(Address.class);
        m.returnAddress = Enums.random(ReturnAddress.class);
        return m;

    }
    public static Iterable<Mail> generator(final int count){

        return new Iterable<Mail>() {
            int n = count;
            @Override
            public Iterator<Mail> iterator() {
                return new Iterator<Mail>() {
                    @Override
                    public boolean hasNext() {
                        return n-- >0;
                    }

                    @Override
                    public Mail next() {
                        return randomMail();
                    }
                };
            }
        };
    }
}
public class PostOffice {
    enum MailHandler{
        GENERAL_DELIVERY{
            @Override
            boolean handle(Mail m) {
                switch (m.generalDelivery){
                    case YES:
                        System.out.println("Using general delivery for " + m);
                        return true;
                    default: return false;
                }
            }
        },MACHINE_SCAN{
            @Override
            boolean handle(Mail m) {
                switch (m.scannability){
                    case UNSCANNABLE:
                        return false;
                    default:
                        switch (m.address){
                            case INCORRECT: return false;
                            default:
                                System.out.println("Delivering " + m + " automaticallly");
                                return true;
                        }
                }
            }
        },VISUAL_INSPECTION{
            @Override
            boolean handle(Mail m) {
                switch (m.readability){
                    case ILLEGIBLE:
                        return false;
                    default: switch (m.address){
                        case INCORRECT: return false;
                        default:
                            System.out.println("Delivering " + m + " normally");
                            return true;
                    }
                }
            }
        },RETURN_TO_SENDER{
            @Override
            boolean handle(Mail m) {
                switch (m.returnAddress){
                    case MISSING:
                        return false;
                    default:
                        System.out.println("Returing " + m + " to sender");
                        return true;
                }
            }
        };
        abstract boolean handle(Mail m);
    }
    static void handler(Mail m) {
        for(MailHandler handler : MailHandler.values()){
            if(handler.handle(m)){
                return;
            }
        }
        System.out.println(m + " is a dead letter");
    }

    public static void main(String[] args) {
        for(Mail m : Mail.generator(10)) {
            System.out.println(m.details());
            handler(m);
            System.out.println("**********");
        }
    }
}
