public class Human extends Actor{

    public Human(String name) {
        super(name);
    }

    @Override
    public void setMakeOrder(boolean value) {
        this.isMakeOrder = value;
   }

    @Override
    public void setTakeOrder(boolean value) {
        this.isTakeOrder = value;
     }

    @Override
    public boolean isMakeOrder() {
        return isMakeOrder;  
    }

    @Override
    public boolean isTakeOrder() {
        return isTakeOrder;    
    }

    @Override
    public String getName() {
        return name;
    }
    
}
