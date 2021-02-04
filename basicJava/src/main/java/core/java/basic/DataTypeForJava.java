package core.java.basic;

import java.util.ArrayList;
import java.util.List;

class A{

    private int x;
    private static List<Integer> continer = new ArrayList<>(); // initiated at here only once

    static{
        System.out.println("Static block will be executed just once at class initiated");
    }
    public A(int initX){
        this.x= initX;
        continer.add(initX);
    }

    public static void func1(){
        System.out.println(continer); // only can visit static variable or static method;
        func2();
        // System.out.println(this.x);// can not use this and super
    }
    public static void func2(){
        System.out.println("this is func2");
    }


    @Override
    public String toString() {
        return "A{" +
                "x=" + x +
                "container="+continer+
                '}';
    }

    /**
     * we can see continer just keep one instance which is initiated
     */
    public static void main(String[]args){

        for(int i=1;i<10;i++){
            A a= new A(i);
            System.out.println(Integer.toHexString(System.identityHashCode(a)));
            System.out.println(Integer.toHexString(System.identityHashCode(a.continer)));
        }
        System.out.println(A.continer);
    }
}

class OuterClass{
    private int x;
    private static int y;
    class InnerClass{

    }
    static class StaticInnerClass{
    // in static inner class only can visit outer class static variable and method
        void sayHi(){
         //   System.out.println(x);
            System.out.println(y);
        }
    }
    public static void main(String[]args){
        //core.java.basic.OuterClass.this' cannot be referenced from a static context
        //InnerClass innerClass = new InnerClass();
        OuterClass outerClass = new OuterClass();
        // inner class without static modifier ,when it want to be created,it depend on outer class
        InnerClass innerClass = outerClass.new InnerClass();
        StaticInnerClass staticInnerClass = new StaticInnerClass();

    }
}

class InitiatedOrder{
    public static String staticField="staticFieldOne_OneState_1 ";
    static{
        System.out.println("This is Second appear static context -> block_OneStage_2");
    }
    public String field="ordinary Instance variable_TwoStage_1";
    {
        System.out.println("This is Second appear normal context block_TwoStage_2");
    }
    public InitiatedOrder(){
        System.out.println("Constructor function initiated..._ThirdStage_1");
    }
}

/**
 *  1: parent static variable ,static block {depends on their appear order}
 *  2: child  static variable ,static block {depends on their appear order}
 *  3: parent instance variable ,ordinary block {depends on their appear order}
 *  4: parent Constructor function
 *  5: child  instance variable ,ordinary block {depends on their appear order}
 *  6: child  Constructor function
 */
class SubInitiatedOrder extends InitiatedOrder{
    public static String staticFieldSub="Sub staticFieldOne_OneState_1 ";

    static{
        System.out.println("Sub This is Second appear static context -> block_OneStage_2");
    }
    public String field="Sub ordinary Instance variable_TwoStage_1";

    {
        System.out.println("Sub This is Second appear normal context block_TwoStage_2");
    }
    public SubInitiatedOrder(){
        System.out.println("Sub Constructor function initiated..._ThirdStage_1");
    }
}

public class DataTypeForJava {
  /* In Integer class  use  IntegerCache
    private static class IntegerCache {
        static final int low = -128;
        static final int high;
        static final Integer cache[];

        static {
            // high value may be configured by property
            // the jvm method sun.misc.VM.getSavedProperty() can read property from
            // jvm start param:  -XX:AutoBoxCacheMax=<size>
            int h = 127;
            String integerCacheHighPropValue =
                    sun.misc.VM.getSavedProperty("java.lang.Integer.IntegerCache.high");
            if (integerCacheHighPropValue != null) {
                try {
                    int i = parseInt(integerCacheHighPropValue);
                    i = Math.max(i, 127);
                    // Maximum array size is Integer.MAX_VALUE
                    h = Math.min(i, Integer.MAX_VALUE - (-low) -1);
                } catch( NumberFormatException nfe) {
                    // If the property cannot be parsed into an int, ignore it.
                }
            }
            high = h;

            cache = new Integer[(high - low) + 1];
            int j = low;
            for(int k = 0; k < cache.length; k++)
                cache[k] = new Integer(j++);

            // range [-128, 127] must be interned (JLS7 5.1.7)
            assert Integer.IntegerCache.high >= 127;
        }

        private IntegerCache() {}
    }
*/
    /**
     * byte/8 char/16, short/16 int/32 float/32 long/64 double/64 boolean 1bit
     */
    public static void  primitiveDataType(){
        byte v1= 110;
    }

    /**
     * Autoboxing and Unboxing is java compile use auto Boxing and Unboxing
     */
    public static void autoBoxingAndUnboxing(){
        Integer x=2; // Integer.valueOf(2);
        int y =x;  // X.intValue();

        Integer x1 = new Integer(123);
        Integer x2= new Integer(123);
        System.out.println(x1 == x2); //false

        Integer z1= Integer.valueOf(124);
        Integer z2= Integer.valueOf(124);
        System.out.println(z1 == z2); // true  come from the cache pool


    }
    public static void AllAboutString(){
        String s="";
        StringBuffer sb= new StringBuffer(); // synchronized method
        StringBuilder sB = new StringBuilder();

/**
 * String literal e.g. “abc”
 * (anything which is inside double quotes are String literal in Java)
 * are maintained in a String pool.
 */
        String s1= new String("aaa");
        String s2= new String("aaa");
        System.out.println(s1 ==s2);
        /**
         *   * <p>
         *      * When the intern method is invoked, if the pool already contains a
         *      * string equal to this {@code String} object as determined by
         *      * the {@link #equals(Object)} method, then the string from the pool is
         *      * returned. Otherwise, this {@code String} object is added to the
         *      * pool and a reference to this {@code String} object is returned.
         *      * <p>
         *      * It follows that for any two strings {@code s} and {@code t},
         *      * {@code s.intern() == t.intern()} is {@code true}
         *      * if and only if {@code s.equals(t)} is {@code true}.
         *      * <p>
         */
        String s3=  s1.intern();
        String s4= s2.intern();
        System.out.println(s3 ==s4);

        /**
         * Basically doing String.intern() on a series of strings will ensure
         * that all strings having same contents share same memory.
         * So if you have list of names where 'john' appears 1000 times,
         * by interning you ensure only one 'john' is actually allocated memory.
         *
         * This can be useful to reduce memory requirements of your program.
         * But be aware that the cache is maintained by JVM in permanent memory pool
         * which is usually limited in size compared to heap
         * so you should not use intern if you don't have too many duplicate values.
         */
        String s5="bbb";
        String s6="bbb";
        // comparing is object reference
        System.out.println(s5==s6);

        /**
         * Returns the same hash code for the given object as
         *      * would be returned by the default method hashCode(),
         *      * whether or not the given object's class overrides
         *      * hashCode().
         */
        for(int i=0;i<10;i++){
            String s7="zimianliang";
            String temp = new String(s7);
            /**
             * first one:
             * 1)if zimianliang not  in String Pool,  then create a new "zimianliang" and add in String Pool
             * 2)  new  method create a String object with content 'zimianliang' in heap;
             *
             * second time:
             * 1) because ,at this time , there is a 'zimianliang' in String Pool, so just use it ,
             * 2) again, new another String objet in heap
             */
            System.out.println(Integer.toHexString(System.identityHashCode(temp))); //different
            System.out.println(Integer.toHexString(System.identityHashCode(s7))); //same
        }

        for(int i=0;i<10;i++){
            // System.out.println(Integer.toHexString(System.identityHashCode(s6))); // same
        }

    }
// --- object reference is passed by value  not by reference --- begin---
    private class Dog{
        String name;
        Dog(String name){
            this.name=name;
        }
        String getName(){
            return this.name;
        }
        void setName(String name){
            this.name=name;
        }
        String getObjectAddress(){
            /**
             *     public String toString() {
             *         return getClass().getName() + "@" + Integer.toHexString(hashCode());
             *     }
             */
            return super.toString();
        }
    }

    private  void passByValueExample(){
            Dog dog= new Dog("A");
            func(dog);
        System.out.println(dog.getName());
    }
    private static void func(Dog dog){
        dog.setName("B");
    }

    private  void passByValueExample2(){
        Dog dog= new Dog("A");   //0
        System.out.println(dog.getObjectAddress());
        func2(dog);
        System.out.println(dog.getObjectAddress()); // 1
        System.out.println(dog.getName());  //2
        // still A does not be effected by func2  dog= new Dog("B), object reference is passed by value
        // so in this method at  //1 and //2  dog is keep the  //0  value (point to a memory address)
    }
    private  void func2(Dog dog){
        System.out.println(dog.getObjectAddress());
        dog = new Dog("B");
        System.out.println(dog.getObjectAddress());
        System.out.println(dog.getName());

    }
// --- object reference is passed by value  not by reference --- end

    /**
     * A compound assignment expression of the form E1 op= E2 is equivalent to
     * E1= (T)((E1)op(E2)), where T is the type of E1
     *
     * += -= *= /=
     * ++ (+=) -- (-=)
     */
    public static void isCastingOrNot(){
       // float f= 1.1; // 1.1 literal type is double,so it can not cast to float
        float f= 1.1f; // 1.1f literal type is float Type.
        int i=1;  // 1 literal type is int
        /**
         * The short data type is a 16-bit signed Java primitive integer data type.
         * Its range is -32768 to 32767 (or -215 to 215 – 1)
         */
        short s1 = 32767 ; // this is ok, 1 in the range of short
        // s1= s1+1;   from int cast to short  is not available,

        System.out.println(s1++);
        System.out.println(s1); //32767 +1 > 32767  then execute implicit cast type to -32768
        s1 += 1; // -32767
        s1 = (short)(s1+1); // -32766
        System.out.println(s1); //
    }

    /**
     * Unlike if-then and if-then-else statements,
     * the switch statement can have a number of possible execution paths.
     * A switch works with the
     * byte, short, char, and int primitive data types.
     * It also works with enumerated types (discussed in Enum Types),
     * the String class, and a few special classes that wrap certain primitive types:
     * Character, Byte, Short, and Integer (discussed in Numbers and Strings).
     */
    public static void switchDemo(){
        String s="a";
        switch(s){
            case "a":
                System.out.println("a");
                break;
            case "b":
                System.out.println("bbb");
                break;
        }
    }

    public static void finalDemo(){
        final int x=1;
        // x=2; // can not assign a value to a final variable x
        final String y= new String("Hello");
       //  y="heoolo"
    }

    // class in final method in class
     private class Animal{
      public  final void sayHi(){
            System.out.println("hi");
        }

        private void sayBai(){
            System.out.println("bay");
        }
    }

    private final class Cat extends Animal{
//        void sayHi(){
//            System.out.println();
//        }
        void sayBi(){
            System.out.println("Cat say bay");
        }
    }
    // final class can not be extends
//    private class bosiCat extends  Cat{
//
//    }

    private void testFinal(){
        Cat cat= new Cat();
        cat.sayBi();
    }
    // end of final

    // --- static ----
    // static 1: static variable



    public static  void main(String[]args){
      // AllAboutString();
       DataTypeForJava dtfj = new DataTypeForJava();
        //dtfj.passByValueExample();
        // dtfj.passByValueExample2();
       // isCastingOrNot();
      // dtfj.testFinal();

       // finalDemo();

        A a= new A(1);

         // a.x=100;


        System.out.println(a.toString());

    }
}
