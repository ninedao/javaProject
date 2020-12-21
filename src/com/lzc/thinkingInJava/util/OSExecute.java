package com.lzc.thinkingInJava.util;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class OSExecute {
    public static void command(String command, String charsetName) {
        boolean err = false;
        try{
            Process process = new ProcessBuilder(command.split(" ")).start();
            BufferedReader results = new BufferedReader(new InputStreamReader(process.getInputStream(),charsetName));
            String s;
            while((s = results.readLine()) != null) {
                System.out.println(s);
            }
            BufferedReader errors = new BufferedReader(new InputStreamReader(process.getErrorStream(),charsetName));
            while((s = errors.readLine()) != null) {
                System.out.println(s);
                err = true;
            }
        } catch (Exception e) {
            if(!command.startsWith("CMD /C")){
                command("CMD /C " + command, charsetName);
            }else{
                throw new RuntimeException(e);
            }
        }
        if(err){
            throw new OSExecuteException("Errors executing " + command);
        }
    }
    public static void command(String command){
        command(command,"utf-8");
    }
}
