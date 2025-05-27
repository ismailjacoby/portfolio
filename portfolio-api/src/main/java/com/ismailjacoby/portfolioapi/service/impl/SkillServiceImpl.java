package com.ismailjacoby.portfolioapi.service.impl;

import com.ismailjacoby.portfolioapi.exception.DuplicateException;
import com.ismailjacoby.portfolioapi.models.entity.Skill;
import com.ismailjacoby.portfolioapi.models.form.SkillForm;
import com.ismailjacoby.portfolioapi.repository.SkillRepository;
import com.ismailjacoby.portfolioapi.service.SkillService;
import org.springframework.stereotype.Service;

@Service
public class SkillServiceImpl implements SkillService {
    private final SkillRepository skillRepository;

    public SkillServiceImpl(SkillRepository skillRepository) {
        this.skillRepository = skillRepository;
    }

    @Override
    public void addSkill(SkillForm form) {
        String name = form.name().toLowerCase().trim();

        if(skillRepository.existsByNameIgnoreCase(name)){
            throw new DuplicateException("Skill with name '" + name + "' already exists");
        }

        Skill skill = new Skill();
        skill.setName(name);
        skill.setCategory(form.category());
        skillRepository.save(skill);
    }
}
