package minimization;

/**
 * Created by irakli on 3/26/2015.
 */
@FunctionalInterface
public interface MultiParameterFunction {

    double applyFunction(double... args);
}
