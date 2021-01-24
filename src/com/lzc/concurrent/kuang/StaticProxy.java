package com.lzc.concurrent.kuang;

public class StaticProxy {
    public static void main(String[] args) {
        WeddingCompany weddingCompany = new WeddingCompany(new You());
        weddingCompany.HappyMarry();
    }
}
interface Marry{
    void HappyMarry();
}
class You implements Marry{
    @Override
    public void HappyMarry() {
        System.out.println("结婚了结婚了");
    }
}
class WeddingCompany implements Marry{

    private Marry you;

    public WeddingCompany(Marry you) {
        this.you = you;
    }

    @Override
    public void HappyMarry() {
        before();
        you.HappyMarry();
        after();
    }

    private void after() {
        System.out.println("结婚之后：收拾场地");
    }

    private void before() {
        System.out.println("结婚前：布置场地");
    }
}
