package com.example.testnvs.Repository;

import com.example.testnvs.Entity.ProductEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<ProductEntity, Long> {
   Page<ProductEntity>  findAllByNameContaining(String name,Pageable pageable);
}
