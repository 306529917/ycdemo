public class TestXiYouJiRenWu {
    public static void main(String[] args) {
        XiYouJiRenWu zhuBaJie= new XiYouJiRenWu();
        XiYouJiRenWu sunWuKong= new XiYouJiRenWu();
        zhuBaJie.name="猪悟净";
        zhuBaJie.weapon="九齿钉耙";
        sunWuKong.name="孙悟空";
        sunWuKong.weapon="如意金箍棒";
        System.out.print(zhuBaJie.printName()+" ");
        System.out.println(zhuBaJie.pringtWeapon());
        System.out.print(sunWuKong.printName()+" ");
        System.out.println(sunWuKong.pringtWeapon());
    }
}