package com.chandanyadav.pm.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.chandanyadav.pm.entity.ProductEnt;

@Repository
public interface ProductRepository extends JpaRepository<ProductEnt, Long>
{

}
