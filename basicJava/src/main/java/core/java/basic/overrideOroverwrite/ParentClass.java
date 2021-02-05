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

/** when call a method ,use this priority to find the method
 *  this.func(this)
 *  super.func(this) => top Class which parent is Object
 *  this.func(super)
 *  super.func(super)
 *
 * first : do not cast to upper ,and find by the inherit chain from bottom to up
 * second: if first can not be available,then cast to upper and then find by the inherit chain fro bottom to up
 */
class A{
    public void show(A obj){
        System.out.println("A.show(A)");
    }
    public void show(C obj){
        System.out.println("A.show(C)");
    }

    public void justA(){
        System.out.println("Just in A: justA()");
    }

    public void justA(A obj){
        System.out.println("Just in A With Type A: justA(A)");
    }

    public void justA(B obj){
        System.out.println("Just in A With Type A: justA(B)");
    }

    public void justD(A obj){
        System.out.println("Just in D:  D.justD(A)");
    }

    public void justD(D obj){
        System.out.println("Just in A:  D.justD(D)");
    }
}

class B extends A{
    @Override
    public void show(A obj) {
        System.out.println("B.show(A)");
    }

    public void show(B ojb){
        System.out.println("B.show(B)");
    }
}

class C extends B{
    public void show(C ojb){
        System.out.println("C.show(C)");
    }
}
class D extends  C{
    public void show(D ojb){
        System.out.println("D.show(D)");
    }

    public void justD(A obj){
        System.out.println("Just in D:  D.justD(A)");
    }

//    public void justD(C obj){
//        System.out.println("D.justD(C)");
//    }
}

class TestABCD{
    public static void main(String[] args) {
        A a= new A();
        B b= new B();
        C c= new C();
        D d= new D();

//        d.show(d);
//        d.show(b);
//
//        a.show(d);
//        a.show(b);
//        a.show(a);

//        d.justA();
//        d.show(c);

         //d.justA(b);

        d.justD(d);

    }
}