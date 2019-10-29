package com.qf.typehandler;

import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedHashMap;

public class LinkedHashMapTypeHandler extends BaseTypeHandler<LinkedHashMap<String,String>> {
    @Override
    public void setNonNullParameter(PreparedStatement preparedStatement, int i, LinkedHashMap<String, String> stringStringLinkedHashMap, JdbcType jdbcType) throws SQLException {

    }

    @Override
    public LinkedHashMap<String, String> getNullableResult(ResultSet rs, String s) throws SQLException {
        LinkedHashMap<String, String> filterChain = new  LinkedHashMap<>();
        filterChain.put(rs.getString("url"),rs.getString("filter"));

        while(rs.next()){
            filterChain.put(rs.getString("url"),rs.getString("filter"));
        }

        return filterChain;
    }

    @Override
    public LinkedHashMap<String, String> getNullableResult(ResultSet resultSet, int i) throws SQLException {
        return null;
    }

    @Override
    public LinkedHashMap<String, String> getNullableResult(CallableStatement callableStatement, int i) throws SQLException {
        return null;
    }
}
