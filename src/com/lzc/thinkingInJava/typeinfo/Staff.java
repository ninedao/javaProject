package com.lzc.thinkingInJava.typeinfo;

import java.util.ArrayList;

public class Staff extends ArrayList<Position> {
    public void ass(String title, Person person) {
        add(new Position(title, person));
    }
    public void add(String... titles) {
        for(String s : titles) {
            add(new Position(s));
        }
    }
    public Staff(String... titles) {
        add(titles);
    }
    public boolean positionAvailable(String title) {
        for(Position position : this) {
            if(position.getTitle().equals(title) && position.getPerson() == Person.NULL){
                return true;
            }
        }
        return false;
    }
    public void fillPosition(String title, Person hire) {
        for(Position position : this) {
            if(position.getTitle().equals(title) && position.getPerson() == Person.NULL){
                position.setPerson(hire);
                return;
            }
        }
        throw new RuntimeException("Position " + title + "not available");
    }
    public static void main(String[] args) {
        Staff staff = new Staff("President", "CTO", "Marketing Manager", "Product Manager",
                "Project Lead", "Software Engineer", "Software Engineer", "Software Engineer", "Software Engineer",
                "Test Engineer", "Technical Writer");
        staff.fillPosition("President", new Person("Me", "Last", "The Top, Lonely At"));
        staff.fillPosition("Project Lead", new Person("Janet", "Planner", "The Burbs"));
        if(staff.positionAvailable("Software Engineer")) {
            staff.fillPosition("Software Engineer", new Person("Bob", "Coder", "Bright Light City"));
        }
        for(Position p : staff){
            System.out.println(p);
        }
    }
}
