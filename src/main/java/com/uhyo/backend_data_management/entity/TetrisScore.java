/*
  File: TetrisScore.java
  Role: テトリスのスコア情報を保存する Entity（DBテーブル）
  Created: 2026-07-12
  Author: Seiji
*/

package com.uhyo.backend_data_management.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "tetris_score")
public class TetrisScore {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String userId;      // ユーザーID（必要なら拡張）
    private int score;          // スコア
    private int lines;          // 消したライン数
    private int level;          // レベル
    private int duration;       // プレイ時間（秒）
    private LocalDateTime date; // 記録日時

    public TetrisScore() {}

    public TetrisScore(String userId, int score, int lines, int level, int duration, LocalDateTime date) {
        this.userId = userId;
        this.score = score;
        this.lines = lines;
        this.level = level;
        this.duration = duration;
        this.date = date;
    }

    public Long getId() {
        return id;
    }

    public String getUserId() {
        return userId;
    }

    public int getScore() {
        return score;
    }

    public int getLines() {
        return lines;
    }

    public int getLevel() {
        return level;
    }

    public int getDuration() {
        return duration;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public void setLines(int lines) {
        this.lines = lines;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }
}
