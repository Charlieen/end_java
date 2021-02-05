package core.java.basic.reflect;
import java.lang.reflect.Field;
import java.util.List;


public class FieldsExample {
}


 class FieldSpy<T> {
    public boolean[][] b = {{ false, false }, { true, true } };
    public String name  = "Alice";
    public List<Integer> list;
    public T val;

    public static void main(String[] args) {
        String[] args1={"FieldSpy","b"};
        try {
            Class<?> c = Class.forName(args1[0]);
            Field f = c.getField(args1[1]);
            System.out.format("Type: %s%n", f.getType());
            System.out.format("GenericType: %s%n", f.getGenericType());

            // production code should handle these exceptions more gracefully
        } catch (ClassNotFoundException x) {
            x.printStackTrace();
        } catch (NoSuchFieldException x) {
            x.printStackTrace();
        }
    }
}