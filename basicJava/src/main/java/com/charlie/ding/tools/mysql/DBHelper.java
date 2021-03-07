package com.charlie.ding.tools.mysql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class DBHelper {
    private Connection conn;
    private PreparedStatement words;


    public DBHelper(){
        try {
            this.conn = DriverManager.getConnection("jdbc:mysql://localhost/english?" + "user=root&password=dzg19791110");
            this.words= this.conn.prepareStatement(
                    "INSERT INTO english.T_collocations" +
                            "(sentence, collocation, use_type,from_id)" +
                            "VALUES(?, '', 0,2)");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public void preInsert(List<String> datas) throws SQLException {
        for(int i=0;i<datas.size();i++){
            this.words.setString(1,datas.get(i));
            this.words.addBatch();
        }
    }

    public void insertData(){
        try{
            this.conn.setAutoCommit(false);
            this.words.executeBatch();
            conn.commit();
        }catch (SQLException ex) {
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
            return;

        }finally {
            try {
                this.conn.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
    }
}
