import java.util.List;

public interface MarketBehaviour {

    void acceptToMarket(Actor actor); // вошел в магазин

    void releaseFromMarket(List<Actor> actors); // вышел из магазина

    void update(); // обновление
}
