package Cache;

public class CacheDemo {

    public static void main(String[] args) throws Exception {
        final Computable<Integer, Long> fact = new Computable<Integer, Long>() {

            public Long compute(Integer input) {
                long temp = 1;
                for (int i = 1; i <= input; i++) {
                    temp = temp * i;
                }
                return temp;
            }
        };

        final Computable<Integer, Long> factorialCache = new Cache<Integer, Long>(fact);
        System.out.println(factorialCache.compute(5));
        System.out.println(factorialCache.compute(6));
        System.out.println(factorialCache.compute(2));
        System.out.println(factorialCache.compute(5));
        System.out.println(factorialCache.compute(5));
        System.out.println(factorialCache.compute(5));

    }
}
