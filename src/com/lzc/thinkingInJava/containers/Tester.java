package com.lzc.thinkingInJava.containers;

import java.util.List;

public class Tester<C> {
    public static int fieldWidth = 8;
    public static TestParam[] defaultParam = TestParam.array(10, 5000,100, 5000, 1000, 5000,10000, 500);
    protected C container;
    private List<Test<C>> tests;
    private String headline="";
    private TestParam[] paramList = defaultParam;
    protected C initalize(int szie){
        return container;
    }
    private static String stringField(){
        return "%" + fieldWidth + "s";
    }
    private static String numberField(){
        return "%" + fieldWidth + "d";
    }
    private static int sizeWidth = 5;
    private static String sizeField = "%" + sizeWidth + "s";

    public Tester(C container, List<Test<C>> tests) {
        this.container = container;
        this.tests = tests;
        if(container != null){
            this.headline = container.getClass().getSimpleName();
        }
    }
    public Tester(C container, List<Test<C>> tests, TestParam[] params) {
        this(container, tests);
        this.paramList = params;
    }

    public void setHeadline(String headline) {
        this.headline = headline;
    }
    public static <C> void run(C cntnr, List<Test<C>> tests) {
        new Tester<C>(cntnr, tests).timedTest();
    }
    public static <C> void run(C cntnr, List<Test<C>> tests, TestParam[] paramList) {
        new Tester<C>(cntnr, tests, paramList).timedTest();
    }
    private void displayHeader() {
        int width = fieldWidth * tests.size() + sizeWidth; // 8 * tests.size + 5 //53
        int dashLength = width - headline.length() - 1; // 53-9-1 //43
        StringBuilder head = new StringBuilder(width); //
        for(int i = 0; i< dashLength/2; i++){ // 25
            head.append("-");
        }
        head.append(' ');
        head.append(headline);
        head.append(' ');
        for(int i = 0; i< dashLength/2; i++){
            head.append("-");
        }
        System.out.println(head);
        System.out.format(sizeField,"size");
        for(Test test : tests){
            System.out.format(stringField(), test.name);
        }
        System.out.println();
    }
    public void timedTest(){
        displayHeader();
        for(TestParam param : paramList){
            System.out.format(sizeField, param.size);
            for(Test<C> test : tests){
                C kontainer = initalize(param.size);
                long start = System.nanoTime();
                int reps = test.test(container, param);
                long duration  = System.nanoTime() - start;
                long timePerRep = duration / reps;
                System.out.format(numberField(), timePerRep);
            }
            System.out.println();
        }
    }
}
