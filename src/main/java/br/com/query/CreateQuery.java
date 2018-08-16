package br.com.query;

import br.com.connection.ConnectionFactory;
import br.com.table.column.AddColumn;

import java.sql.*;
import java.util.*;

public class CreateQuery {

    static Connection con = new ConnectionFactory().getConnection();
    static Statement stmt = null;
    static String values = "?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?," +
            "?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?," +
            "?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?," +
            "?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?," +
            "?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?," +
            "?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?," +
            "?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?," +
            "?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?," +
            "?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?," +
            "?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?" ;

    public static void createSchema(String nameSchema) throws SQLException {
        System.out.println("Creating schema");
        stmt = con.createStatement();
        String sql = "CREATE SCHEMA IF NOT EXISTS " + nameSchema + "";

        stmt.executeUpdate(sql);
        System.out.println("schema foi criado com sucesso!...");
    }

    public static void createIndex(String nomeIndex) throws SQLException {
        System.out.println("Creating index");
        stmt = con.createStatement();
        String sql = "CREATE INDEX " + nomeIndex + "_idx ON " + nomeIndex + " (id)";

        stmt.executeUpdate(sql);
        System.out.println("index foi criado com sucesso!...");
    }

    public static void createDataBase(String nameDataBase) throws SQLException {
        System.out.println("Creating table in given database...");
        stmt = con.createStatement();
        String sql = "CREATE DATABASE " + nameDataBase + "";
        stmt.executeUpdate(sql);
        System.out.println("Created table in given database...");
    }

    public static void createTable(String nameTable) throws SQLException {

        String primaryKey = random();

        System.out.println("Creating table in given database...");
        stmt = con.createStatement();
        String sql = "CREATE TABLE " + nameTable +
                "(id BIGSERIAL NOT NULL CONSTRAINT " + primaryKey + "_id PRIMARY KEY)";
        stmt.executeUpdate(sql);
        System.out.println("Created table in given database...");
    }

    public static String random() {
        String p = "p";
        Random r = new Random();
        String id = String.valueOf(r.nextInt(101));
        String k = "k";
        Random rr = new Random();
        String idd = String.valueOf(rr.nextInt(1001));
        return p.concat(id).concat(k).concat(idd);
    }

    public static void addConlumnOfTheTable(String nameTable, String nameColumn, String dataType) throws SQLException {
        System.out.println("Alter Table isert conlum and type ...");
        stmt = con.createStatement();
        String sql = "ALTER TABLE " + nameTable + " ADD " + nameColumn + " " + dataType + "";
        stmt.execute(sql);
        System.out.println("Created colum in given database...");
    }

    public static void addConstraintNotNullConlumn(String nameTable, String nameColumn) throws SQLException {
        System.out.println("Add Constraint NOT NULL...");
        stmt = con.createStatement();
        String sql = "ALTER TABLE " + nameTable + " ALTER COLUMN " + nameColumn + " SET NOT NULL";
        stmt.execute(sql);
        System.out.println("Constraint add in given database...");
    }

    public static void addForeignKey(String nameTable1, String nameTable2) throws SQLException {
        String id = "id";
        System.out.println("Add foreign key...");
        stmt = con.createStatement();

        String sql = "ALTER TABLE " + nameTable1 + " ADD  FOREIGN KEY (" + id + ")  REFERENCES " + nameTable2 + " (" + id + ")";

        stmt.execute(sql);
        System.out.println("Constraint add in given database...");
    }

    public static void alterDataTypeIsNameColumn(String nameTable, String nameColumn, String dataType) throws SQLException {
        System.out.println("Alter table  and type data conlum and table ...");
        stmt = con.createStatement();
        String sql = "ALTER TABLE " + nameTable + " ALTER COLUMN " + nameColumn + " TYPE " + dataType + "";
        stmt.executeUpdate(sql);
        System.out.println("data type alter in given database...");
    }

    public static void alterTable(String nameCurrent, String nameModified) throws SQLException {
        stmt = con.createStatement();
        String sql = "ALTER TABLE " + nameCurrent + " RENAME TO  " + nameModified + "";
        stmt.executeUpdate(sql);
        System.out.println("Alter table com sucesso ...");
    }


    public static void dropConstraintNotNullConlumn(String nameTable, String nameColumn) throws SQLException {
        System.out.println("Drop Constraint NULL ...");
        stmt = con.createStatement();
        String sql = "ALTER TABLE " + nameTable + " ALTER COLUMN " + nameColumn + "  DROP NOT NULL";
        stmt.execute(sql);
        System.out.println("Drop in given database...");
    }

    public static void dropColumnOfTheTable(String nameTable, String nameColumn) throws SQLException {
        System.out.println("Delete  conlum and table ...");
        stmt = con.createStatement();
        String sql = "ALTER TABLE " + nameTable + " DROP " + nameColumn + "";
        stmt.executeUpdate(sql);
        System.out.println("Deletede colum in given database...");
    }

    public static void dropTable(String name) throws SQLException {

        stmt = con.createStatement();
        String sql = "DROP TABLE " + name + "";
        stmt.executeUpdate(sql);
        System.out.println("drop table com sucesso ...");
    }

    public static void dropDataBase(String nameDataBase) throws SQLException {
        System.out.println("Delete  data base and table ...");
        stmt = con.createStatement();
        String sql = "DROP DATABASE " + nameDataBase + "";
        stmt.executeUpdate(sql);
        System.out.println("Deletede data base ...");
    }

    public static void insertInto(String nameTable, List<AddColumn> column, List<Object> objects) throws SQLException {
        Map<String, String> map = new LinkedHashMap<>();
        map.put(String.valueOf(column), String.valueOf(objects));

        String replace = getReplaceColumn(map);

        String sql = null;

        int size = objects.size();
        sql = executeSqlInsert(nameTable, replace, sql, size);

        PreparedStatement pstm = con.prepareStatement(sql);
        executePreparedStatemant(objects, size, pstm);
        pstm.execute();
    }

    private static String getReplaceColumn(Map<String, String> map) {
        String name = String.valueOf(map.keySet()).replace("[[", "");
        return name.replace("]]", "");
    }

    private static String executeSqlInsert(String nameTable, String replace, String sql, int size) {
        for (int i = 1; i <= size; i++) {
            if (i == size) {
                String substring = values.substring(i);
                int total = values.length() - substring.length();
                String missingValue = values.substring(substring.length() - total + 1);

                sql = "insert into " + nameTable + " (" + replace + ")  " + "values" + " (" + missingValue + ")";
            }
        }
        return sql;
    }

    private static void executePreparedStatemant(List<Object> objects, int size, PreparedStatement pstm) throws SQLException {
        for (int j = 1; j <= size; j++) {
            if (objects != null) {
                pstm.setObject(j, objects.get(j - 1));
            }
        }
    }

    public static void selectTable(String nomeTable) throws SQLException {
        PreparedStatement stmt = con.prepareStatement("select * from " + nomeTable + "");

        // executa um select
        ResultSet rs = stmt.executeQuery();
        // itera no ResultSet

        Map<Object, Object> map = new LinkedHashMap<>();


        while (rs.next()) {
            int cont = 1;
            cont++;
            map.put(rs.toString(), cont);

            for (Map.Entry<Object, Object> entry : map.entrySet()) {
                System.out.println(entry.getKey() + " : " + entry.getValue());

            }
//            Long id = rs.getLong("id");
//            String name = rs.getString("name");
//            System.out.println(id + " _ " + name);
        }

        rs.close();
        //stmt.close();
        //con.close();
    }

    public static void upadate(String nameTable, String atributo) {
        String sql = "update " + nameTable + " set name=? where id=?";
        try {
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, atributo);
            stmt.setLong(2, 1L);
            stmt.execute();
            stmt.close();
            System.out.println("Alterado id = " + 1L);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static void remove(String nameTable, Long id) {
        try {
            PreparedStatement stmt = con.prepareStatement("delete " +
                    "from " + nameTable + " where id=?");
            stmt.setLong(1, id);
            stmt.execute();
            //stmt.close();
            System.out.println("Deletado id = " + id);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


}
