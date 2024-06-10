package org.example.service;
import org.example.repository.CurriculumRepository;
import org.example.entity.Curriculum;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CurriculumService {
    @Autowired
    private CurriculumRepository curriculumRepository;

    public List<Curriculum> findAll() {
        return curriculumRepository.findAll();
    }

    public Optional<Curriculum> findById(Long id) {
        return curriculumRepository.findById(id);
    }

    public Curriculum save(Curriculum resume) {
        return curriculumRepository.save(resume);
    }

    public void deleteById(Long id) {
        curriculumRepository.deleteById(id);
    }

}
