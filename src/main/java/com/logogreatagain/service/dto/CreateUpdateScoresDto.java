package com.logogreatagain.service.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CreateUpdateScoresDto {
    private Long id;
    private int day;
    private int month;
    private int year;
    private Long points;

    @Builder.Default
    private CreateUpdatePlayerDto createUpdatePlayerDto = new CreateUpdatePlayerDto();
}
