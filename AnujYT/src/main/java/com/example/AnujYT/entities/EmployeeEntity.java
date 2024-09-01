package com.example.AnujYT.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Table(name="employees")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeEntity {
    @Id  //pk
    @GeneratedValue(strategy= GenerationType.AUTO)
    private long id;
    private String name;
    private LocalDate dateOfJoining;
    private boolean isActive;
}
