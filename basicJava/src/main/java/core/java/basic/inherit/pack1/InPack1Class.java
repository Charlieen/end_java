package core.java.basic.inherit.pack1;

import core.java.basic.inherit.InheritDemo;

/**
 * NO private,protected,public  then can be see in the same package.
 * Eg. InPackClass2  can see InPack1WithoutPublic
 *     but in core.java.basic.inherit.inheritDemo  can not see InPack1WithoutPublic
 */
class InPack1WithoutPublic{
    InPack1Class.InnerClassInInPack1Class  innerClassInInPack1Class ;
   // InPack1Class.InnerClassInInPack1ClassPrivate innerClassInInPack1ClassPrivate;
}

/**
 * if subClass method override parent's method, then access level should equal or higher then parent's access level,
 * and make sure all places where use parent methods can use subClass method to replace ,
 */
public class InPack1Class extends InheritDemo {

    @Override
    protected void sayHello() {
        super.sayHello();
        System.out.println("InPack1Class, I am the subClass of InheritDemo,I am saying hello...");
    }

    @Override
     public void sayBye() {
        super.sayBye();
        System.out.println("InPack1Class, I am the subClass of InheritDemo,I am saying bye...");
    }

    /**
     * can be used at any place
     */
    public class InnerClassInInPack1Class{

    }

    /**
     * just can be use in this class InPack1Class;
     */
    private class InnerClassInInPack1ClassPrivate{

    }

    /*
    * just can be used in same package
     */
    class InnerClassInInPack1ClassNoAccessModifier{

    }
}
