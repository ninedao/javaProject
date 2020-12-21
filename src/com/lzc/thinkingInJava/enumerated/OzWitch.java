package com.lzc.thinkingInJava.enumerated;

public enum OzWitch {
    WEST("1"),
    SOUTH("2"),
    NORTH("3"),
    EAST("4");
    private String description;

    private OzWitch(String s) {
        this.description = s;
    }

    public String getDescription() {
        return description;
    }

    public static void main(String[] args) {
        for(OzWitch o : OzWitch.values()) {
            System.out.println(o + " " + o.getDescription());
        }
    }
}
