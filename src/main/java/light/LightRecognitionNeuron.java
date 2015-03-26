package light;

import input.BinaryNeuronInput;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by irakli on 3/20/2015.
 */
public class LightRecognitionNeuron {

    private List<BinaryNeuronInput> inputs;

    private InputWeightCalculator weightCalculator;

    public LightRecognitionNeuron(Integer inputsCount) {
        weightCalculator = DefaultWeightCalculatorFactory.create();

        inputs = new ArrayList<BinaryNeuronInput>();

        for (int i = 0; i < inputsCount; i++) {
            inputs.add(new BinaryNeuronInput(weightCalculator));
        }
    }

    public void train(Boolean correctAnswer) {
        for (BinaryNeuronInput input : inputs) {
            input.train(correctAnswer);
        }
    }

    public Boolean recognizeLight() {
        Integer resultsSum = 0;

        for (BinaryNeuronInput input : inputs) {
            resultsSum += input.getVoteResult();
        }

        Integer finalResult = resultsSum - weightCalculator.getBorder(inputs.size());

        return finalResult > 0;
    }
}
