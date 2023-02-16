
import java.util.List;
import java.util.Scanner;

public class Main{
  static double [][] X;
  static double [][] Y;


  public static void main(String[] args){
    //TODO rgb color matcher
    //givena random rgb color, determine if white or black text is more readable
    XORMultiLayer();


  }


//WORKS
public static void XOR(){
  System.out.println("Initializing...");
  X = new double[][]{
    {0,0},
    {1,0},
    {0,1},
    {1,1}
  };
  Y = new double[][]{
    {0},{1},{1},{0}
  };
  NeuralNetwork nn = new NeuralNetwork(2,10,1);
  System.out.println("Training...");
  nn.fit(X, Y, 50000);
  Scanner sc = new Scanner(System.in);
  while(true){
    System.out.println("type -1 to exit");
    System.out.println("Enter a boolean: (t or f)");
    String a = sc.nextLine();
    System.out.println("Enter another boolean: ");
    String b = sc.nextLine();
    if(a.equals("-1") || b.equals("-1")){
      sc.close();
      break;
    }
    int a1 = 0;
    int b1 = 0;
    if(a.equals("t")){
      a1 = 1;
    }else{
      a1 = 0;
    }

    if(b.equals("t")){
      b1 = 1;
    }else{
      b1 = 0;
    }

    double[] input = {a1,b1};
    List<Double> output = nn.predict(input);
    System.out.println(output);
    if(output.get(0) > 0.5){
      System.out.println("TRUE");
    }else{
      System.out.println("FALSE");
    }
 }
}


public static void XORMultiLayer(){
  System.out.println("Initializing...");
  X = new double[][]{
    {0,0},
    {1,0},
    {0,1},
    {1,1}
  };
  Y = new double[][]{
    {0},{1},{1},{0}
  };
  //2 input nodes, 2 hidden layers with 10 nodes each, 1 output node
  int[] layers = {2,10,10,1};

  NNMultiHiddenLayers nn = new NNMultiHiddenLayers(layers);
  
  System.out.println("Training...");
  nn.fit(X, Y, 50000);
  Scanner sc = new Scanner(System.in);
  while(true){
    System.out.println("type -1 to exit");
    System.out.println("Enter a boolean: (t or f)");
    String a = sc.nextLine();
    System.out.println("Enter another boolean: ");
    String b = sc.nextLine();
    if(a.equals("-1") || b.equals("-1")){
      break;
    }
    int a1 = 0;
    int b1 = 0;
    if(a.equals("t")){
      a1 = 1;
    }else{
      a1 = 0;
    }

    if(b.equals("t")){
      b1 = 1;
    }else{
      b1 = 0;
    }

    double[] input = {a1,b1};
    List<Double> output = nn.predict(input);
    System.out.println(output);
    if(output.get(0) > 0.5){
      System.out.println("TRUE");
    }else{
      System.out.println("FALSE");
    }
 }
}

}
