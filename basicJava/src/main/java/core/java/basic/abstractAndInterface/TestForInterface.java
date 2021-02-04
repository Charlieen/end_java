package core.java.basic.abstractAndInterface;

class ImplClass implements InterfaceExample{

    @Override
    public void func1() {
        System.out.println("In ImplClass");
        System.out.println(InterfaceExample.x +10000);
       // Non-static method 'func2()' cannot be referenced from a static context
      //  InterfaceExample.func2();
        InterfaceExample.func3();
    }
    public static void impFunc1(){
        InterfaceExample.func3();
        ImplClass implClass = new ImplClass();
        implClass.func2(100);
    }

    public void func2(){

    }

    public  static void main(String[]args){
        //InterfaceExample.func2();
//        ImplClass implClass = new ImplClass();
//        implClass.func2();
        impFunc1();
    }
}
public class TestForInterface {


}
