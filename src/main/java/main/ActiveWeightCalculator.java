package main;

/**
 * Created by irakli on 3/20/2015.
 */
public class ActiveWeightCalculator implements InputWeightCalculator {
    @Override
    public Integer getBorder(Integer inputsCount) {
        return inputsCount * 40 * 40;
    }

    @Override
    public Integer calculateWeight(Integer correctnessProbability) {
        return correctnessProbability * correctnessProbability;
    }
}
