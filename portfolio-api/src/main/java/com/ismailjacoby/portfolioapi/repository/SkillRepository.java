package com.ismailjacoby.portfolioapi.repository;

import com.ismailjacoby.portfolioapi.models.entity.Skill;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface SkillRepository extends JpaRepository<Skill, Long> {
    boolean existsByNameIgnoreCase(String name);
    List<Skill> findByNameIn(List<String> techNames);
}
