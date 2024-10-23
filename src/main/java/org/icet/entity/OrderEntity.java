package org.icet.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.icet.dto.Order;

import java.time.LocalDate;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString


@Entity
public class OrderEntity {
    @Id
    private String id;
    // Many-to-one relationship
    @ManyToOne
    @JoinColumn(name = "customerId") //  foreign key column
    private CustomerEntity customer;

    @OneToMany(mappedBy = "order",cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    private List<Order> orderDetails;

    private LocalDate date;
    private Double netTotal;


}
