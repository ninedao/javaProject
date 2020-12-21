package com.lzc.thinkingInJava.io;

import com.lzc.thinkingInJava.util.OSExecuteException;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

class OSExecute2{
    public static List<String> command(String command, String charsetName) {
        boolean err = false;
        List<String> output = new LinkedList<String>();
        try{
            Process process = new ProcessBuilder(command.split(" ")).start();
            BufferedReader results = new BufferedReader(new InputStreamReader(process.getInputStream(),charsetName));
            String s;
            while((s = results.readLine()) != null) {
                output.add(s);
            }
            BufferedReader errors = new BufferedReader(new InputStreamReader(process.getErrorStream(),charsetName));
            while((s = errors.readLine()) != null) {
                System.out.println(s);
                err = true;
            }
        } catch (Exception e) {
            if(!command.startsWith("CMD /C")){
                    output = command("CMD /C " + command, charsetName);
            }else{
                throw new RuntimeException(e);
            }
        }
        if(err){
            throw new OSExecuteException("Errors executing " + command);
        }
        return output;
    }
    public static List<String> command(String command){
        return command(command,"utf-8");
    }
}
public class E22_OSExecuteDemo {
    public static void main(String[] args) {
        List<String> list = OSExecute2.command("dir","GBK");
        for(String s : list) {
            System.out.println(s);
        }
    }
}
