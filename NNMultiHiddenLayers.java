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
        //  use gradient descent to adjust the weights and biases
        //  WARNING: here be dragons
        //  a lot of calculus, i have no idea what it does, need to research more
        
        //  calculate the error
        Matrix output = input;
        Matrix target = MatrixUtils.fromArray(Y);
        Matrix error = MatrixUtils.subtract(target, output);
        //  calculate the gradient
        Matrix gradient = output.dsigmoid();
        gradient.multiply(error);
        gradient.multiply(learningRate);
        //  calculate the deltas
        // deltas are the change in the weights and biases
        Matrix hidden_T = MatrixUtils.transpose(input);
        Matrix weight_ho_deltas = MatrixUtils.multiply(gradient, hidden_T);
        //  adjust the weights by deltas
        
        Matrix weights_T = MatrixUtils.transpose(weights[weights.length-1]);
        weights_T.add(weight_ho_deltas);
        weights[weights.length-1] = MatrixUtils.transpose(weights_T);
        //  adjust the biases by its deltas (which is just the gradient)
        biases[biases.length-1].add(gradient);
        //  calculate the hidden layer errors
        Matrix who_t = MatrixUtils.transpose(weights[weights.length-1]);
        Matrix hidden_errors = MatrixUtils.multiply(who_t, error);
        //  calculate the hidden gradient
        Matrix hidden_gradient = input.dsigmoid();
        hidden_gradient.multiply(hidden_errors);
        hidden_gradient.multiply(learningRate);
        //  calculate the input->hidden deltas
        Matrix inputs_T = MatrixUtils.transpose(MatrixUtils.fromArray(X));
        Matrix weight_ih_deltas = MatrixUtils.multiply(hidden_gradient, inputs_T);
        //  adjust the weights by deltas
        Matrix weights_ih_T = MatrixUtils.transpose(weights[0]);
        weights_ih_T.add(weight_ih_deltas);
        weights[0] = MatrixUtils.transpose(weights_ih_T);
        //  adjust the biases by its deltas (which is just the gradient)
        biases[0].add(hidden_gradient);
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
