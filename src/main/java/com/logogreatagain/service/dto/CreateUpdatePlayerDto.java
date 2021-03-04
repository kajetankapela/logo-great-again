package com.logogreatagain.service.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CreateUpdatePlayerDto {
    private Long id;
    private String name;

    @Builder.Default
    private List<CreateUpdateScoresDto> scores = new ArrayList<>();
}
