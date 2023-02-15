class Matrix{
    // holds the numbers in the matrix
    double [][] data;
    // holds the number of rows and columns
    int rows, cols;

    // constructor
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