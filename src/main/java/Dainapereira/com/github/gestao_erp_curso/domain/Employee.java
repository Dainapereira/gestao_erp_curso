package Dainapereira.com.github.gestao_erp_curso.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Table(name = "employee")
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class Employee extends Person{
    private String registrationNumber;
  }


