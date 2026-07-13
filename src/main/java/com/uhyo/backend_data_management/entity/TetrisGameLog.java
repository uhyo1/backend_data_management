/*
  File: TetrisGameLog.java
  Role: テトリスのゲーム開始ログを保存する Entity（DBテーブル）
  Created: 2026-07-12
  Author: Seiji
*/

package com.uhyo.backend_data_management.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "tetris_game_log")
public class TetrisGameLog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String userId;          // ユーザーID
    private LocalDateTime startTime; // ゲーム開始時刻

    public TetrisGameLog() {}

    public TetrisGameLog(String userId, LocalDateTime startTime) {
        this.userId = userId;
        this.startTime = startTime;
    }

    public Long getId() {
        return id;
    }

    public String getUserId() {
        return userId;
    }

    public LocalDateTime getStartTime() {
        return startTime;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public void setStartTime(LocalDateTime startTime) {
        this.startTime = startTime;
    }
}
