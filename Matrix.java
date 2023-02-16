import java.util.ArrayList;
import java.util.List;

class Matrix{
    // holds the numbers in the matrix
    double [][] data;
    // holds the number of rows and columns
    int rows, cols;

    /**creates a matrix, initializing to random values*/
    public Matrix(int rows, int cols){
        this.rows = rows;
        this.cols = cols;
        data = new double[rows][cols];

        // initialize each value in the matrix to a random number between -1 and 1
        // for each row
        for (int i = 0; i < rows; i++){
            // for each column
            for (int j = 0; j < cols; j++){
                // between -1 and 1
                // *2 -> range is 2
                // -1 -> min value is -1
                data[i][j] = Math.random()*2-1;
            }
        }
    }

    //non-static operations, static ones are located in Utils.java
    public void add(double scaler)
        {
        for(int i=0;i<rows;i++)
        {
            for(int j=0;j<cols;j++)
            {
                this.data[i][j]+=scaler;
            }
            
        }
        }

        public void add(Matrix m)
        {
        if(cols!=m.cols || rows!=m.rows) {
            throw new IllegalArgumentException("Matrix dimensions must agree.");
        }

        for(int i=0;i<rows;i++)
        {
            for(int j=0;j<cols;j++)
            {
                this.data[i][j]+=m.data[i][j];
            }
        }
        }
        public void multiply(Matrix a) {
        for(int i=0;i<a.rows;i++)
        {
            for(int j=0;j<a.cols;j++)
            {
                this.data[i][j]*=a.data[i][j];
            }
        }
        
    }
    public void sigmoid() {
        for(int i=0;i<rows;i++)
        {
            for(int j=0;j<cols;j++)
                this.data[i][j] = 1/(1+Math.exp(-this.data[i][j])); 
        }
        
    }
    
    public Matrix dsigmoid() {
        Matrix temp=new Matrix(rows,cols);
        for(int i=0;i<rows;i++)
        {
            for(int j=0;j<cols;j++)
                temp.data[i][j] = this.data[i][j] * (1-this.data[i][j]);
        }
        return temp;
        
    }

    
    public void multiply(double a) {
        for(int i=0;i<rows;i++)
        {
            for(int j=0;j<cols;j++)
            {
                this.data[i][j]*=a;
            }
        }
        
    }
    public List<Double> toArray() {
        List<Double> temp= new ArrayList<Double>();
        
        for(int i=0;i<rows;i++)
        {
            for(int j=0;j<cols;j++)
            {
                temp.add(data[i][j]);
            }
        }
        return temp;
   }




    public void printMatrix(){
        // for each row
        for (int i = 0; i < rows; i++){
            // for each column
            for (int j = 0; j < cols; j++){
                // print the value
                System.out.print(data[i][j] + " ");
            }
            System.out.println();
        }
    }

    
}