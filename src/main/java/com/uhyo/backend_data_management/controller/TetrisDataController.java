/*
  File: TetrisDataController.java
  Role: backend_ui からのテトリス関連 API を受け取り、Service に処理を委譲するコントローラ
  Created: 2026-07-12
  Author: Seiji
*/

package com.uhyo.backend_data_management.controller;

import com.uhyo.backend_data_management.Service.TetrisService;
import com.uhyo.common.tetris.GameStartDto;
import com.uhyo.common.tetris.ScoreDto;
import com.uhyo.common.tetris.HighScoreDto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tetris")
public class TetrisDataController {

    @Autowired
    private TetrisService tetrisService;

    /**
     * ゲーム開始ログ保存
     */
    @PostMapping("/start")
    public String startGame(@RequestBody GameStartDto dto) {
        tetrisService.saveGameStart(dto);
        return "OK";
    }

    /**
     * スコア保存
     */
    @PostMapping("/finish")
    public String finishGame(@RequestBody ScoreDto dto) {
        tetrisService.saveScore(dto);
        return "OK";
    }

    /**
     * ハイスコア一覧取得
     */
    @GetMapping("/highscores")
    public List<HighScoreDto> getHighScores() {
        return tetrisService.getHighScores();
    }
}
