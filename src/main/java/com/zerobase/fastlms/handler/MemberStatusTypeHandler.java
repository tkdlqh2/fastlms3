package com.zerobase.fastlms.handler;

import com.zerobase.fastlms.type.MemberStatus;
import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.MappedTypes;
import org.apache.ibatis.type.TypeHandler;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;



@MappedTypes(MemberStatus.class)
public class MemberStatusTypeHandler implements TypeHandler<MemberStatus> {

    @Override
    public void setParameter(PreparedStatement ps, int i, MemberStatus parameter, JdbcType jdbcType) throws SQLException {
        ps.setString(i, parameter.getCode());
    }

    @Override
    public MemberStatus getResult(ResultSet rs, String columnName) throws SQLException {
        String code = rs.getString(columnName);
        return getCodeEnum(code);
    }

    @Override
    public MemberStatus getResult(ResultSet rs, int columnIndex) throws SQLException {
        String code = rs.getString(columnIndex);
        return getCodeEnum(code);
    }

    @Override
    public MemberStatus getResult(CallableStatement cs, int columnIndex) throws SQLException {
        String code = cs.getString(columnIndex);
        return getCodeEnum(code);
    }

    private MemberStatus getCodeEnum(String code) {
        switch (code) {
            case "REQ":
                return MemberStatus.REQ;
            case "ING":
                return MemberStatus.ING;
            case "WITHDRAW":
                return MemberStatus.WITHDRAW;
            case "STOP":
                return MemberStatus.STOP;
        }
        return null;
    }
}