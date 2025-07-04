package edu.pe.vallegrande.student_service.dto;

import lombok.Data;

@Data
public class StudentRequestDto {
    private String dni;
    private String firstName;
    private String lastName;
}
