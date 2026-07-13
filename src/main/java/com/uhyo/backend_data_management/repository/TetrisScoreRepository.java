/*
  File: TetrisScoreRepository.java
  Role: テトリスのスコア情報を扱う Repository（DBアクセス）
  Created: 2026-07-12
  Author: Seiji
*/

package com.uhyo.backend_data_management.repository;

import com.uhyo.backend_data_management.entity.TetrisScore;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TetrisScoreRepository extends JpaRepository<TetrisScore, Long> {

    // 必要なら後でカスタム検索を追加できる
}
