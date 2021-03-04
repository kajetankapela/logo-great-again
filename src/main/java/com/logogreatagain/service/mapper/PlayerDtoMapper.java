package com.logogreatagain.service.mapper;

import com.logogreatagain.model.Player;
import com.logogreatagain.service.dto.PlayerDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;

@RequiredArgsConstructor
@Component
public class PlayerDtoMapper {
    @Transactional
    public PlayerDto toDto(Player player) {
        return PlayerDto.builder()
                .id(player.getId())
                .name(player.getName())
                .build();
    }
}
