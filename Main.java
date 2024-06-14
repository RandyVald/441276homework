public class Main {
    public static void main(String[] args) {
       
        Actor actor1 = new Human("Randy");
        Actor actor2 = new Human("Vadim");
        Actor actor3 = new Human("Stels");

        Market shop1 = new Market();
        System.out.printf("всего продано: %d \n", shop1.getTotalNumberOfSales());

        shop1.acceptToMarket(actor1);
        shop1.acceptToMarket(actor2);
        shop1.acceptToMarket(actor3);

        shop1.update();
        System.out.printf("всего продано: %d \n", shop1.getTotalNumberOfSales());

        shop1.acceptToMarket(new Human("Ivan"));
        shop1.acceptToMarket(new Human("Rustam"));
        shop1.acceptToMarket(new Human("Svetlana"));

        shop1.update();
        
        System.out.printf("всего продано: %d \n", shop1.getTotalNumberOfSales());

        shop1.update();

        System.out.printf("всего продано: %d \n", shop1.getTotalNumberOfSales());

        System.out.println("и так далее...");

    }
}
