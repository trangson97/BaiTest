package com.example.testnvs.Entity;

import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "product")
@Data
public class ProductEntity {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "name")
    private String name;
    @Column(name = "price")
    private String price;
    @Column(name = "title")
    private String title;
    @Column(name = "created_at")
    @CreationTimestamp
    private Date createdAt;
    @Column(name = "update_at")
    @UpdateTimestamp
    private Date updateAt;
}
