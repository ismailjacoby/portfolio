package com.ismailjacoby.portfolioapi.config;

import com.ismailjacoby.portfolioapi.models.entity.Project;
import com.ismailjacoby.portfolioapi.models.entity.Skill;
import com.ismailjacoby.portfolioapi.models.entity.User;
import com.ismailjacoby.portfolioapi.models.enums.SkillCategory;
import com.ismailjacoby.portfolioapi.models.enums.UserRole;
import com.ismailjacoby.portfolioapi.repository.ProjectRepository;
import com.ismailjacoby.portfolioapi.repository.SkillRepository;
import com.ismailjacoby.portfolioapi.repository.UserRepository;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DataInit  implements InitializingBean {
    private final PasswordEncoder passwordEncoder;
    private final UserRepository userRepository;
    private final SkillRepository skillRepository;
    private final ProjectRepository projectRepository;


    public DataInit(UserRepository userRepository, PasswordEncoder passwordEncoder, SkillRepository skillRepository, ProjectRepository projectRepository) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.skillRepository = skillRepository;
        this.projectRepository = projectRepository;
    }

    @Value("${ADMIN_USERNAME}")
    private String adminUsername;

    @Value("${ADMIN_PASSWORD}")
    private String adminPassword;

    @Override
    public void afterPropertiesSet() throws Exception {
        // Admin
        if (userRepository.findByUsername(adminUsername).isEmpty()) {
            User user = new User();
            user.setUsername(adminUsername);
            user.setPassword(passwordEncoder.encode(adminPassword));
            user.setRole(UserRole.ADMIN);
            userRepository.save(user);
        }

        // Skills
        List<Skill> skills = List.of(
                // Frontend
                new Skill("Html", SkillCategory.FRONTEND),
                new Skill("Css", SkillCategory.FRONTEND),
                new Skill("Javascript", SkillCategory.FRONTEND),
                new Skill("Typescript", SkillCategory.FRONTEND),
                new Skill("Angular", SkillCategory.FRONTEND),
                new Skill("Bootstrap", SkillCategory.FRONTEND),
                new Skill("Tailwind", SkillCategory.FRONTEND),

                // Backend
                new Skill("Java", SkillCategory.BACKEND),
                new Skill("Spring", SkillCategory.BACKEND),
                new Skill("Hibernate", SkillCategory.BACKEND),
                new Skill("Jakarta EE", SkillCategory.BACKEND),
                new Skill("JDBC", SkillCategory.BACKEND),

                // Database
                new Skill("Sql", SkillCategory.DATABASE),
                new Skill("PostgreSQL", SkillCategory.DATABASE),
                new Skill("MySql", SkillCategory.DATABASE),
                new Skill("Microsoft SQL Server", SkillCategory.DATABASE),

                // Tools
                new Skill("Git", SkillCategory.TOOLS),
                new Skill("Docker", SkillCategory.TOOLS),
                new Skill("Jira", SkillCategory.TOOLS),
                new Skill("Uml", SkillCategory.TOOLS),
                new Skill("Bpmn", SkillCategory.TOOLS),

                // Design
                new Skill("Figma", SkillCategory.DESIGN),
                new Skill("Blender", SkillCategory.DESIGN),
                new Skill("Adobe Photoshop", SkillCategory.DESIGN),
                new Skill("Illustrator", SkillCategory.DESIGN),
                new Skill("Lightroom", SkillCategory.DESIGN)

        );

        for (Skill skill : skills) {
            if (!skillRepository.existsByNameIgnoreCase(skill.getName())) {
                skillRepository.save(skill);
            }
        }

        // Projects
        if (projectRepository.count() == 0) {
            List<String> techNames = List.of("Angular", "Spring", "PostgreSQL", "Docker");
            List<Skill> techStack = skillRepository.findByNameIn(techNames);

            Project project = new Project();
            project.setTitle("Hybridvision");
            project.setDescription("A Music Studio website built with Angular, Spring Boot, Stripe, AWS S3, and Docker. " +
                    "This platform allows users to explore the studio's services, purchase music productions, and sample packs, " +
                    "while providing an admin panel to manage users and content.");
            project.setImageUrl("https://res.cloudinary.com/dozrra9cw/image/upload/v1748525827/Hybridvision_g20kan.gif");
            project.setDemoUrl("");
            project.setCodeUrl("https://github.com/ismailjacoby/Hybridvision-Music-Studio-Website");
            project.setPublic(true);
            project.setTechnologies(techStack);

            projectRepository.save(project);
        }
    }
}
