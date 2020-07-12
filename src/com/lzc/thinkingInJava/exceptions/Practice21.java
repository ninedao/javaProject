package com.lzc.thinkingInJava.exceptions;
class Exception211 extends Exception{}
class Practice211 {
    public Practice211() throws Exception211{
        throw new Exception211();
    }
}
public class Practice21 extends Practice211 {


    public Practice21() throws Exception211 {
        super();
        //不能这么些，因为super()要在第一句
//        try {
//            super();
//        } catch (Exception211 exception211) {
//            exception211.printStackTrace();
//        }
    }

    public static void main(String[] args){
        try {
            Practice21 p = new Practice21();
        } catch (Exception211 exception211) {
            System.out.println(exception211);
        }
    }
}
