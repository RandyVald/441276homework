import java.util.List;

public interface QueueBehaviour {

    void takeInQueue(Actor actor, List<Actor> actors);

    void takeOrders(); //сделать заказ

    void giveOrders(); //забрать заказ

    void releaseFromQueue(Actor actor, List<Actor> actors); //выйти из очереди

}
