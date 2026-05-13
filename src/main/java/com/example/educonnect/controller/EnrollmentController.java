package com.example.educonnect.controller;

import com.example.educonnect.entity.Enrollment;
import com.example.educonnect.service.EnrollmentService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/enrollments")
@CrossOrigin(origins = "*")
public class EnrollmentController {

    private final EnrollmentService enrollmentService;

    public EnrollmentController(EnrollmentService enrollmentService) {
        this.enrollmentService = enrollmentService;
    }

    @PostMapping("/course/{courseId}")
    public Enrollment enrollStudent(@PathVariable Long courseId, @RequestBody Enrollment enrollment) {
        return enrollmentService.enrollStudent(courseId, enrollment);
    }

    @GetMapping("/student")
    public List<Enrollment> getMyEnrollments(@RequestParam String email) {
        return enrollmentService.getMyEnrollments(email);
    }

    @DeleteMapping("/{enrollmentId}")
    public String dropEnrollment(@PathVariable Long enrollmentId) {
        enrollmentService.dropEnrollment(enrollmentId);
        return "Enrollment dropped successfully";
    }
}