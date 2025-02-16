package Dainapereira.com.github.gestao_erp_curso.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "pedido")
public class ItemPedido {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private String id;

  private Produto produto;
  private Integer quantidade;
  private Double valorUnitario;
  private Double valorTotal;
}
