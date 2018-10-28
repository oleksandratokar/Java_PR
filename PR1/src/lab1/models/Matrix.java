package lab1.models;

public class Matrix {
    private Integer[][] matrixArray;

    private int size;

    public Matrix(int size) {
        matrixArray = new Integer[size][size];
        this.size = size;
    }

    public int getValue(int firstIndex, int secondIndex) {
        return this.matrixArray[firstIndex][secondIndex];
    }

    public void setValue(int firstIndex, int secondIndex, double value) {
        this.matrixArray[firstIndex][secondIndex] = (int)value;
    }

    public Integer[][] getMatrixArray() {
        return matrixArray;
    }

    public int getSize() {
        return size;
    }
}
