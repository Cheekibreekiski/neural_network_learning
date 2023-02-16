import java.util.ArrayList;
import java.util.List;

public class NNMultiHiddenLayers {
    Matrix[] weights;
    Matrix[] biases;

    // for example, {2, 3, 4, 1} would have 2 input, 3 hidden, 4 hidden, and 1 output neuron
    int[] layers;

    double learningRate = 0.1;

    // (input neuron values multiplied by their respective weights)+bias = value of next neuron 

    public NNMultiHiddenLayers(int[] layers){
        this.layers = layers;
        
        //  -1 because we don't need weights for the input layer, 
        //  and we don't need biases for the output layer
        weights = new Matrix[layers.length-1];
        biases = new Matrix[layers.length-1];
        // initialize the weights and biases
        for(int i = 0; i < layers.length-1; i++){
            //create a matrix with the number of rows equal to the number of neurons in the next layer
            weights[i] = new Matrix(layers[i+1], layers[i]);
            //create a matrix with the number of rows equal to the number of neurons in the next layer
            biases[i] = new Matrix(layers[i+1], 1);
        }
    }

    /**
     * @param x input array
     */
    public List<Double> predict(double[] x){
        // multiply the input by the weights and add the bias for each neuron
        Matrix input = MatrixUtils.fromArray(x);
        // for each layer
        for(int i = 0; i < weights.length; i++){
            // multiply the weights by the input and add the bias
            Matrix hidden = MatrixUtils.multiply(weights[i], input);
            hidden.add(biases[i]);
            // apply the activation function
            hidden.sigmoid();
            // now repeat the process using the layer we just processed as
            // the input for the next layer
            input = hidden;
        }
        //  return the output of the final layer
        return input.toArray();
    }
/**
 * 
 * @param X inputs
 * @param Y target outputs
 */
public void train(double[] X, double[] Y){
    // multiply the input by the weights and add the bias for each neuron
    Matrix input = MatrixUtils.fromArray(X);
    List<Matrix> hiddenOutputs = new ArrayList<>();
    hiddenOutputs.add(input);
    // for each layer
    for(int i = 0; i < weights.length; i++){
        // multiply the weights by the input and add the bias
        Matrix hidden = MatrixUtils.multiply(weights[i], hiddenOutputs.get(i));
        hidden.add(biases[i]);
        // apply the activation function
        hidden.sigmoid();
        // now repeat the process using the layer we just processed as
        // the input for the next layer
        hiddenOutputs.add(hidden);
    }
    //  use gradient descent to adjust the weights and biases
    Matrix output = hiddenOutputs.get(hiddenOutputs.size() - 1);
    Matrix target = MatrixUtils.fromArray(Y);
    List<Matrix> errors = new ArrayList<>();
    errors.add(MatrixUtils.subtract(target, output));
    // backward pass
    for(int i = hiddenOutputs.size() - 2; i >= 0; i--){
        Matrix hidden = hiddenOutputs.get(i);
        Matrix outputDelta = MatrixUtils.multiply(errors.get(errors.size() - 1).multiply(hidden.dsigmoid()), learningRate);
        errors.add(MatrixUtils.multiply(MatrixUtils.transpose(weights[i]), errors.get(errors.size() - 1)));
        // update weights and biases
        weights[i].add(MatrixUtils.multiply(outputDelta, MatrixUtils.transpose(hiddenOutputs.get(i))));
        biases[i].add(outputDelta);
    }
}



    
    /**
     * @param X inputs
     * @param Y target outputs
     * @param epochs number of times to train the network
     */
    public void fit(double[][] X, double[][] Y, int epochs){
        // train the network for the specified number of epochs
        for(int i = 0; i < epochs; i++){
            // train the network for each set of inputs and outputs
            for(int j = 0; j < X.length; j++){
                train(X[j], Y[j]);
            }
        }
    }
}
