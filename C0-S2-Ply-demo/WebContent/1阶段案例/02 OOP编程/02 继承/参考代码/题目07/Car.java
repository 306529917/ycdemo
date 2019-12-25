public class Car extends Vehicle {
    private int loader;
    public int getLoader() {
        return loader;
    }
    public void setLoader(int loader) {
        this.loader = loader;
    }
    Car(){
        
    }
    Car(int wheels,double weight,int loader){
        super(wheels,weight);
        this.loader=loader;
    }
    public void loader(){
        if(loader<=6){
            System.out.println("这辆车能载"+loader+"人");
        }
        else{
            System.out.println("超员了");
        }
    }
}