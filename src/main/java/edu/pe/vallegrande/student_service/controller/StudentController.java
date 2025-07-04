package edu.pe.vallegrande.student_service.controller;

import edu.pe.vallegrande.student_service.dto.StudentRequestDto;
import edu.pe.vallegrande.student_service.dto.StudentResponseDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@RestController
@RequestMapping("/v1/api")
public class StudentController {

    private StudentRequestDto studentData;  // Almacenamiento temporal en memoria

    @PostMapping("/student")
    public ResponseEntity<String> saveStudent(@RequestBody StudentRequestDto request) {
        this.studentData = request;
        return ResponseEntity.ok("Student data saved successfully");
    }

    @GetMapping("/student")
    public ResponseEntity<StudentResponseDto> getStudent() {
        if (studentData == null) {
            return ResponseEntity.notFound().build();
        }

        StudentResponseDto response = StudentResponseDto.builder()
                .dni(studentData.getDni())
                .firstName(studentData.getFirstName())
                .lastName(studentData.getLastName())
                .date(LocalDateTime.now())
                .build();

        return ResponseEntity.ok(response);
    }
}
