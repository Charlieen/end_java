package core.java.basic.inherit.pack2;

import core.java.basic.inherit.InheritDemo;
/**
 * Because In InheritDemo class , field id is public ,then here, i can use it directly,
 * But, sometimes, if In InheritDemo, change id type from String to int,
 * then all classes which  are using InheritDemo id field , should be changed to follow this update.
 *
 */
public class ClientOfInheritDemo2 {
    private InheritDemo inheritDemo;
    public void sayID(){
        System.out.println("In ClientOfInheritDemo2: "+inheritDemo.id.toLowerCase());
        System.out.println("In ClientOfInheritDemo2" + inheritDemo.getName());
    }
    public static void main(String[]args){

    }

}
