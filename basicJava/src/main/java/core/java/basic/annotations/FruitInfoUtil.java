package core.java.basic.annotations;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

public class FruitInfoUtil {

    public static void getFruitInfoFromAnnotations(Class<?> clazz){
        String [] fruitLabels={"水果名称：","水果颜色：","供应商信息："};
        Field[] fields = clazz.getDeclaredFields();
        List<String> result = new ArrayList<>();
        for(Field field:fields){
            if(field.isAnnotationPresent(FruitName.class)){
                FruitName fruitName= (FruitName) field.getAnnotation(FruitName.class);
                result.add(fruitLabels[0]+ fruitName.value());
            }
           else if(field.isAnnotationPresent(FruitColor.class)){
                FruitColor fruitColor= (FruitColor) field.getAnnotation(FruitColor.class);
                result.add(fruitLabels[1]+ fruitColor.fruitColor());
            }
           else if(field.isAnnotationPresent(FruitProvider.class)){
                FruitProvider fruitProvider= (FruitProvider) field.getAnnotation(FruitProvider.class);
                result.add(fruitLabels[2]+ fruitProvider.id() +" "+ fruitProvider.name()+" "+ fruitProvider.address());
            }
        }

        System.out.println(result);
    }
}
