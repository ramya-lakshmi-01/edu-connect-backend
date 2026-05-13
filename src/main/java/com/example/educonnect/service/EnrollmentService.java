package com.example.educonnect.service;

import com.example.educonnect.entity.Course;
import com.example.educonnect.entity.Enrollment;
import com.example.educonnect.repository.CourseRepository;
import com.example.educonnect.repository.EnrollmentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EnrollmentService {

    private final EnrollmentRepository enrollmentRepository;
    private final CourseRepository courseRepository;

    public EnrollmentService(EnrollmentRepository enrollmentRepository, CourseRepository courseRepository) {
        this.enrollmentRepository = enrollmentRepository;
        this.courseRepository = courseRepository;
    }

    public Enrollment enrollStudent(Long courseId, Enrollment enrollment) {
        Course course = courseRepository.findById(courseId).orElse(null);

        if (course == null) {
            return null;
        }

        enrollment.setCourse(course);
        return enrollmentRepository.save(enrollment);
    }

    public List<Enrollment> getMyEnrollments(String email) {
        return enrollmentRepository.findByStudentEmail(email);
    }

    public void dropEnrollment(Long enrollmentId) {
        enrollmentRepository.deleteById(enrollmentId);
    }
}