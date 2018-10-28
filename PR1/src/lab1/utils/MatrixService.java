package lab1.utils;

import lab1.models.Matrix;

import java.util.Random;

public class MatrixService {
    private static double[][] arithmeticMeans;

    //отнимает среднее арифметическое от каждого элемента
    public static Matrix changeElements(Matrix matrix) {
        for(int i = 0; i < matrix.getSize(); i++) {
            for(int j = 0; j < matrix.getSize(); j++) {
                matrix.setValue(j,i,matrix.getValue(j, i) - arithmeticMeans[0][i]);
            }
        }

        return matrix;
    }

    //заполняет матрицу случайными числами
    public static Matrix fillMatrixAndCalculateMeans(Matrix matrix) {
        Random rnd = new Random();

        for(int i = 0; i < matrix.getSize(); i++) {
            for(int j = 0; j < matrix.getSize(); j++) {
                matrix.setValue(i, j, rnd.nextInt(100));
            }
        }

        //считаем среднее арифметическое столбцов
        arithmeticMeans = calculateArithmeticMeans(matrix);

        return matrix;
    }

    //выводит матрицу
    public static void showMatrix(Matrix matrix) {
        for(int i = 0; i < matrix.getSize(); i++) {
            for(int j = 0; j < matrix.getSize(); j++) {
                System.out.print(matrix.getValue(i, j));
                System.out.print(' ');
            }
            System.out.println();
        }
    }

    //считает среднее арифметическое столбцов
    private static double[][] calculateArithmeticMeans(Matrix matrix) {
        double[][] means = new double[1][matrix.getSize()];
        double currentMean;
        for(int i = 0; i < matrix.getSize(); i++) {
            currentMean = 0;
            for(int j = 0; j < matrix.getSize(); j++) {
                currentMean += matrix.getValue(j, i);
            }
            means[0][i] = currentMean / matrix.getSize();
        }
        return means;
    }
}
