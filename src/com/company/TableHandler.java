package com.company;

// Add own exception type cause of wrong statementType
public class TableHandler {
    public String handleStatement(String statementType, String tableName) {
        switch(statementType) {
            case "ADD":
                return "CREATE TABLE " + tableName;
            case "DELETE":
                return "DROP TABLE " + tableName;
            default:
                return "";

        }
    }
    String addAlterStatement(String tableName){
        return "ALTER TABLE " + tableName;
    }
}
