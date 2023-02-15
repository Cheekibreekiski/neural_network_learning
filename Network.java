

public class Network{
  public static void main(String[] args){
    // create a matrix with 2 rows and 3 columns
    Matrix m = new Matrix(2,3);
    // print the matrix
    m.printMatrix();
    System.out.println("");
    m = Utils.multiply(m, 2);
    m.printMatrix();

  }

}
