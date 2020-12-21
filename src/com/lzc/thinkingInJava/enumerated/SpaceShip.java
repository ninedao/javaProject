package com.lzc.thinkingInJava.enumerated;

import com.lzc.thinkingInJava.exceptions.Switch;

public enum SpaceShip {
    SCOUT,GARGO,TRANSPORT,CRUISER,BATTLESHIP,MOTHERSHIP;

    @Override
    public String toString() {
        String id = name();
        String lower = id.substring(1).toLowerCase();
        return id.charAt(0) + lower;
    }

    public static void main(String[] args) {
        for(SpaceShip s : SpaceShip.values()){
            System.out.println(s);
        }
    }
}
