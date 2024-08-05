package com.bangez.user.repository;

import com.bangez.user.domain.model.BuyArticle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BuyArticleRepository extends JpaRepository<BuyArticle, Long> {
}