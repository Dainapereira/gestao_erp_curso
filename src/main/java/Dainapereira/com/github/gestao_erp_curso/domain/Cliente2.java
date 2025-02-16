
package Dainapereira.com.github.gestao_erp_curso.domain;

import jakarta.persistence.Column;
import jakarta.validation.constraints.Email;
import org.hibernate.validator.constraints.br.CPF;

public class Cliente2 {
  @Column(length = 100)
  private String name;

  @Column(unique = true)
  @CPF(message = "CPF inválido")
  private String cpf;

  private Long longitude;
  private Long latitude;

  @Column(unique = true)
  @Email(message = "Email inválido")
  private String email;


}
