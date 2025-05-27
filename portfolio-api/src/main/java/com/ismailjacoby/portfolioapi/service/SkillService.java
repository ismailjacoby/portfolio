package com.ismailjacoby.portfolioapi.service;

import com.ismailjacoby.portfolioapi.models.entity.Skill;
import com.ismailjacoby.portfolioapi.models.form.SkillForm;

import java.util.List;

public interface SkillService {
    void addSkill(SkillForm form);
    Skill findSkillById(Long id);
    List<Skill> findAllSkills();
    void updateSkill(Long id, SkillForm form);
    void deleteSkill(Long id);
}
