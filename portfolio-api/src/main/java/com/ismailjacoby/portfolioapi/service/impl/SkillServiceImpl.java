package com.ismailjacoby.portfolioapi.service.impl;

import com.ismailjacoby.portfolioapi.exception.DuplicateException;
import com.ismailjacoby.portfolioapi.exception.NotFoundException;
import com.ismailjacoby.portfolioapi.models.entity.Skill;
import com.ismailjacoby.portfolioapi.models.form.SkillForm;
import com.ismailjacoby.portfolioapi.repository.SkillRepository;
import com.ismailjacoby.portfolioapi.service.SkillService;
import org.springframework.stereotype.Service;

import java.util.List;

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

    @Override
    public Skill findSkillById(Long id) {
        return skillRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Skill with id '" + id + "' not found"));
    }

    @Override
    public List<Skill> findAllSkills() {
        return skillRepository.findAll();
    }

    @Override
    public void updateSkill(Long id, SkillForm form) {
        Skill skill = skillRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Skill with id '" + id + "' not found"));

        String updatedName = form.name().toLowerCase().trim();

        if (!skill.getName().equalsIgnoreCase(updatedName) &&
                skillRepository.existsByNameIgnoreCase(updatedName)) {
            throw new DuplicateException("Skill with name '" + updatedName + "' already exists");
        }

        skill.setName(updatedName);
        skill.setCategory(form.category());
        skillRepository.save(skill);
    }

    @Override
    public void deleteSkill(Long id) {
        if (!skillRepository.existsById(id)) {
            throw new NotFoundException("Skill with id '" + id + "' not found");
        }

        skillRepository.deleteById(id);
    }
}
