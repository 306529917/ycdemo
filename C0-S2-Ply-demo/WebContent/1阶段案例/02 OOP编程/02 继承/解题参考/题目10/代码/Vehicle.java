public class Vehicle {
    private int wheels;
    private double weight;
    public int getWheels() {
        return wheels;
    }
    public void setWheels(int wheels) {
        this.wheels = wheels;
    }
    public double getWeight() {
        return weight;
    }
    public void setWeight(double weight) {
        this.weight = weight;
    }
    Vehicle(){
        
    }
    Vehicle(int wheels,double weight){
        this.wheels=wheels;
        this.weight=weight;
    }
    public void getInfo(){
        System.out.println("车轮的个数是："+wheels+" 车重："+weight);
    }
}