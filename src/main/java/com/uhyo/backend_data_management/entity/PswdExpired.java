package com.uhyo.backend_data_management.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

/**
 * PostgreSQL の app.pswd_expired テーブルに対応する Entity クラス
 */
@Entity
@Table(name = "pswd_expired", schema = "app")
public class PswdExpired {

    /** 主キー（pswd_expired_id カラムに対応） */
    @Id
    private Long pswdExpiredId;

    /** パスワードの有効期限（例） */
    private String expiredDate;

    public Long getPswdExpiredId() {
        return pswdExpiredId;
    }

    public void setPswdExpiredId(Long pswdExpiredId) {
        this.pswdExpiredId = pswdExpiredId;
    }

    public String getExpiredDate() {
        return expiredDate;
    }

    public void setExpiredDate(String expiredDate) {
        this.expiredDate = expiredDate;
    }
}
