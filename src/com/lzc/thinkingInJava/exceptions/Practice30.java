package com.lzc.thinkingInJava.exceptions;


import static com.lzc.thinkingInJava.util.Print.print;

class Practice30Annoyance extends RuntimeException {}

class Practice30Sneeze extends Practice30Annoyance {}
class WrapCheckedExceptions {
    void throwRuntimeException(int type) {
        try {
            switch(type) {
                case(0):
                    throw new Practice30Annoyance();
                case(1):
                    throw new Practice30Sneeze();
                case(2):
                    throw new RuntimeException("Where am I?");
                default: return;
            }
        } 	catch(Exception e) {
            // Adapt to unchecked:
            throw new RuntimeException(e);
        }
    }
}

public class Practice30 {
    public static void main(String[] args){
        WrapCheckedExceptions w = new WrapCheckedExceptions();
        w.throwRuntimeException(3);
            for(int i = 0; i < 4; i++){
                try{
                    if(i < 3) {
                        w.throwRuntimeException(i);
                    } else {
                        throw new RuntimeException();
                    }
                } catch (RuntimeException re){
                    try {
                        throw re.getCause();
                    } catch (Practice30Sneeze e) {
                        print("Practice30Sneeze: " + e);
                    } catch (Practice30Annoyance e) {
                        print("Practice30Annoyance: " + e);
                    } catch (Throwable throwable) {
                        print("Throwable: " + throwable);
                    }
                }
            }

    }
}
