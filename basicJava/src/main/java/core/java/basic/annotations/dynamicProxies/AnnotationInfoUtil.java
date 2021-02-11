package core.java.basic.annotations.dynamicProxies;

import java.lang.reflect.Field;
import java.util.Map;

public interface AnnotationInfoUtil {

    Map<String,Object> getFieldAnnotationValue(Class<?>clazz,Class[] allAnnotationClass);

}
