
public class Cows {
    private int age;//牛的年纪
 
    public Cows(int age) {
        super();
        this.age = age;
    }
 
    public int getAge() {
        return age;
    }
 
    public void setAge(int age) {
        this.age = age;
    }
     
    /**
     * 生产母牛的条件：年纪得大于5岁，返回1头小母牛，如果小于5岁，则返回空
     * @return 小牛
     */
    public Cows produceCow() {
        if(age>5) {
            return new Cows(1);
        }
        return null;
    }
     
}