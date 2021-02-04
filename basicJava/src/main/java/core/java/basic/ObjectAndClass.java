package core.java.basic;

import java.util.Arrays;
import java.util.Objects;

class ObjectGeneralMethods{
    static void isEquals(){
       Integer x= new Integer(1);
       Integer y = new Integer(1);
        System.out.println(x==y);//false
        System.out.println(x.equals(y));//true
    }

    class EqualExample{
        private int x;
        private int y;

        public EqualExample(int x,int y){
            this.x=x;
            this.y=y;
        }

        @Override
        public boolean equals(Object o) {
            if(this == o)return true;  // reference value isEqual
            if(o==null || getClass() != o.getClass()) return false; // type is isEqual
            EqualExample that =(EqualExample) o;  // Type cast
            if(x!= that.x) return false;  // check each filed is Equal
            return y == that.y;
        }
        @Override
        public int hashCode() {
            return Objects.hash(x, y);
        }
    }


    public static void main(String[]args){
        isEquals();


    }
}

class ToStringExample{
    private int number;
    public ToStringExample(int number){
        super();
        this.number= number;
    }

    /**
     public String toString() {
     return getClass().getName() + "@" + Integer.toHexString(hashCode());
     }

     */
    public static void main(String[]args){

        ToStringExample example = new ToStringExample(10);

        System.out.println(example);

    }
}

class CloneExample implements Cloneable{
    public int a;
    public int b;

public CloneExample(int a,int b){
    this.a=a;
    this.b=b;
}
    /**
     *
     * <p>
     * The method {@code clone} for class {@code Object} performs a
     * specific cloning operation. First, if the class of this object does
     * not implement the interface {@code Cloneable}, then a
     * {@code CloneNotSupportedException} is thrown. Note that all arrays
     * are considered to implement the interface {@code Cloneable} and that
     * the return type of the {@code clone} method of an array type {@code T[]}
     * is {@code T[]} where T is any reference or primitive type.
     * Otherwise, this method creates a new instance of the class of this
     * object and initializes all its fields with exactly the contents of
     * the corresponding fields of this object, as if by assignment; the
     * contents of the fields are not themselves cloned. Thus, this method
     * performs a "shallow copy" of this object, not a "deep copy" operation.
     * <p>
     */
    @Override
    protected CloneExample clone()  throws CloneNotSupportedException {

        return (CloneExample)super.clone();
    }
/**
 * object clone is deep copy, they are different object, having different address in memory
 */
    public static void main(String[]args) throws CloneNotSupportedException {
    CloneExample cloneExample = new CloneExample(1,2);
    // cloneExample.clone(); // in Object clone is protected

        CloneExample clone1= cloneExample.clone();
        clone1.a=100;
        System.out.println(clone1.a);
        System.out.println(Integer.toHexString(System.identityHashCode(clone1)));
        System.out.println(cloneExample.a);
        System.out.println(Integer.toHexString(System.identityHashCode(cloneExample)));

    }
}

class ShallowCloneExample implements Cloneable{
    private int[] arr;
    public ShallowCloneExample(){
        arr= new int[10];
        for(int i=0;i<10;i++){
            arr[i]=i;
        }
    }
    public void set(int index,int value){
        arr[index]=value;
    }
    public int get(int index){
        return arr[index];
    }

    @Override
    protected ShallowCloneExample clone() throws CloneNotSupportedException {
        return (ShallowCloneExample) super.clone();
    }

    /**
     *shallow copy ,  e2.arr and e1.arr point to the same instance variable
     */
    public static void main(String[]args){
     ShallowCloneExample e1= new ShallowCloneExample();
     ShallowCloneExample e2 =null;
        try {
            e2=e1.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        e1.set(0,100);
        System.out.println(e1.arr);
        System.out.println(e2.arr);
        Arrays.stream(e1.arr).forEach(System.out::println);
        System.out.println("----");
        Arrays.stream(e2.arr).forEach(System.out::println);

    }

}


class DeepCloneExample implements Cloneable{
    private int[] arr;
    public DeepCloneExample(){
        arr= new int[10];
        for(int i=0;i<10;i++){
            arr[i]=i;
        }
    }
    public void set(int index,int value){
        arr[index]=value;
    }
    public int get(int index){
        return arr[index];
    }

    @Override
    protected DeepCloneExample clone() throws CloneNotSupportedException {
        DeepCloneExample result = (DeepCloneExample) super.clone();
        result.arr = new int[arr.length];

        for(int i=0;i<arr.length;i++){
            result.arr[i]=arr[i];
        }
        return result;
    }

    /**
     *deep copy ,  e2.arr and e1.arr point to the different reference address
     * and with different instance variable
     */
    public static void main(String[]args){
        DeepCloneExample e1= new DeepCloneExample();
        DeepCloneExample e2 =null;
        try {
            e2=e1.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        e1.set(0,100);
        System.out.println(e1.arr);
        System.out.println(e2.arr);
        Arrays.stream(e1.arr).forEach(System.out::println);
        System.out.println("----");
        Arrays.stream(e2.arr).forEach(System.out::println);

    }

}
public class ObjectAndClass {


    public static void main(String[]args){

    }
}
