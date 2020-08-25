package com.lzc.thinkingInJava.generics;

import java.util.List;

interface SuperPower{}
interface XRayVision extends SuperPower {
    void seeThroughWalls();
}
interface SuperHearing extends SuperPower {
    void hearSubtleMoises();
}
interface SuperSmell extends SuperPower {
    void trackBySmell();
}
class SuperHero<POWER extends SuperPower> {
    POWER power;
    SuperHero(POWER power) {
        this.power = power;
    }
    POWER getPower(){
        return power;
    }
}
class SuperSleuth<POWER extends  XRayVision> extends  SuperHero<POWER> {
    SuperSleuth(POWER power) {
        super(power);
    }
    void see(){
        power.seeThroughWalls();
    }
}
class CanineHero<POWER extends SuperHearing & SuperSmell> extends SuperHero<POWER>{

    CanineHero(POWER power) {
        super(power);
    }
    public void hear(){
        power.hearSubtleMoises();
    }
    public void smell(){
        power.trackBySmell();
    }
}
class SuperHearSmell implements SuperHearing, SuperSmell {

    @Override
    public void hearSubtleMoises() {

    }

    @Override
    public void trackBySmell() {

    }
}
class DogBoy extends CanineHero<SuperHearSmell> {

    DogBoy() {
        super(new SuperHearSmell());
    }
}
public class EpicBattle {
    static <POWER extends  SuperHearing> void useSuperHearing(SuperHero<POWER> hero) {
        hero.getPower().hearSubtleMoises();
    }
    static <POWER extends  SuperHearing & SuperSmell> void useSuperFind(SuperHero<POWER> hero) {
        hero.getPower().hearSubtleMoises();
        hero.getPower().trackBySmell();
    }
    public static void main(String[] args) {
        DogBoy dogBoy = new DogBoy();
        useSuperHearing(dogBoy);
        useSuperFind(dogBoy);
        List<? extends SuperHearing> audioBoys;
        //List<? extends SuperHearing & SuperSmell> audioBoy;
    }
}
