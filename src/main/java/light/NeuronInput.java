package light;

import java.util.Random;

/**
 * Created by irakli on 3/19/2015.
 */
public class NeuronInput {

    private Integer rightAnswers;

    private Integer wrongAnswers;

    private Integer correctnessProbability;

    private Integer weight;

    private Random random;

    InputWeightCalculator weightCalculationStrategy;

    public NeuronInput(InputWeightCalculator calculationStrategy) {
        rightAnswers = 0;
        wrongAnswers = 0;
        correctnessProbability = 50;
        weightCalculationStrategy = calculationStrategy;
        weight = weightCalculationStrategy.calculateWeight(correctnessProbability);

        random = new Random();
    }

    private void calculateNewProbability() {

        assert rightAnswers + wrongAnswers != 0;

        correctnessProbability = rightAnswers * 100 / (rightAnswers + wrongAnswers);

    }

    public void train(Boolean correctAnswer) {
        Boolean inputsAnswer = random.nextBoolean();

        if (inputsAnswer == correctAnswer) {
            rightAnswers++;
        } else {
            wrongAnswers++;
        }

        calculateNewProbability();

        weight = weightCalculationStrategy.calculateWeight(correctnessProbability);
    }

    /**
     * @return decision with its weight
     */
    public Integer getVoteResult() {
        Integer decision = random.nextBoolean() ? 1 : 0;

        return weight * decision;
    }
}
