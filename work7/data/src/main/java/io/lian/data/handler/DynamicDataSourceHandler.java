package io.lian.data.handler;

/**
 * @author m809745357
 */
public class DynamicDataSourceHandler {
    private static final ThreadLocal<String> ROUTE_KEY = new ThreadLocal<>();

    public static String getRouteKey() {
        return ROUTE_KEY.get();
    }

    public static void setRouteKey(String routeKey) {
        ROUTE_KEY.set(routeKey);
    }

    public static void remove() {
        ROUTE_KEY.remove();
    }
}
