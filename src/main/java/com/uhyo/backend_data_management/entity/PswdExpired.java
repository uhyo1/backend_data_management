package com.uhyo.backend_data_management.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "pswd_expired", schema = "app")
public class PswdExpired {

    @Id
    @Column(name = "pswd_expired_id")
    private Integer id;

    @Column(name = "access_info")
    private String accessInfo;

    @Column(name = "user_id")
    private String userId;

    @Column(name = "password")
    private String password;

    @Column(name = "create_time")
    private String createTime;

    @Column(name = "updated_time")
    private String updatedTime;
}
