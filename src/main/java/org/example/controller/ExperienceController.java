package org.example.controller;
import org.example.service.ExperienceService;
import org.example.dto.ExperienceDTO;
import org.example.entity.Experience;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/experience")
public class ExperienceController {
    @Autowired
    private ExperienceService experienceService;

    @GetMapping
    public List<ExperienceDTO> getAllExperiences() {
        List<Experience> experiences = experienceService.findAll();
        return experiences.stream().map(this::convertToDTO).collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public Optional<Experience> getExperienceById(@PathVariable Long id) {
        return experienceService.findById(id);
    }

    @PostMapping
    public Experience addExperience(@RequestBody Experience experience) {
        return experienceService.save(experience);
    }

    @DeleteMapping("/{id}")
    public void deleteExperience(@PathVariable Long id) {
        experienceService.deleteById(id);
    }

    private ExperienceDTO convertToDTO(Experience experience) {
        ExperienceDTO dto = new ExperienceDTO();
        dto.setCompany(experience.getCompany());
        dto.setPosition(experience.getPosition());
        dto.setDescription(experience.getDescription());
        dto.setUser(experience.getCurriculum().getUser());
        return dto;
    }
}
