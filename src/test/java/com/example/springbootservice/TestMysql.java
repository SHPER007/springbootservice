//package com.example.springbootservice;
//
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.jdbc.core.BatchPreparedStatementSetter;
//import org.springframework.jdbc.core.JdbcTemplate;
//
//import java.sql.PreparedStatement;
//import java.sql.SQLException;
//
///**
// * ClassName:TestMysql
// * Description:TODO
// * Author:SunHang
// * Date:2024/6/23 20:15
// */
//@SpringBootTest
//public class TestMysql {
//
//    @Autowired
//    private JdbcTemplate jdbcTemplate;
//
//    @Test
//    public void batchInsertCities(){
//        String[] data = {
//                "平果市\t451082\t0776",
//                "贺州市\t451100\t1774",
//                "八步区\t451102\t1774",
//                "平桂区\t451103\t1774",
//                "昭平县\t451121\t1774",
//                "钟山县\t451122\t1774",
//                "河池市\t451200\t0778"
//        };
//        String sql = "INSERT INTO cities (cityname, adcode,citycode) VALUES (?, ?, ?)";
//        jdbcTemplate.batchUpdate(sql, new BatchPreparedStatementSetter() {
//            @Override
//            public void setValues(PreparedStatement ps, int i) throws SQLException {
//                String[] parts = data[i].split("\t");
//                ps.setString(1, parts[0]);
//                ps.setInt(2, Integer.parseInt(parts[1]));
//                ps.setInt(3, Integer.parseInt(parts[2]));
//
//            }
//
//            @Override
//            public int getBatchSize() {
//                return data.length;
//            }
//        });
//
//
//    }
//}
