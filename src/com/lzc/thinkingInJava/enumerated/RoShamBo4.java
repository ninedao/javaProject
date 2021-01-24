package com.lzc.thinkingInJava.enumerated;

import static com.lzc.thinkingInJava.enumerated.Outcome.*;

public enum RoShamBo4 implements Competiter<RoShamBo4> {
    ROCK{
        @Override
        public Outcome compete(RoShamBo4 opponent) {
            return compete(PAPER,opponent);
        }
    },PAPER{
        @Override
        public Outcome compete(RoShamBo4 opponent) {
            return compete(SCISSORS,opponent);
        }
    },SCISSORS{
        @Override
        public Outcome compete(RoShamBo4 opponent) {
            return compete(ROCK,opponent);
        }
    };

    public Outcome compete(RoShamBo4 loser,RoShamBo4 opponent) {
        return (opponent == this) ? DRAW : ((opponent == loser) ? LOSE :WIN);
    }

    public static void main(String[] args) {
        RoShamBo.play(RoShamBo4.class,20);
    }
}
