package org.example;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import static org.example.QuineMcCluskeyInput.getMinterms;
import static org.example.QuineMcCluskeyInput.getVariableNames;

public class Main {
    public static void main(String[] args) {
        List<String> headers = getVariableNames();
        List<Integer> minterms = getMinterms(headers.size());

        // Sort minterms
        Collections.sort(minterms);

        // Convert minterms to string format for table display
        List<List<String>> data = minterms.stream()
                .map(minterm -> {
                    List<String> row = headers.stream().map(h -> "").collect(Collectors.toList());
                    row.add(0, String.valueOf(minterm));
                    return row;
                })
                .collect(Collectors.toList());

        // Add an empty string as the first header to align with the minterms column
        headers.add(0, "");

        QuineMcCluskey table = new QuineMcCluskey(headers, data);
        System.out.println(table);
    }
}