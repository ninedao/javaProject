package com.lzc.thinkingInJava.enumerated;

import static com.lzc.thinkingInJava.enumerated.Outcome.*;

public enum RoShamBo3 implements Competiter<RoShamBo3> {
    PAPER{
        @Override
        public Outcome compete(RoShamBo3 it) {
            switch(it){
                default:
                case ROCK:return WIN;
                case PAPER:return DRAW;
                case SCISSOR:return LOSE;
            }
        }
    },SCISSOR{
        @Override
        public Outcome compete(RoShamBo3 it) {
            switch(it){
                default:
                case PAPER:return WIN;
                case SCISSOR:return DRAW;
                case ROCK:return LOSE;
            }
        }
    },ROCK{
        @Override
        public Outcome compete(RoShamBo3 it) {
            switch(it){
                default:
                case SCISSOR:return WIN;
                case ROCK:return DRAW;
                case PAPER:return LOSE;
            }
        }
    };



    public abstract Outcome compete(RoShamBo3 competiter);

    public static void main(String[] args) {
        RoShamBo.play(RoShamBo3.class,20);
    }
}
