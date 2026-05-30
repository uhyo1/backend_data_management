package com.uhyo.backend_data_management.repository;

import com.uhyo.common.dto.cond.CustomerDto;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class CustomerRepository {

    private final JdbcTemplate jdbc;

    public CustomerRepository(JdbcTemplate jdbc) {
        this.jdbc = jdbc;
    }

    public CustomerDto findById(int id) {

        String sql = """
            SELECT 
                costmer_id,
                name,
                kana,
                sex,
                birthday,
                phone_number,
                update_time
            FROM app.costmer
            WHERE costmer_id = ?
        """;

        return jdbc.queryForObject(sql, (rs, rowNum) -> {
            CustomerDto dto = new CustomerDto();
            dto.setId(rs.getInt("costmer_id"));
            dto.setName(rs.getString("name"));
            dto.setKana(rs.getString("kana"));
            dto.setSex(rs.getString("sex"));
            dto.setBirthday(rs.getString("birthday"));
            dto.setPhoneNumber(rs.getString("phone_number"));
            dto.setUpdateTime(rs.getString("update_time"));
            return dto;
        }, id);
    }
}
