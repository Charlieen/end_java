package core.java.basic.inherit.pack2;


import core.java.basic.inherit.InheritDemo;
import core.java.basic.inherit.pack1.InPack1Class;

/**
 * Because In InheritDemo class , field id is public ,then here, i can use it directly,
 *
 */
public class ClientOfInheritDemo  {
    private InheritDemo inheritDemo;
    public void sayID(){
        System.out.println("In ClientOfInheritDemo: "+inheritDemo.id.toUpperCase());
        System.out.println("In ClientOfInheritDemo" + inheritDemo.getName());
    }
    /**
     *'core.java.basic.inherit.pack1.InPack1Class.InnerClassInInPack1ClassNoAccessModifier'
     * is not public in 'core.java.basic.inherit.pack1.InPack1Class'.
     * Cannot be accessed from outside package
     */
   // InPack1Class.InnerClassInInPack1ClassNoAccessModifier
    public static void main(String[]args){

    }
}
