package core.java.basic.overrideOroverwrite;

import java.util.ArrayList;
import java.util.List;

public class ParentClass {

    protected List<Integer> func()throws Throwable{
        return new ArrayList<>();
    }
}

/** @Override
 *  in SubClass ,
 *  1: public > protected
 *  2: return type ArrayList < List
 *  3: throws Exception < Throwable
 *
 *  use @Override notation to let compile auto check above three restrict condition/factor/term/requirement/qualification
 */
class ChildClass extends ParentClass{
    @Override
    public ArrayList<Integer> func() throws Exception {
        return new ArrayList<>();
    }
}

class A{
    public void show(A obj){
        System.out.println("A.show(A)");
    }
    public void show(C obj){
        System.out.println("A.show(C)");
    }
}

class B extends A{
    @Override
    public void show(A obj) {
        System.out.println("B.show(A)");
    }
}

class C extends B{

}
class D extends  C{

}

class TestABCD{
    public static void main(String[] args) {
        A a= new A();
        B b= new B();
        C c= new C();
        D d= new D();

        d.show(d);
        d.show(b);

        a.show(d);
        a.show(b);
        a.show(a);

    }
}