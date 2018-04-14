package Reflection;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.Arrays;

public class ReflectionIntegerCache {

    public static void main(String[] args) {

        try {
            for (Class<?> clazz : Integer.class.getDeclaredClasses()) {
                Field cacheField = clazz.getDeclaredField("cache");
                cacheField.setAccessible(true);

                Field modifiersField = cacheField.getClass().getDeclaredField("modifiers");
                modifiersField.setAccessible(true);
                // Remove the 'Final' Modifier Keyword for the 'Integer cache[]' field
                modifiersField.set(cacheField, cacheField.getModifiers() & ~Modifier.FINAL);

                // Getting the actual cache, inside the Static IntegerCache class
                Integer[] cache = (Integer[]) cacheField.get(null);

                for (int i = 0; i < cache.length; i++) {
                    cache[i] = new Integer(-cache[i]);
                }
                // Update/set the value of the cacheField with the cache we just created. The object we are targetting is null because it is a static instance variable
                cacheField.set(null, cache);

                System.out.println(Arrays.toString(cache));

//                Arrays.stream(cache).map(x -> x + 1).forEach(System.out::print);

            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        int x = 0;
        System.out.println(x);

        // When you use AutoBoxing, it uses it's hidden 'Integer cache[]', which is final and static, therefore we can manipulate the end value of y
        Integer y = 1;
        System.out.println(y);

        Integer z = new Integer(3);
        System.out.println(z);
    }
}
