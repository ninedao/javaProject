package com.lzc.thinkingInJava.exceptions;

class Practice29BaseBallException extends RuntimeException {}

class Practice29Foul extends Practice29BaseBallException {}

class Practice29Strike extends Practice29BaseBallException {}

abstract class Practice29Inning {
    public Practice29Inning() throws Practice29BaseBallException{}
    public void event() throws Practice29BaseBallException {}
    public abstract void atBat() throws Practice29Strike, Practice29Foul;
    public void walk() {};
}

class Practice29StormException extends RuntimeException {}

class Practice29RainedOut extends Practice29StormException {}

class Practice29PopFoul extends Practice29Foul {}

interface Practice29Storm {
    void event() throws Practice29RainedOut;
    void rainHard() throws Practice29RainedOut;
}

public class Practice29 extends Practice29Inning implements Practice29Storm {


    public Practice29() throws RainedOut, BaseBallException {
    }
    public Practice29(String s) throws Foul, BaseBallException {

    }
    //public void walk() throws PopFoul {}
    //public void event() throws RainedOut {}
    public void event(){};
    @Override
    public void atBat()  {

    }

    @Override
    public void rainHard()  {

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
