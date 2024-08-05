package com.bangez.tx.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bangez.tx.domain.model.TxModel;

@Repository
public interface TxRepository extends JpaRepository<TxModel, Long> {
}
