package com.thiagosseidel.hrworker.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.thiagosseidel.hrworker.entities.Worker;

public interface WorkerRepository extends JpaRepository<Worker, Long> {

	
}
