package com.logogreatagain.controller;

import com.logogreatagain.service.PlayerService;
import com.logogreatagain.service.dto.CreateUpdatePlayerDto;
import com.logogreatagain.service.dto.PlayerDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/players")
public class PlayerController {
    private final PlayerService playerService;

    @PostMapping()
    public PlayerDto newPlayer(@RequestBody CreateUpdatePlayerDto createUpdatePlayerDto) {
        return playerService.createPlayer(createUpdatePlayerDto);
    }
}
