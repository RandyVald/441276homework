import java.util.ArrayList;
import java.util.List;

public class Market implements MarketBehaviour, QueueBehaviour {

    private List<Actor> actorsFree = new ArrayList<>(); // Люди которые только вошли в магазин
    private List<Actor> actorsWithoutOrder = new ArrayList<>(); // Очередь на оформление заказа
    private List<Actor> actorsWithOrder = new ArrayList<>(); // Очередь на получение заказа
    private static int totalNumberOfSales;
    
    static{
        totalNumberOfSales = 0;
    }

    @Override
    public void acceptToMarket(Actor actor) {

        actorsFree.add(actor);

    }

    @Override
    public void releaseFromMarket(List<Actor> actors) {
        actors.remove(0);
    }

    @Override
    public void update() {
        // Первый шаг - все вновь зашедшие люди становятся в очередь на оформление
        // заказа
        for (int index = 0; index < actorsFree.size(); index++) {
            Actor currenActor = actorsFree.get(index);
            releaseFromQueue(currenActor, actorsFree);
            takeInQueue(currenActor, actorsWithoutOrder);

        }

        // первые в очереди обслуживаются
        takeOrders(); // приняли заказ
        giveOrders(); // выдали заказ

        // переходит в очередь на получение

        // Второй шаг - первый юнит в очереди на оформление заказа оформляет заказ и переходит в очередь на получение заказа
        if (!actorsWithoutOrder.isEmpty()) {
            Actor unit = actorsWithoutOrder.get(0);
            if (unit.isMakeOrder) {
                releaseFromQueue(unit, actorsWithoutOrder);
                takeInQueue(unit, actorsWithOrder);
            }
        }

        // Третий шаг - первый юнит в очереди на получение получает заказ и уходит из очереди
        if (!actorsWithOrder.isEmpty()) {
            Actor unit = actorsWithOrder.get(0);
            if (unit.isTakeOrder){
                releaseFromQueue(unit, actorsWithOrder);
                totalNumberOfSales++;
            }
        }

    }

    @Override
    public void giveOrders() {
        if (actorsWithOrder.isEmpty() == false) {
            actorsWithOrder.get(0).setTakeOrder(true); // первому в очреди на получение заказа выдать заказ
        }
    }

    @Override
    public void releaseFromQueue(Actor actor, List<Actor> actors) {
        actors.remove(actor);

    }

    @Override
    public void takeInQueue(Actor actor, List<Actor> actors) {
        actors.add(actor);
    }

    @Override
    public void takeOrders() {
        if (actorsWithoutOrder.isEmpty() == false) {
            actorsWithoutOrder.get(0).setMakeOrder(true); // первому в очереди на оформление заказа оформить заказ
        }
    }

    public int getTotalNumberOfSales(){
        return totalNumberOfSales;
    }

}
