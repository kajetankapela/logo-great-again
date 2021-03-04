package com.logogreatagain.controller;

import com.logogreatagain.service.LeaderboardService;
import com.logogreatagain.service.dto.PlayerDto;
import com.logogreatagain.service.dto.PlayerDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/leaderboards")
public class LeaderboardController {
    private final LeaderboardService leaderboardService;

    @GetMapping()
    public List<PlayerDto> getBestOfAllTime() {
        return leaderboardService.getBestOfAllTime();
    }

    @GetMapping("/year")
    public List<PlayerDto> getBestOfThisYear() {
        return leaderboardService.getBestOfThisYear();
    }

    @GetMapping("/week")
    public List<PlayerDto> getBestOfThisWeek() {
        return leaderboardService.getBestOfThisWeek();
    }

    @GetMapping("/today")
    public List<PlayerDto> getBestOfToday() {
        return leaderboardService.getBestOfToday();
    }
}
