package lab1;

import lab1.models.Matrix;
import lab1.utils.MatrixService;
import lab1.utils.Menu;

import static java.lang.Integer.*;

class Application {

    static void start() {
        Menu.printDevelopersName();
        int size = -1;

        while(size <= 0) {
            String sizeLine = Menu.getSize();
            size = validateAndConvertSize(sizeLine);
        }
        Matrix matrix = new Matrix(size);

        //заполняем матрицу случайными числами, выводим матрицу, считаем среднее арифметическое столбцов
        matrix = MatrixService.fillMatrixAndCalculateMeans(matrix);
        MatrixService.showMatrix(matrix);

        System.out.println();
        System.out.println("Result:");

        //меняем значения элементов матрицы и выводим
        matrix = MatrixService.changeElements(matrix);
        MatrixService.showMatrix(matrix);

    }

    private static int validateAndConvertSize(String sizeLine) {
        Integer size;
        try {
            size = parseInt(sizeLine);
        } catch(NumberFormatException e) {
            size = null;
        }

        if (size == null || size <= 0) {
            System.out.println("Invalid size");
            return -1;
        }

        return size;
    }
}
