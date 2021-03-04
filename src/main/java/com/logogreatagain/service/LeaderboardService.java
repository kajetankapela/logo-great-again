package com.logogreatagain.service;

import com.logogreatagain.repository.PlayerRepository;
import com.logogreatagain.repository.ScoresRepository;
import com.logogreatagain.service.dto.PlayerDto;
import com.logogreatagain.service.mapper.PlayerDtoMapper;
import com.logogreatagain.service.mapper.ScoresDtoMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Service
public class LeaderboardService {
    private final PlayerRepository playerRepository;

    @Transactional
    public List<PlayerDto> getBestOfAllTime() {
        playerRepository.findBestOfAllTime();
        return new ArrayList<>();
    }

    @Transactional
    public List<PlayerDto> getBestOfThisYear() {
        playerRepository.findBestOfYear(LocalDate.now().getYear());
        return new ArrayList<>();
    }

    @Transactional
    public List<PlayerDto> getBestOfThisWeek() {
        LocalDate deadline = LocalDate.now().minusDays(7);
        playerRepository.findBestOfWeek(deadline.getYear(), deadline.getMonthValue(), deadline.getDayOfMonth());
        return new ArrayList<>();
    }

    @Transactional
    public List<PlayerDto> getBestOfToday() {
        playerRepository.findBestOfDay(LocalDate.now().getYear(), LocalDate.now().getMonthValue(), LocalDate.now().getDayOfMonth());
        return new ArrayList<>();
    }
}
