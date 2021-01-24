package com.lzc.thinkingInJava.enumerated;

import static com.lzc.thinkingInJava.enumerated.Outcome.*;

public enum RoShamBo6 implements Competiter<RoShamBo6> {
    PAPER,SCISSORS,ROCK;
    private static Outcome[][] table = {
        {DRAW,LOSE,WIN},
        {WIN,DRAW,LOSE},
        {LOSE,WIN,DRAW}
    };
    public static void main(String[] args) {
        RoShamBo.play(RoShamBo6.class,20);
    }

    @Override
    public Outcome compete(RoShamBo6 it) {
        return table[ordinal()][it.ordinal()];
    }
}
