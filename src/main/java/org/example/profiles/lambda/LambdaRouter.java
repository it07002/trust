package org.example.profiles.lambda;




import java.util.HashMap;
import java.util.Map;

public class LambdaRouter {

    private final Map<String, LambdaActivity<?>> routes = new HashMap<>();

    public void register(String path, LambdaActivity<?> activity) {
        routes.put(path, activity);
    }

    public LambdaActivity<?> getActivity(String path) {
        return routes.get(path);
    }
}
