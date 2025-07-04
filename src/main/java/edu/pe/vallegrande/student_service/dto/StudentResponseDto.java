package edu.pe.vallegrande.student_service.dto;

import lombok.Data;
import lombok.Builder;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class StudentResponseDto {
    private String dni;
    private String firstName;
    private String lastName;
    private LocalDateTime date;
}
