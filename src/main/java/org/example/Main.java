package org.example;

public class Main {

    public static void main(String[] args) {
        try {
//            System.out.println("PossibleSQLInjections Select: mario");
//            PossibleSQLInjections.queryWithPossibleSQLInjectionSelectStmt("mario");
//
//            System.out.println("PossibleSQLInjections Update: mario, hahahahaah@email.com");
//            PossibleSQLInjections.queryWithPossibleSQLInjectionUpdateStmt("mario", "mario'; DROP TABLE users; --");

//            System.out.println("NoPossibleSQLInjections Select: mario");
//            NoPossibleSQLInjections.noPossibleSqlInjectionsSelectStmt("mario");
//            System.out.println("NoPossibleSQLInjections Update: mario, sqlinjections@email.com");
//            NoPossibleSQLInjections.noPossibleSqlInjectionUpdateStmt("mario", "sqlinjections@email.com'; DROP TABlE users;--");
//
//            NoPossibleSQLInjections.noPossibleSqlInjectionsSelectStmt("mario");
            System.out.println("StoredProcedures Update Userid: 1, Mail: ert");
            StoredProcedures.callStoredProcedures(1, "ert'; DROP TABLE users;--");

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}