package org.example.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDate;

@Getter
@AllArgsConstructor
public class ProjectDto {
    int clientId;
    LocalDate startDate;
    LocalDate finishDate;
}
