package com.skilldistillery.enginex.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.skilldistillery.enginex.entities.JobStatus;

public interface JobStatusRepository extends JpaRepository<JobStatus, Integer> {

	JobStatus findByName(String name);
}
