package light;

/**
 * Created by irakli on 3/20/2015.
 */
public class DefaultWeightCalculatorFactory {

    public static InputWeightCalculator create() {
        return new ActiveWeightCalculator();
    }
}
