package core.java.basic.annotations.dynamicProxies;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

public class AnnotationsHandle implements InvocationHandler {

    private AnnotationInfoUtil object;
    private Map<String,Object> annotationsResult;

    public AnnotationsHandle(Class<?> clazz, Class[] annotateClasses){
         object = new AnnotationInfoUtilImp();
        this.annotationsResult= new HashMap<>();
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {


        if(method.getName().contains("get_field_annotations")){
//            annotationsResult = object.getFieldAnnotationValue();
        }
        return null;
    }

}
