/*
  File: TetrisService.java
  Role: テトリスのゲーム開始ログ・スコア保存・ハイスコア取得を行うサービス層
  Created: 2026-07-12
  Author: Seiji
*/

package com.uhyo.backend_data_management.Service;

import com.uhyo.backend_data_management.entity.TetrisGameLog;
import com.uhyo.backend_data_management.entity.TetrisScore;
import com.uhyo.backend_data_management.repository.TetrisGameLogRepository;
import com.uhyo.backend_data_management.repository.TetrisScoreRepository;
import com.uhyo.common.tetris.GameStartDto;
import com.uhyo.common.tetris.ScoreDto;
import com.uhyo.common.tetris.HighScoreDto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class TetrisService {

    @Autowired
    private TetrisGameLogRepository gameLogRepository;

    @Autowired
    private TetrisScoreRepository scoreRepository;

    /**
     * ゲーム開始ログ保存
     */
    public void saveGameStart(GameStartDto dto) {
        TetrisGameLog log = new TetrisGameLog(
                dto.getUserId(),
                LocalDateTime.parse(dto.getStartTime())
        );
        gameLogRepository.save(log);
    }

    /**
     * スコア保存
     */
    public void saveScore(ScoreDto dto) {
        TetrisScore score = new TetrisScore(
                "seiji",                     // 必要なら後でユーザーIDを拡張
                dto.getScore(),
                dto.getLines(),
                dto.getLevel(),
                dto.getDuration(),
                LocalDateTime.now()
        );
        scoreRepository.save(score);
    }

    /**
     * ハイスコア一覧取得
     */
    public List<HighScoreDto> getHighScores() {
        return scoreRepository.findAll()
                .stream()
                .map(score -> new HighScoreDto(
                        score.getUserId(),
                        score.getScore(),
                        score.getDate().toString()
                ))
                .toList();
    }
}
