package com.uhyo.backend_data_management.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.uhyo.backend_data_management.entity.PswdExpired;

/**
 * pswd_expired テーブルにアクセスするための Repository
 * findAll() や findById() などのメソッドが自動生成される
 */
public interface PswdExpiredRepository extends JpaRepository<PswdExpired, Long> {
}
