

public class Network{
  public static void main(String[] args){
    Matrix m = new Matrix(3,3);
    m.printMatrix();
    m = Utils.transpose(m);
    System.out.println("");
    m.printMatrix();

  }

}
