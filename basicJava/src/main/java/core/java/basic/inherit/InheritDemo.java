package core.java.basic.inherit;

import core.java.basic.inherit.pack1.InPack1Class;

public class InheritDemo {

    public String id; // very bad, must use private

    private String name;

    InPack1Class.InnerClassInInPack1Class innerClassInInPack1Class;

    public String getName(){
        // sometime, this API can be change return "Hello "+ name;
        // all modules which depends on this API do not need to change,
        return name;
    }
    public void setName(String name){
        this.name= name;
    }

    protected void sayHello() {

        System.out.println("in InheritDemo, I am saying hello...");
    }
    public  void sayBye() {

        System.out.println("in InheritDemo, I am saying bye...");
    }
    public static void main(String[]args){
        InPack1Class inPack1Class = new InPack1Class();
    }
}
