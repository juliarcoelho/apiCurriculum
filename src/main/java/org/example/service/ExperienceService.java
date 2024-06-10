package org.example.service;
import org.example.entity.Experience;
import org.example.repository.ExperienceRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ExperienceService {
    @Autowired
    private ExperienceRepository experienceRepository;

    public List<Experience> findAll() {
        return experienceRepository.findAll();
    }

    public Optional<Experience> findById(Long id) {
        return experienceRepository.findById(id);
    }

    public Experience save(Experience experience) {
        return experienceRepository.save(experience);
    }

    public void deleteById(Long id) {
        experienceRepository.deleteById(id);
    }
}
