package common;

public enum constant {

    OUTURL("out/production/javaProject/com/lzc/"),
    SRCURL("src/com/lzc/");

    private String value;
    constant(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

}
