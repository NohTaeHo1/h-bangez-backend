package com.bangez.tx.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bangez.tx.domain.model.PointModel;

import java.util.Optional;

@Repository
public interface PointRepository extends JpaRepository<PointModel, Long>{
    PointModel findByUserId(Long userId);

    Boolean existsByUserId(Long userId);
}