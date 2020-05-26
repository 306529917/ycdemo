public class Test1 {
    public static void main(String[] args)  {
        Outter outter = new Outter();
        outter.new Inner().print();
    }
}
 
 
class Outter {
    private int a = 1;
    class Inner {
        private int a = 2;
        public void print() {
            int a = 3;
            /**
             * 	请在(1)，(2)，(3)处填写代码, 在控制台输出
             * 	2
             * 	3
             * 	1
             */
            System.out.println( (1) );
            System.out.println( (2) );
            System.out.println( (3) );
        }
    }
}
