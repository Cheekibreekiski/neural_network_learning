import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.List;
import java.util.Scanner;
public class Main{
  static double [][] X= {
    {0,0},
    {1,0},
    {0,1},
    {1,1}
};
static double [][] Y= {
    {0},{1},{1},{0}
};
  //x - input values (name, gender)
  //y - target output (probability)


  // //read the name_gender.csv file
  // public static void loadData(){
  //   System.out.println("Loading data...");
  //   Scanner sc = new Scanner("name_gender.csv");
  //   //skip the first line
  //   System.out.println(sc.next());
    
  //   try {
  //     FileReader fr = new FileReader("name_gender.csv");
  //     sc = new Scanner(fr);

  //     sc.nextLine();
  //     sc.useDelimiter(",");
  //     //create the arrays
  //     //x - input values - name, gender
  //     X = new double[95026][2];
  //     //y - output value - probability
  //     Y = new double[95026][1];
      
  //     // int i = 0;
  //     // //read the file line by line
  //     // while(sc.hasNextLine()){
  //     //   String line = sc.nextLine();
  //     //   //split the line into an array
  //     //   String[] values = line.split(",");
  //     //   X[i][1] = 

  //     // }
      
      
  //   } catch (FileNotFoundException e) {
  //     e.printStackTrace();
  //   }

    
  // }

  public static void main(String[] args){
  //   then use the split method to split the line into an array
  //   then use the parseDouble method to convert the string to a double
  //   then add the double to the array
  //   then repeat for each line
    // loadData();
    //System.out.println(Double.parseDouble());
    //TODO rgb color matcher
  NeuralNetwork nn = new NeuralNetwork(2,10,1);
  nn.fit(X, Y, 50000);
  Scanner sc = new Scanner(System.in);
  while(true){
    System.out.println("Enter a number: ");
    int a = sc.nextInt();
    System.out.println("Enter another number: ");
    int b = sc.nextInt();
    if(a == -1 || b == -1){
      break;
    }
    double[] input = {a,b};
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
