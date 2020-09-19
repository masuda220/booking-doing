package example.domain.model.route;

import java.util.List;

/**
 * 輸送経路
 */
public class Route {
    Origin origin;
    Destination destination;

    @Override
    public String toString() {
        return "Route{" +
                "origin=" + origin +
                ", destination=" + destination +
                '}';
    }
}
