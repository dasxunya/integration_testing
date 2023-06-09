package utils;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.Locale;

public interface Calculatable {
    default void writeToCSV(double initialX, double finalX, double eps, double step, String filePath) {
        String csvString;
        double res;
        try (PrintStream printStream = new PrintStream(new FileOutputStream(filePath))) {
            for (double i = initialX; i < finalX; i += step) {
                res = calculate(i, eps);
                csvString = String.format(Locale.US, "%f%s %f\n", i, ',', res);
                printStream.print(csvString);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    double calculate(double i, double eps);
}
