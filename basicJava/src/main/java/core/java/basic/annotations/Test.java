package core.java.basic.annotations;


class Apple{
    @FruitName("HongFuShi_china_shandong")
    private String name;

    @FruitColor(fruitColor = FruitColor.Color.RED)
    private String color;

    @FruitProvider(id=1090,name="Gold_Provider_First_ShanDong",address = "1880 Catalina Cres RichmondHill")
    private String provider;


}
public class Test {

    public static void main(String[] args) {
        FruitInfoUtil.getFruitInfoFromAnnotations(Apple.class);

    }
}
