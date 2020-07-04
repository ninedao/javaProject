package com.lzc.thinkingInJava.innerclasses.controller;

import com.lzc.thinkingInJava.holding.Practice13;

import java.util.Arrays;

public class GreenhouseControls extends Practice13 {
    private boolean light = false;
    private boolean water = false;
    private String thermostat = "Day";
    public class LightOn extends Event{
        protected LightOn(long delayTime) {
            super(delayTime);
        }

        @Override
        public void action() {
            light = true;
        }

        @Override
        public String toString() {
            return "Light is on";
        }
    }
    public class LightOff extends Event{
        protected LightOff(long delayTime) {
            super(delayTime);
        }

        @Override
        public void action() {
            light = false;
        }

        @Override
        public String toString() {
            return "Light is off";
        }
    }

    public class WaterOn extends Event{
        protected WaterOn(long delayTime) {
            super(delayTime);
        }

        @Override
        public void action() {
            water = true;
        }

        @Override
        public String toString() {
            return "GreenHouse water is on";
        }
    }

    public class WaterOff extends Event{
        protected WaterOff(long delayTime) {
            super(delayTime);
        }

        @Override
        public void action() {
            water = false;
        }

        @Override
        public String toString() {
            return "GreenHouse water is off";
        }
    }

    public class ThermostatNight extends Event{
        protected ThermostatNight(long delayTime) {
            super(delayTime);
        }

        @Override
        public void action() {
            thermostat = "Night";
        }

        @Override
        public String toString() {
            return "Thermostat on night setting";
        }
    }

    public class ThermostatDay extends Event{
        protected ThermostatDay(long delayTime) {
            super(delayTime);
        }

        @Override
        public void action() {
            thermostat = "Day";
        }

        @Override
        public String toString() {
            return "Thermostat on day setting";
        }
    }
    public class Bell extends Event{
        protected Bell(long delayTime) {
            super(delayTime);
        }

        @Override
        public void action() {
            addEvent(new Bell(delayTime));
        }
        @Override
        public String toString() {
            return "Bing!";
        }
    }
    public class Restart extends Event{
        private Event[] events;
        protected Restart(long delayTime, Event[] events) {
            super(delayTime);
            this.events = events;
            for(Event e : events){
                addEvent(e);
            }
        }

        @Override
        public void action() {
            for(Event e : events){
                e.start();
                addEvent(e);
            }
            start();
            addEvent(this);
        }

        @Override
        public String toString() {
            return "Restarting system";
        }
    }
    public static class Terminate extends Event{
        protected Terminate(long delayTime) {
            super(delayTime);
        }

        @Override
        public void action() {
            System.exit(0);
        }

        @Override
        public String toString() {
            return "Terminating";
        }
    }
}
