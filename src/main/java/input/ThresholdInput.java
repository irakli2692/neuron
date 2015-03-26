package input;

/**
 * Created by irakli on 3/25/2015.
 */
public class ThresholdInput extends NeuronInput {

    private Integer answersNumber;

    private Integer wrongAnswers;

    private Double q;

    private Integer weight;


    @Override
    protected Boolean amICorrect(Integer correctAnswer) {
        return null;
    }

    @Override
    protected Integer getDecision() {
        return null;
    }

    @Override
    protected Integer getDefaultWeight() {
        return null;
    }
}
