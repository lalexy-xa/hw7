package org.example.dto;

import lombok.AllArgsConstructor;

import lombok.Getter;

import java.time.LocalDate;

@Getter
@AllArgsConstructor
public class WorkerDto {
    private String name;
    private LocalDate birthday;
    private String level;
    private int salary;

}
