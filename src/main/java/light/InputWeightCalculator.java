package light;

/**
 * Created by irakli on 3/20/2015.
 */
public interface InputWeightCalculator {
    Integer getBorder(Integer inputsCount);

    Integer calculateWeight(Integer correctnessProbability);
}
