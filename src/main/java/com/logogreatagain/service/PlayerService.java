package com.logogreatagain.service;

import com.logogreatagain.model.Player;
import com.logogreatagain.model.Scores;
import com.logogreatagain.repository.PlayerRepository;
import com.logogreatagain.service.dto.CreateUpdatePlayerDto;
import com.logogreatagain.service.dto.PlayerDto;
import com.logogreatagain.service.mapper.PlayerDtoMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@RequiredArgsConstructor
@Service
public class PlayerService {
    private final PlayerRepository playerRepository;
    private final PlayerDtoMapper playerDtoMapper;

    @Transactional
    public PlayerDto createPlayer(CreateUpdatePlayerDto createUpdatePlayerDto) {
        Player player = Player.builder()
                .id(createUpdatePlayerDto.getId())
                .name(createUpdatePlayerDto.getName())
                .scores(null)
                .build();
        Player savedPlayer = playerRepository.save(player);
        return playerDtoMapper.toDto(savedPlayer);
    }

}
