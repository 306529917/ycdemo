public class Testcar {
    public static void main(String[] args){
        Car c=new Car(4,600,4);
        c.getInfo();
        c.loader();
        Truck t =new Truck();
        t.setLoader(3);
        t.setPayload(800);
        t.setWeight(1000);
        t.setWheels(6);
        t.getInfo();
        t.loader();
        t.payload();    
    }
}