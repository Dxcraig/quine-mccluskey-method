package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class QuineMcCluskey {
    private List<String> headers;
    private List<List<String>> data;

    public QuineMcCluskey(List<String> headers, List<List<String>> data) {
        this.headers = headers;
        this.data = data;
    }

    public String generateGroupedTable() {
        StringBuilder sb = new StringBuilder();
        Map<Integer, List<List<String>>> groupedData = new TreeMap<>();

        // Group data by the number of ones in the binary representation
        for (List<String> row : data) {
            int minterm = Integer.parseInt(row.get(0));
            int onesCount = Integer.bitCount(minterm);
            groupedData.computeIfAbsent(onesCount, k -> new ArrayList<>()).add(row);
        }

        // Create new headers
        List<String> newHeaders = new ArrayList<>();
        newHeaders.add("Group");
        newHeaders.add("Minterm");
        newHeaders.addAll(headers.subList(1, headers.size()));

        // Calculate column widths
        int[] columnWidths = new int[newHeaders.size()];
        for (int i = 0; i < newHeaders.size(); i++) {
            columnWidths[i] = newHeaders.get(i).length();
        }
        for (List<List<String>> group : groupedData.values()) {
            for (List<String> row : group) {
                for (int i = 0; i < row.size(); i++) {
                    columnWidths[i] = Math.max(columnWidths[i], row.get(i).length());
                }
            }
        }

        // Append new headers
        for (int i = 0; i < newHeaders.size(); i++) {
            sb.append(String.format("%-" + columnWidths[i] + "s ", newHeaders.get(i)));
        }
        sb.append("\n");

        // Append grouped data rows
        for (Map.Entry<Integer, List<List<String>>> entry : groupedData.entrySet()) {
            int group = entry.getKey();
            for (List<String> row : entry.getValue()) {
                sb.append(String.format("%-" + columnWidths[0] + "s ", group));
                sb.append(String.format("%-" + columnWidths[1] + "s ", "m" + row.get(0)));
                for (int i = 1; i < row.size(); i++) {
                    sb.append(String.format("%-" + columnWidths[i + 1] + "s ", row.get(i)));
                }
                sb.append("\n");
            }
        }

        return sb.toString();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        int[] columnWidths = new int[headers.size()];

        // Calculate column widths
        for (int i = 0; i < headers.size(); i++) {
            columnWidths[i] = headers.get(i).length();
        }
        for (List<String> row : data) {
            for (int i = 0; i < row.size(); i++) {
                columnWidths[i] = Math.max(columnWidths[i], row.get(i).length());
            }
        }

        // Append headers
        for (int i = 0; i < headers.size(); i++) {
            sb.append(String.format("%-" + columnWidths[i] + "s ", headers.get(i)));
        }
        sb.append("\n");

        // Append data rows
        for (List<String> row : data) {
            for (int i = 0; i < row.size(); i++) {
                sb.append(String.format("%-" + columnWidths[i] + "s ", row.get(i)));
            }
            sb.append("\n");
        }

        return sb.toString();
    }
}