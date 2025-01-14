package org.example;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import static org.example.QuineMcCluskeyInput.getMinterms;
import static org.example.QuineMcCluskeyInput.getVariableNames;

public class Main {
    public static void main(String[] args) {
        List<String> headers = getVariableNames();
        int numVariables = headers.size();

        List<Integer> minterms = getMinterms(numVariables);

        // Sort minterms
        Collections.sort(minterms);

        // Convert minterms to binary format and split into bits for table display
        List<List<String>> data = minterms.stream()
                .map(minterm -> {
                    String binaryString = String.format("%" + numVariables + "s", Integer.toBinaryString(minterm)).replace(' ', '0');
                    List<String> row = binaryString.chars()
                            .mapToObj(c -> String.valueOf((char) c))
                            .collect(Collectors.toList());
                    row.addFirst(String.valueOf(minterm));
                    return row;
                })
                .collect(Collectors.toList());

        // Add an empty string as the first header to align with the minterms column
        headers.addFirst("");

        QuineMcCluskey table = new QuineMcCluskey(headers, data);
        System.out.println(table);

        // Generate and display the grouped table
        System.out.println(table.generateGroupedTable());
    }
}