package com.lzc.thinkingInJava.annotaions.databases;

@DBTable(name = "MEMBER")
public class Member {
    @SQLString(30)
    String firstname;
    @SQLString(50)
    String lastname;
    @SQLInteger
    Integer age;
    @SQLBoolean
    boolean isVip;
    @SQLCharacter(value = 30,constraints = @Constraints(primaryKey = true))
    String handle;

    public boolean isVip() {
        return isVip;
    }

    public Integer getAge() {
        return age;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getHandle() {
        return handle;
    }

    public String getLastname() {
        return lastname;
    }

    @Override
    public String toString() {
        return handle;
    }

}
