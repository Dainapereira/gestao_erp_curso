package Dainapereira.com.github.gestao_erp_curso.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Embeddable;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.criteria.Order;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "item_order")

public class ItemOrder {

  @JsonIgnore
  @EmbeddedId
  private ItemOrderPk id = new ItemOrderPk();
  private Double quantity;
  private Double price;

  public ItemOrder(Order order,Product product,Double quantity,Double price){
    this.id.setOrders(order);
    this.id.setProduct(product);
    this.quantity = quantity;
    this.price = price;

  }
  public Double getTotalPrice(){return price * quantity;}

  public Order  getOrder(){return this.id.getOrder();}

  public void  setOrder(Order order){ id.setOrder(order);}

  public Product getProduct(){ return this.id.getProduct();}

  public void setProduct(Product product){ id.setProduct(product);}

}
