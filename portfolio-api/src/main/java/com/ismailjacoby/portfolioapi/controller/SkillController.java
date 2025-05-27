package com.ismailjacoby.portfolioapi.controller;

import com.ismailjacoby.portfolioapi.models.dto.SkillDTO;
import com.ismailjacoby.portfolioapi.models.entity.Skill;
import com.ismailjacoby.portfolioapi.models.form.SkillForm;
import com.ismailjacoby.portfolioapi.service.SkillService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/skill")
public class SkillController {

    private final SkillService skillService;

    public SkillController(SkillService skillService) {
        this.skillService = skillService;
    }

    // Create
    @PostMapping("/add")
    public ResponseEntity<String> addSkill(@RequestBody @Valid SkillForm form) {
        skillService.addSkill(form);
        return ResponseEntity.ok("Skill added successfully!");
    }

    // Read One
    @GetMapping("/{id}")
    public ResponseEntity<SkillDTO> getSkill(@PathVariable Long id) {
        Skill skill = skillService.findSkillById(id);
        return ResponseEntity.ok(SkillDTO.fromEntity(skill));
    }

    // Get all
    @GetMapping("/all")
    public ResponseEntity<List<SkillDTO>> getAllSkills() {
        List<SkillDTO> skills = skillService.findAllSkills().stream()
                .map(SkillDTO::fromEntity)
                .collect(Collectors.toList());
        return ResponseEntity.ok(skills);
    }

    // Update
    @PutMapping("/update/{id}")
    public ResponseEntity<String> updateSkill(@PathVariable Long id, @RequestBody @Valid SkillForm form) {
        skillService.updateSkill(form, id);
        return ResponseEntity.ok("Skill updated successfully");
    }

    // Delete
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteSkill(@PathVariable Long id) {
        skillService.deleteSkill(id);
        return ResponseEntity.ok("Skill deleted successfully");
    }
}
