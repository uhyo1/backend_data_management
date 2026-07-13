/*
  File: TetrisGameLogRepository.java
  Role: テトリスのゲーム開始ログを扱う Repository（DBアクセス）
  Created: 2026-07-12
  Author: Seiji
*/

package com.uhyo.backend_data_management.repository;

import com.uhyo.backend_data_management.entity.TetrisGameLog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TetrisGameLogRepository extends JpaRepository<TetrisGameLog, Long> {

    // 必要なら後で検索条件を追加できる
}
