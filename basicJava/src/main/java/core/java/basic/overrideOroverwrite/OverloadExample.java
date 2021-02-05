package core.java.basic.overrideOroverwrite;

/**
 * Overload
 *
 * in same class, one method  and another method
 * 1: same name
 * 2: return type is same
 * 3: param: in (type,count,sequence) at least has on different
 */
public class OverloadExample {
    public void show(int x){
        System.out.println(x);
    }

    public void show(int x,int y){
        System.out.println(x+"  "+ y);
    }

    public static void main(String[] args) {
        OverloadExample overloadExample= new OverloadExample();

        overloadExample.show(1);
        overloadExample.show(1,2);
    }
}
