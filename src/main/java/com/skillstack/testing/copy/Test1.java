package com.skillstack.testing.copy;





import java.sql.Connection;

import com.skillstack.util.DBConnection;

public class Test1 {
    public static void main(String[] args) {
      

        Connection conn = DBConnection.getConnection();
        if (conn != null) {
            System.out.println(" Database connected successfully!");
        } else {
            System.out.println("Connection failed!");
        }
    }
}

