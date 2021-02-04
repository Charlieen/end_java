package core.java.basic.abstractAndInterface;

public abstract class AbstractClassExample {
    private static int x;
    private int y;

    public int getY(){
        return y;
    }
    private void func1(){
        System.out.println("I am func1 with Private");
    }
   // private abstract void func2(){}
    protected abstract void func2();
    public abstract void func3();

    public void func4(){
        System.out.println("I am func4 with Public");
    }

    public AbstractClassExample(int y){
        x= 1000+y;
        this.y=y;
    }
    public AbstractClassExample(int y,int x){
       this.x =x;
        this.y=y;
    }
    public AbstractClassExample(){
        System.out.println("I am Constructor of AbstractClassExample");
    }

}

/**
 * super is a pointer which point it's extends  parent class
 *
 * so can use  super() or super(1,3)  to visit parent constructor functions
 * so can use super.func4() to reference the parent method
 */
class Test {
    public static void main(String[] args) {
        //'AbstractClassExample' is abstract; cannot be instantiated
        // AbstractClassExample abstractClassExample = new AbstractClassExample();
        AbstractClassExample abstractClassExample = new AbstractClassExample(10) {
            @Override
            protected void func2() {

            }

            @Override
            public void func3() {

            }
        };
       // System.out.println(abstractClassExample.getY());
     //  new SubClass(80,99).func3();

       new SubClass(1,2,3).func3();

//       Test t= new Test();
//        SubClass2 subClass2=  t.new SubClass2(180,199);
//        subClass2.func3();

    }

    static class SubClass extends AbstractClassExample{

        private int y;
        public SubClass(int x,int y){
            super(x);
            this.y= y;
        }

        public SubClass(int x, int y,int z){
            super(x,y);
            this.y=z;
        }

        @Override
        protected void func2() {

        }

        @Override
        public void func3() {
            System.out.println("self y is"+this.y+" and parent y is"+super.getY());
            super.func4();
        }
    }
     class SubClass2 extends AbstractClassExample{

        private int y;
        public SubClass2(int x,int y){
            super(x);
            this.y= y;
        }

        @Override
        protected void func2() {

        }

        @Override
        public void func3() {
            System.out.println("self y is"+this.y+" and parent y is"+super.getY());
        }
    }
}
