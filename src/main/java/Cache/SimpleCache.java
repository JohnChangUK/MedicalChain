package Cache;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class SimpleCache<Input, Result> implements Computable<Input, Result> {

    private final Map<Input, Result> cacheMap = new ConcurrentHashMap<>();

    final Computable<Input, Result> computable;

    SimpleCache(Computable<Input, Result> computable) {
        this.computable = computable;
    }

    @Override
    public Result compute(Input input) throws Exception {
        Result result = cacheMap.get(input);
        if (result == null) {
            result = computable.compute(input);
            cacheMap.put(input, result);
        }

        return result;
    }
}
