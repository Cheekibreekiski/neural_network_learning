import java.util.List;

public class NeuralNetwork{
    // weight input to hidden, weight hidden to output, bias hidden, bias output
    Matrix weights_ih, weights_ho, bias_h, bias_o;
    // learning rate
    double lr = 0.1;
    
    /**
     * 
     * @param i number of input nodes
     * @param h number of hidden nodes
     * @param o number of output nodes
     */
    public NeuralNetwork(int i, int h, int o){
        // initialize the weights and biases
        weights_ih = new Matrix(h,i);
        weights_ho = new Matrix(o,h);

        bias_h = new Matrix(h,1);
        bias_o = new Matrix(o,1);
    }
    /**
     * @param x input array
     * @return output array
     */
    public List<Double> predict(double[] x){
        // multiply the input by the weights and add the bias for each neuron
        
        // input nodes
        Matrix input = MatrixUtils.fromArray(x);
        
        // hidden nodes
        Matrix hidden = MatrixUtils.multiply(weights_ih,input);
        hidden.add(bias_h);
        // apply the activation function
        hidden.sigmoid();

        // output nodes
        Matrix output = MatrixUtils.multiply(weights_ho,hidden);
        output.add(bias_o);
        // apply the activation function
        output.sigmoid();

        // return the output
        return output.toArray();
    }
}