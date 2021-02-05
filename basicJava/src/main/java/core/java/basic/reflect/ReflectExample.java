package core.java.basic.reflect;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import java.lang.annotation.Annotation;
import java.lang.reflect.Modifier;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;
import static java.lang.System.out;

/**
 *Reflection is commonly used by programs which require the ability to examine or modify the runtime behavior of applications running
 * in the java virtual machine.This is relativity advanced feature and should be used only by developers who have a strong grasp of
 * the fundamentals of the language.With that caveat in mind, reflection is a powerful technique and can enable applications to perform
 * operations which would otherwise be impossible
 */
enum E{A,B}

public class ReflectExample {

    public  void demoGetClass(){
        ReflectExample r= new ReflectExample();
        Class c = r.getClass();

        System.out.println(c);

        Class c2= E.A.getClass();
        System.out.println(c2);

        byte[] bytes = new byte[1024];
        Class c3= bytes.getClass();

        System.out.println(c3);

        Set<String> s = new HashSet<String>();

        System.out.println(s.getClass());

        boolean b= false;
        //  System.out.println(b.getClass());
        System.out.println(boolean.class);

        Class c4= java.io.PrintStream.class;
        System.out.println(c4);
        System.out.println(int[][][].class); // class [[[I
    }
    public static void forName() throws ClassNotFoundException {
        Class c1 = Class.forName("core.java.basic.inherit.InheritDemo");
        Class cDoubleArray = Class.forName("[D");
        Class cStringArray = Class.forName("[[Ljava.lang.String;");
        System.out.println(cStringArray);
        Class c = Double.TYPE;
        System.out.println(c);
        System.out.println(Void.TYPE);

    }

    public static void methodsReturnClass(){
        Class c = javax.swing.JButton.class.getSuperclass();
        System.out.println(c);
        Class<?>[] carr = Character.class.getClasses();
        Arrays.stream(carr).forEach(x-> System.out.println(x));
        Class c1= Thread.State.class.getEnclosingClass();

        System.out.println(c1);
    }


    public static void main(String[] args) throws ClassNotFoundException {
        methodsReturnClass();
    }
}
