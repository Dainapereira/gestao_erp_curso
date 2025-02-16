package Dainapereira.com.github.gestao_erp_curso.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.util.List;

@Entity
@Table(name = "pedido")
public class Pedido {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private String id;

  private List<ItemPedido> itemPedido;
  private Person cliente;
  private Double valorTotal;
}
