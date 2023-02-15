class Utils{
    public Matrix add(Matrix m, double scalar){
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
    public Matrix add(Matrix m, Matrix a){
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

    public Matrix subtract(Matrix m, double scalar){
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
    
}