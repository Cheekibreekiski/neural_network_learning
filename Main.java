public class Main{
  public static void main(String[] args){
    static double [][] X= {
            {0,0},
            {1,0},
            {0,1},
            {1,1}
    };
static double [][] Y= {
            {0},{1},{1},{0}
    };
  NeuralNetwork nn = new NeuralNetwork(2,10,1);
  nn.fit(X, Y, 50000);

    
  }

}
