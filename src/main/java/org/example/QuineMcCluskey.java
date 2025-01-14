package org.example;

import java.util.List;

public class QuineMcCluskey {
    private List<String> headers;
    private List<List<String>> data;

    public QuineMcCluskey(List<String> headers, List<List<String>> data) {
        this.headers = headers;
        this.data = data;
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
