package org.example;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<String> headers = Arrays.asList("Column1", "Column2", "Column3");
        List<List<String>> data = Arrays.asList(
                Arrays.asList("Value1", "Value2", "Value3"),
                Arrays.asList("Value4", "Value5", "Value6"),
                Arrays.asList("Value7", "Value8", "Value9")
        );

        QuineMcCluskey table = new QuineMcCluskey(headers, data);
        System.out.println(table);
    }

}