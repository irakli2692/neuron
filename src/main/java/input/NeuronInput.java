package input;

/**
 * Created by irakli on 3/25/2015.
 */
public abstract class NeuronInput {
    /**
     * decision with its weight
     *
     * @return
     */
    protected Integer answersNumber;

    protected Integer wrongAnswers;

    protected Double q;

    protected Integer weight;

    public NeuronInput() {
        answersNumber = 0;
        wrongAnswers = 0;
        q = 0.5;
        weight = getDefaultWeight();
    }

    private void calculateNewProbability() {
        assert answersNumber != 0;

        q = wrongAnswers.doubleValue() / answersNumber.doubleValue();
    }

    public Integer getVoteResult() {
        return getDecision() * weight;
    }

    public void train(Integer correctAnswer) {
        answersNumber++;

        if (!amICorrect(correctAnswer)) {
            wrongAnswers++;
        }

        calculateNewProbability();
    }

    /**
     * input's probability of wrong answer
     *
     * @return
     */
    public Double getQ() {
        return q;
    }

    Integer getWeight() {
        return weight;
    }

    void setWeight(Integer weight) {
        this.weight = weight;
    }

    protected abstract Boolean amICorrect(Integer correctAnswer);

    protected abstract Integer getDecision();

    protected abstract Integer getDefaultWeight();
}
