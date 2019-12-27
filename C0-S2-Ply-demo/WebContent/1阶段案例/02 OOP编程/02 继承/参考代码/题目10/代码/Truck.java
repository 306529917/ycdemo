public class Truck extends Car {
    Truck(){
        super();
    }
    private double payload;
    public double getPayload() {
        return payload;
    }
    public void setPayload(double payload) {
        this.payload = payload;
    }
    public void payload(){
        if(payload<=1000){
            System.out.println("这辆车的载重是"+payload);
        }
        else{
            System.out.println("超重了");
        }
    }
}