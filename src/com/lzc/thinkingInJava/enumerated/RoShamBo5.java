package com.lzc.thinkingInJava.enumerated;

import java.util.EnumMap;

import static com.lzc.thinkingInJava.enumerated.Outcome.*;

public enum RoShamBo5 implements Competiter<RoShamBo5> {
    ROCK,SCISSORS,PAPER;
    static EnumMap<RoShamBo5, EnumMap<RoShamBo5,Outcome>> mapEnumMap = new EnumMap<RoShamBo5, EnumMap<RoShamBo5, Outcome>>(RoShamBo5.class);
    static{
        for(RoShamBo5 s : RoShamBo5.values()){
            mapEnumMap.put(s,new EnumMap<RoShamBo5, Outcome>(RoShamBo5.class));
        }
        initRow(PAPER,DRAW,LOSE,WIN);
        initRow(SCISSORS,WIN,DRAW,LOSE);
        initRow(ROCK,LOSE,WIN,DRAW);
    }
    static void initRow(RoShamBo5 it, Outcome vPaper, Outcome vScissors, Outcome vRock){
        EnumMap<RoShamBo5, Outcome> row = RoShamBo5.mapEnumMap.get(it);
        row.put(RoShamBo5.PAPER,vPaper);
        row.put(RoShamBo5.SCISSORS,vScissors);
        row.put(RoShamBo5.ROCK,vRock);
    }

    public static void main(String[] args) {
        RoShamBo.play(RoShamBo5.class,20);
    }

    @Override
    public Outcome compete(RoShamBo5 it) {
        return mapEnumMap.get(this).get(it);
    }
}
