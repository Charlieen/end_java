package core.java.basic.dynamicProxies;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.*;
import java.util.stream.Collectors;

/**
 * build a class which  wrapping the real object and tracking timing of each method of the object;
 */

interface  Flag{
  String  testMethod1();

    String testMethod2(String s1,String s2);
}
class TestClass implements  Flag{

    public TestClass(){}
    public  String testMethod1(){
        for(int i=0;i<10000;i++){
            Math.sqrt(i);
        }

        return "Finished";
    }

    public String testMethod2(String s1,String s2){
        for (int i=0;i<10000;i++){
            if(i%2==0){
                s2=s2+Math.random()*10;
            }else{
                s2=s2.substring(0,s2.length()-2);
            }
        }
        return s1+" new S2 is :"+s2;
    }
}

class TimingTrack implements  InvocationHandler {


    private Object object;

    private Map<String,Method> evaluatedMethods;
    private Map<String,Long> evaluatedResult;


    public TimingTrack(Object o){
        this.object= o;
        this.evaluatedMethods= new HashMap<>();
        this.evaluatedResult= new HashMap<>();
//        Arrays.stream(o.getClass().getDeclaredMethods()).collect(Collectors.toList()).forEach(m->{
//            this.evaluatedMethods.put(m.getName(),m);
//
//        });
        for(Method method : o.getClass().getDeclaredMethods()){
            this.evaluatedMethods.put(method.getName(),method);
        }
    }

    private static String getAllArgs(Object[] args){
        List<String>  all = new ArrayList<>();
        String result="";
        Arrays.stream(args).collect(Collectors.toList()).forEach(x->{
            all.add(x.toString());
        });
        for(int i=0;i<all.size();i++){
            result += all.get(i);
        }
        return result;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {




        Object result= null;

        long begin = System.currentTimeMillis();

        System.out.println("begin time at :: " +begin);
        result = this.evaluatedMethods.get(method.getName()).invoke(object,args);
        long end = System.currentTimeMillis();
        this.evaluatedResult.remove(method.getName());
        this.evaluatedResult.put(method.getName(), end-begin);

        System.out.println("end time at :: "+ end);
        System.out.println("Used time with :: "+ String.valueOf(end-begin));

        return result;
    }



    public static void main(String[] args) {
        Flag  flag = (Flag) Proxy.newProxyInstance(TimingTrack.class.getClassLoader(),
                new Class[]{Flag.class},
                new TimingTrack( new TestClass()));

        System.out.println(flag.testMethod1());

        System.out.println(flag.testMethod2("A","B"));

    }

}

public class DynamicInvocationHandler1 implements InvocationHandler {

    private static Logger LOGGER = LoggerFactory.getLogger(DynamicInvocationHandler1.class);

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
//          LOGGER.info("Invoked method:{}", method.getName());
//          LOGGER.info("Proxy Object is:",proxy.getClass());

        System.out.println("Invoked method:{}"+ method.getName());

       // System.out.println("Proxy Object is:" + proxy.hashCode());
        return 42;
    }

    //Creating Proxy Instance
    public static void creatingProxyInstance(){
        Map proxyInstance = (Map) Proxy.newProxyInstance(DynamicInvocationHandler1.class.getClassLoader(),
                new Class[]{Map.class},
                new DynamicInvocationHandler1());

        System.out.println("Map's HashCode is: " + proxyInstance.hashCode());
        proxyInstance.put("key1","Hello Dynamic Proxy");

    }

    /**
     * The term Java functional interface was introduced in Java 8.
     * A functional interface in Java is an interface that contains only a single abstract (unimplemented) method.
     * A functional interface can contain default and static methods which do have an implementation, in addition to the single unimplemented method.
     *
     * In InvocationHandler interface, just is this one single abstract method, even though, this interface is wrote  in 1.3 version,
     * but in java 1.8 , functional interface was introduced, and in 1.8 compile, this interface was treated as absolutely/completely  as functional interface
     *     public Object invoke(Object proxy, Method method, Object[] args)
     *         throws Throwable;
     */
    public static void  lambdaExpressionsDemo(){
        Map proxyInstatnce = (Map) Proxy.newProxyInstance(DynamicInvocationHandler1.class.getClassLoader(),
                new Class[]{Map.class},
                (proxy,method,methodArgs)->{

//                    System.out.println("let me see what is proxy:"+ proxy);
//                    System.out.println("let me see what is methodArgs:"+ methodArgs);
                    if(method.getName().equals("get")){
                        return 42;
                    }else{
                        throw new UnsupportedOperationException(
                                "Unsupported method:" + method.getName()
                        );
                    }
                });

        System.out.println(proxyInstatnce.get("hello"));
        try {
            proxyInstatnce.put("key1","Hello Dynamic Proxy");
        }catch(UnsupportedOperationException e){
            System.out.println("I get a UnsupportedOperationException");
        }

    }

    public static void main(String[] args) {

         creatingProxyInstance();
       //  lambdaExpressionsDemo();


    }
}
