import java.util.ArrayList;
import java.util.List;

class MatrixUtils{
    public static Matrix add(Matrix m, double scalar){
        //adds a scalar to each value in the matrix
        Matrix temp = new Matrix(m.rows,m.cols);
        // for each row
        for (int i = 0; i < m.rows; i++){
            // for each column
            for (int j = 0; j < m.cols; j++){
                // add the scalar to the value
                temp.data[i][j] = m.data[i][j] + scalar;
            }
        }
        return temp;
    } 
    public static Matrix add(Matrix m, Matrix a){
        // adds a matrix to this matrix
        // the way this works is each value in the matrix is added to the value in the other 
        // matrix at the same position
        Matrix temp = new Matrix(m.rows,m.cols);

        // check if the matrices are the same shape
        if(m.rows != a.rows || m.cols != a.cols){
            System.out.println("Matrices must have the same dimensions to add!");
            return null;
        }

        //for each row
        for (int i = 0; i < m.rows; i++){
            // for each column
            for (int j = 0; j < m.cols; j++){
                // add the value from the other matrix to this matrix
                temp.data[i][j] = m.data[i][j] + a.data[i][j];
            }
        }
        return temp;
    }

    public static Matrix subtract(Matrix m, double scalar){
        // subtracts a scalar from each value in the matrix
        Matrix temp = new Matrix(m.rows,m.cols);
        // for each row
        for (int i = 0; i < m.rows; i++){
            // for each column
            for (int j = 0; j < m.cols; j++){
                // subtract the scalar from the value
                temp.data[i][j] = m.data[i][j] - scalar;
            }
        }
        return temp;
    }
    public static Matrix subtract(Matrix m, Matrix s){
        // subtracts a matrix from this matrix
        // each value in the matrix is subtracted from the value in the other 
        // matrix at the same position
        Matrix temp = new Matrix(m.rows,m.cols);

        // check if the matrices are the same shape
        if(m.rows != s.rows || m.cols != s.cols){
            System.out.println("Matrices must have the same dimensions to subtract!");
            return null;
        }

        //for each row
        for (int i = 0; i < m.rows; i++){
            // for each column
            for (int j = 0; j < m.cols; j++){
                // subtract the value from the other matrix from this matrix
                temp.data[i][j] = m.data[i][j] - s.data[i][j];
            }
        }
        return temp;
    }
    public static Matrix transpose(Matrix m){
        // transposes the matrix
        Matrix temp = new Matrix(m.cols,m.rows);

        // for each row
        for (int i = 0; i < m.rows; i++){
            // for each column
            for (int j = 0; j < m.cols; j++){
                // swap the values
                temp.data[j][i] = m.data[i][j];
            }
        }
        return temp;
    }

    public static Matrix multiply(Matrix a, Matrix b) {
        Matrix temp=new Matrix(a.rows,b.cols);
        for(int i=0;i<temp.rows;i++){
            for(int j=0;j<temp.cols;j++){
                double sum=0;
                for(int k=0;k<a.cols;k++)
                {
                    sum+=a.data[i][k]*b.data[k][j];
                }
                temp.data[i][j]=sum;
            }
        }
        return temp;
    }

    public static Matrix multiply(Matrix m, double scalar){
        // multiplies each value in the matrix by a scalar
        Matrix temp = new Matrix(m.rows,m.cols);
        // for each row
        for (int i = 0; i < m.rows; i++){
            // for each column
            for (int j = 0; j < m.cols; j++){
                // multiply the value by the scalar
                temp.data[i][j] = m.data[i][j] * scalar;
            }
        }
        return temp;
    }
    public Matrix sigmoid(Matrix m){
        // applies the sigmoid function to each value in the matrix
        Matrix temp = new Matrix(m.rows,m.cols);
        // for each row
        for (int i = 0; i < m.rows; i++){
            // for each column
            for (int j = 0; j < m.cols; j++){
                // apply the sigmoid function to the value
                temp.data[i][j] = 1/(1+Math.exp(-m.data[i][j]));
            }
        }
        return temp;
    }
    public Matrix dsigmoid(Matrix m){
        // applies the derivative of the sigmoid function to each value in the matrix
        Matrix temp = new Matrix(m.rows,m.cols);
        // for each row
        for (int i = 0; i < m.rows; i++){
            // for each column
            for (int j = 0; j < m.cols; j++){
                // apply the derivative of the sigmoid function to the value
                temp.data[i][j] = m.data[i][j] * (1-m.data[i][j]);
            }
        }
        return temp;
    }

    public static Matrix fromArray(double[] arr){
        // converts an array to a matrix
        Matrix temp = new Matrix(arr.length,1);
        // for each value in the array
        for (int i = 0; i < arr.length; i++){
            // set the value in the matrix to the value in the array
            temp.data[i][0] = arr[i];
        }
        return temp;
    }
    public static List<Double> toArray(Matrix m){
        // converts a matrix to an array
        List<Double> temp = new ArrayList<Double>();
        // for each row
        for (int i = 0; i < m.rows; i++){
            // for each column
            for (int j = 0; j < m.cols; j++){
                // add the value to the array
                temp.add(m.data[i][j]);
            }
        }
        return temp;
    }

    
}