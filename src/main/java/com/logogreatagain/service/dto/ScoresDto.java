package com.logogreatagain.service.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ScoresDto {
    private Long id;
    private int day;
    private int month;
    private int year;
    private Long points;

    @Builder.Default
    private PlayerDto playerDto = new PlayerDto();
}
