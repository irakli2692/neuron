package minimization;

/**
 * Created by irakli on 3/26/2015.
 */
public interface Minimizer {

    double[] findMinimumPoint(double[] startPoint, MultiParameterFunction function);
}
