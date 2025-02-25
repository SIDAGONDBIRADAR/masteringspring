package com.eazybytes.eazyschool.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.eazybytes.eazyschool.model.Courses;

@Repository
public interface CoursesRepository extends JpaRepository<Courses, Integer> {

}
