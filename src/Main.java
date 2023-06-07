import com.sun.xml.internal.ws.util.StringUtils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {

        //чтение в буфер введенного значения
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));

        //регулярка на проверку, число или нет
        String reg = "^[0-9]+$";
        String regArray = "^[-+]?[0-9]*[.]?[0-9]+$";

        String sizeX;
        do {
            System.out.println("Введите количество столбцов матрицы: ");
            sizeX = buffer.readLine();
        } while (!(sizeX.matches(reg)) || sizeX.equals("0"));
        int arraySizeX = Integer.parseInt(sizeX);

        String sizeY;
        do {
            System.out.println("Введите количество строк матрицы: ");
            sizeY = buffer.readLine();
        } while (!(sizeY.matches(reg)) || sizeY.equals("0"));
        int arraySizeY = Integer.parseInt(sizeY);

        double[][] myArray = new double[arraySizeY][arraySizeX];

        String element;
        double sumElement = 0;
        for(int i = 0; i < arraySizeY; i++) {
            for(int j = 0; j < arraySizeX; j++){
                do {
                    System.out.printf("Введите %s.%s элемент массива: ", i, j);
                    element = buffer.readLine();
                } while (!(element.matches(regArray)));
                myArray[i][j] = Double.parseDouble(element);
            }
        }

        System.out.println("\nВывод первой строки матрицы на экран, где каждый элемент умножается на 3:");

        for(int i = 0; i < arraySizeX; i++){
            System.out.print(String.format("%.3f", (myArray[0][i] * 3)) + " | ");
        }

    }
}