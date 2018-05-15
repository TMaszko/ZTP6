package com.company;

import java.util.Arrays;
import java.util.stream.Collectors;

class ParserSQL {
    private static TableHandler tableHandler = new TableHandler();
    private static ColumnHandler columnHandler = new ColumnHandler();

    static String parseMultipleStatements(String multipleStatement) {
        return String.join(";\n", Arrays.stream(multipleStatement.split(";")).map(String::trim).map(ParserSQL::parseSingleStatement).collect(Collectors.toList())) + ";";
    }

    private static String parseSingleStatement(String statement) {
        String[] splittedStatement = statement.split(" ");
        String statementType = splittedStatement[0];
        String tableName = splittedStatement[2];
        if(splittedStatement[1].equals("TABLE")) {
            return tableHandler.handleStatement(statementType, tableName);
        } else if(splittedStatement[1].equals("TO") || splittedStatement[1].equals("FROM")) {
            statementType = statementType + " " +splittedStatement[1];
            return tableHandler.addAlterStatement(tableName) + " " +
                    columnHandler.handleColumnStatement(statementType, Arrays.copyOfRange(splittedStatement,3, splittedStatement.length));
        }
        return "";

    }
}