package com.lzc.thinkingInJava.exceptions;

class UmpireArgument extends BaseBallException{}
class ThrownFromGame extends UmpireArgument {}
abstract class Inning1 {
    public Inning1() throws BaseBallException{}
    public void event() throws BaseBallException {}
    public void questionableCall() throws UmpireArgument {}
    public abstract void atBat() throws Strike, Foul, UmpireArgument;
    public void walk() {}
}

public class Practice20 extends Inning1 implements Storm {


    public Practice20() throws RainedOut, UmpireArgument, BaseBallException {
    }
    public Practice20(String s) throws Foul, BaseBallException {

    }
    public void questionableCall() throws UmpireArgument {
        throw new UmpireArgument();
    }
    //public void walk() throws PopFoul {}
    //public void event() throws RainedOut {}
    public void event(){};
    @Override
    public void atBat() throws PopFoul,ThrownFromGame  {
        throw new ThrownFromGame();
    }

    @Override
    public void rainHard() throws RainedOut {

    }

    public static void main(String[] args){
        try {
            Practice20 s = new Practice20();
            s.atBat();
            s.questionableCall();
        } catch (RainedOut rainedOut) {
            rainedOut.printStackTrace();
        } catch (PopFoul popFoul) {
            popFoul.printStackTrace();
        } catch (ThrownFromGame thrownFromGame) {
            thrownFromGame.printStackTrace();
        } catch (UmpireArgument umpireArgument) {
            umpireArgument.printStackTrace();
        } catch (BaseBallException e) {
            e.printStackTrace();
        }
        try {
            Inning1 i = new Practice20();
            i.atBat();
            //i.questionableCall();
        } catch (RainedOut rainedOut) {
            rainedOut.printStackTrace();
        } catch (Strike strike) {
            strike.printStackTrace();
        } catch (Foul foul) {
            foul.printStackTrace();
        } catch (UmpireArgument umpireArgument) {
            umpireArgument.printStackTrace();
        } catch (BaseBallException e) {
            e.printStackTrace();
        }
    }


}
