import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DataProviderTest extends secondClass {
    @DataProvider(name = "Data")
    public double[][] arraysData() throws IOException {
        return readCSV("data.csv");
    }

    @Test(dataProvider = "Data")
    public void All_Squares(double[] dataOne) {
        secondClass.PrintingDoubleArray(dataOne);
        double[] testdata = new double[2];
        testdata[0] = dataOne[0];
        testdata[1] = dataOne[1];
        double expected = dataOne[2];
        int result = firstClass.All_Square(testdata[0], testdata[1]);
        Assert.assertEquals(result, expected);
    }

    private double[][] readCSV(String fileName) throws IOException {
        List<double[]> data = new ArrayList<>();
        try (FileReader reader = new FileReader("src/main/resources/" + fileName);
             CSVParser csvParser = CSVFormat.DEFAULT.withDelimiter(',').parse(reader)) {
            int count = 0;
            for (CSVRecord csvRecord : csvParser) {
                double[] values = new double[csvRecord.size()];
                for (int i = 0; i < csvRecord.size(); i++) {
                    if (count > 0){
                        values[i] = Double.parseDouble(csvRecord.get(i));
                    }
                }
                count++;
                data.add(values);
            }
        }
        double[][] dataOne = new double[data.size()-1][3];
        for(int i = 0; i < data.size()-1;i++) {
            dataOne[i] = data.get(i+1);
            secondClass.PrintingDoubleArray(dataOne[i]);
        }
        return dataOne;
    }
}
