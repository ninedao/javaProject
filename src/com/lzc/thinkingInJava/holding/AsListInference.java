package com.lzc.thinkingInJava.holding;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

class Snow{
    Snow(){
        System.out.println("Snow");
    }
}
class Powder extends Snow{
    Powder(){
        System.out.println("Powder");
    }
}
class Light extends Powder{
    Light(){
        System.out.println("Light");
    }
}
class Heavy extends Powder{
    Heavy(){
        System.out.println("Heavy");
    }
}
class Crusty extends Snow{
    Crusty(){
        System.out.println("Crusty");
    }
}
class Slush extends Snow{
    Slush(){
        System.out.println("Slush");
    }
}
public class AsListInference {
    public static void main(String[] args){
        List<Snow> snow1 = Arrays.asList(new Powder(), new Crusty(), new Slush());
        List<Snow> snow2 = Arrays.asList(new Light(), new Heavy());
        List<Snow> snow3 = new ArrayList<Snow>();
        Collections.addAll(snow3, new Light(), new Heavy());
        List<Snow> snow4 = Arrays.<Snow>asList(new Light(), new Heavy());
    }
}
