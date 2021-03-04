package com.logogreatagain.controller;

import com.logogreatagain.service.ScoresService;
import com.logogreatagain.service.dto.CreateUpdateScoresDto;
import com.logogreatagain.service.dto.ScoresDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/scores")
public class ScoresController {
    private final ScoresService scoresService;

    @PostMapping()
    public ScoresDto newScores(@RequestBody CreateUpdateScoresDto createUpdateScoresDto) {
        return scoresService.createScores(createUpdateScoresDto);
    }
}
