package org.example.controller;
import org.example.entity.Curriculum;
import org.example.service.CurriculumService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/curriculum")
public class CurriculumController {
    @Autowired
    private CurriculumService curriculumService;

    @GetMapping
    public List<Curriculum> getAllCurriculums() {
        return curriculumService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Curriculum> getCurriculumById(@PathVariable Long id) {
        Optional<Curriculum> curriculum = curriculumService.findById(id);
        return curriculum.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public Curriculum createCurriculum(@RequestBody Curriculum curriculum) {
        return curriculumService.save(curriculum);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Curriculum> updateCurriculum(@PathVariable Long id, @RequestBody Curriculum curriculumDetails) {
        Optional<Curriculum> curriculumOptional = curriculumService.findById(id);
        if (curriculumOptional.isPresent()) {
            Curriculum resume = curriculumOptional.get();
            resume.setObjective(curriculumDetails.getObjective());
            resume.setUser(curriculumDetails.getUser());
            resume.setExperiences(curriculumDetails.getExperiences());
            Curriculum updatedResume = curriculumService.save(resume);
            return ResponseEntity.ok(updatedResume);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCurriculum(@PathVariable Long id) {
        Optional<Curriculum> curriculumOptional = curriculumService.findById(id);
        if (curriculumOptional.isPresent()) {
            curriculumService.deleteById(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
