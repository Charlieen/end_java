package core.java.basic.abstractAndInterface;

/**
 * interface member default public (field and method)
 * all field must be initiated when the interface was defined
 */
public interface InterfaceExample {
     void func1();
    default void func2(int sub){
        System.out.println("This is In Interface,default method func2");
        System.out.println(sub+ x+y+z);
        // func4();
    }
    static void func3(){
        System.out.println("This is In Interface,static method func3");
        System.out.println(x+y+z);

    }
    // from java9 in interface method can be private
    // can defined some code and same time do not expose itself ,

//    private void func4(){
//        System.out.println("I am in private method in interface ");
//    }

    int x=1;
    int y=99;
    int z =0;
}

