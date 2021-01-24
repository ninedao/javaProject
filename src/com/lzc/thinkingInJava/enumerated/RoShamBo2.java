package com.lzc.thinkingInJava.enumerated;


import static com.lzc.thinkingInJava.enumerated.Outcome.*;



public enum RoShamBo2 implements Competiter<RoShamBo2> {
    PAPER(DRAW,LOSE,WIN),SCISSORS(WIN,DRAW,LOSE),ROCK(LOSE,WIN,DRAW);

    private Outcome vPAPER, vSCISSORS, vROCK;
    RoShamBo2(Outcome paper, Outcome scissors, Outcome rock) {
        this.vPAPER = paper;
        this.vSCISSORS = scissors;
        this.vROCK = rock;
    }

    @Override
    public Outcome compete(RoShamBo2 it) {
        switch (it){
            default:
            case PAPER:return vPAPER;
            case ROCK:return vROCK;
            case SCISSORS:return vSCISSORS;
        }
    }

    public static void main(String[] args) {
        RoShamBo.play(RoShamBo2.class, 20);
    }
}
