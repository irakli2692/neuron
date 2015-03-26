package input;

import java.util.Random;

/**
 * Created by irakli on 3/19/2015.
 */
public class BinaryNeuronInput extends NeuronInput {


    private Random random;


    public BinaryNeuronInput() {
        random = new Random();
    }

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
