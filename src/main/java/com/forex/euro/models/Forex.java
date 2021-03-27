package com.forex.euro.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.util.Date;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="forex")
public class Forex {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String currency;
    private double exchangeRate;
    private int requested;
    @CreationTimestamp
    private Date updatedAt;
}
