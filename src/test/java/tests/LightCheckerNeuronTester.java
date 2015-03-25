package tests;

import light.LightRecognitionNeuron;
import org.junit.Test;

import java.util.Random;

/**
 * Created by irakli on 3/20/2015.
 */
public class LightCheckerNeuronTester {

    LightRecognitionNeuron neuron = new LightRecognitionNeuron(5);

    @Test
    public void trainAndRecognizeLight() {
        Random random = new Random();

        for (int i = 0; i < 1000; i++) {
            neuron.train(random.nextBoolean());
        }

        neuron.train(true);
        neuron.train(false);
        neuron.train(true);

        assert neuron.recognizeLight() == true;
    }


}
