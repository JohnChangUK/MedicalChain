package Cache;

public interface Computable<Input, Result> {

    Result compute(Input input) throws Exception;
}
