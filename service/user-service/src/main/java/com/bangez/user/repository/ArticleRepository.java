package com.bangez.user.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bangez.user.domain.model.Article;

@Repository
public interface ArticleRepository extends JpaRepository<Article, Long> {
}