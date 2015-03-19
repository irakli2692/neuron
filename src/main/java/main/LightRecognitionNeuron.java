package main;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by irakli on 3/20/2015.
 */
public class LightRecognitionNeuron {

    private List<NeuronInput> inputs;

    private InputWeightCalculator weightCalculator;

    public LightRecognitionNeuron(Integer inputsCount) {
        weightCalculator = DefaultWeightCalculatorFactory.create();

        inputs = new ArrayList<NeuronInput>();

        for (int i = 0; i < inputsCount; i++) {
            inputs.add(new NeuronInput(weightCalculator));
        }
    }

    public void train(Boolean correctAnswer) {
        for (NeuronInput input : inputs) {
            input.train(correctAnswer);
        }
    }

    public Boolean recognizeLight() {
        Integer resultsSum = 0;

        for (NeuronInput input : inputs) {
            resultsSum += input.getVoteResult();
        }

        Integer finalResult = resultsSum - weightCalculator.getBorder(inputs.size());

        return finalResult > 0;
    }
}
