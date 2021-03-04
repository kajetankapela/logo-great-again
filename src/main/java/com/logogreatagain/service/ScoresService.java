package com.logogreatagain.service;

import com.logogreatagain.model.Scores;
import com.logogreatagain.repository.PlayerRepository;
import com.logogreatagain.repository.ScoresRepository;
import com.logogreatagain.service.dto.CreateUpdateScoresDto;
import com.logogreatagain.service.dto.ScoresDto;
import com.logogreatagain.service.mapper.ScoresDtoMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@RequiredArgsConstructor
@Service
public class ScoresService {
    private final ScoresRepository scoresRepository;
    private final ScoresDtoMapper scoresDtoMapper;
    private final PlayerRepository playerRepository;

    @Transactional
    public ScoresDto createScores(CreateUpdateScoresDto createUpdateScoresDto) {
        Long playerId = createUpdateScoresDto.getCreateUpdatePlayerDto().getId();

        Scores scores = Scores.builder()
                .id(createUpdateScoresDto.getId())
                .day(createUpdateScoresDto.getDay())
                .month(createUpdateScoresDto.getMonth())
                .year(createUpdateScoresDto.getYear())
                .points(createUpdateScoresDto.getPoints())
                .player(playerRepository.findById(playerId).orElseThrow())
                .build();

        Scores savedScores = scoresRepository.save(scores);
        return scoresDtoMapper.toDto(savedScores);
    }
}
