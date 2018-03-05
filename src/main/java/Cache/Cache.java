package Cache;

import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;

public class Cache<Input, Result> implements Computable<Input, Result> {

    // Create HashMap
    private final Map<Input, Future<Result>> cacheMap = new ConcurrentHashMap<>();

    final Computable<Input, Result> computable;

    Cache(Computable<Input, Result> computable) {
        this.computable = computable;
    }

    public Result compute(Input input) throws Exception {
        Future<Result> result = cacheMap.get(input);
        if (result == null) {
            Callable<Result> eval = new Callable<Result>() {
                @Override
                public Result call() throws Exception {
                    return computable.compute(input);
                }
            };

            FutureTask<Result> futureResult = new FutureTask<>(eval);
            result = cacheMap.putIfAbsent(input, futureResult);

            if (result == null) {
                result = futureResult;
                futureResult.run();
            }
        }

        try {
            return result.get();
        } catch (InterruptedException e) {
        } catch (Exception e) {
            return null;
        }
        return result.get();
    }
}
