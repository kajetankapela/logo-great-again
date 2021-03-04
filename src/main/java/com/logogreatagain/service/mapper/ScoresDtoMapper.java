package com.logogreatagain.service.mapper;

import com.logogreatagain.model.Scores;
import com.logogreatagain.service.dto.PlayerDto;
import com.logogreatagain.service.dto.ScoresDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
@RequiredArgsConstructor
@Component
public class ScoresDtoMapper {
    private final PlayerDtoMapper playerDtoMapper;

    @Transactional
    public ScoresDto toDto(Scores scores) {
        return ScoresDto.builder()
                .id(scores.getId())
                .day(scores.getDay())
                .month(scores.getMonth())
                .year(scores.getYear())
                .points(scores.getPoints())
                .playerDto(playerDtoMapper.toDto(scores.getPlayer()))
                .build();
    }
}
