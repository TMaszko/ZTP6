package com.company;

import java.util.Arrays;

public class ColumnHandler {

    String handleColumnStatement(String statementType, String[] args) {
        String columnName = args[1];
        switch(statementType) {
            case "ADD TO":
                return handleColumnProperty(args[0], Arrays.copyOfRange(args, 1, args.length));
            case "DELETE FROM":
                return deleteColumnHandle(columnName);
            default:
                return "";
        }
    }
    String handleColumnProperty(String property, String[] args) {
        String columnName = args[0];
        switch(property) {
            case "COLUMN":
                String dataType = args[1];
                return addColumnHandle(columnName, dataType);
            case "KEY":
                return addKeyHandle(columnName);
            default:
                return "";
        }
    }
    String addColumnHandle(String columnName, String dataType) {
        return "ADD " + columnName + " " + dataType;
    }
    String deleteColumnHandle(String columnName) {
        return "DROP COLUMN " + columnName;
    }
    String addKeyHandle(String columnName) {
        return "ADD PRIMARY KEY (" + columnName + ")";
    }
}
