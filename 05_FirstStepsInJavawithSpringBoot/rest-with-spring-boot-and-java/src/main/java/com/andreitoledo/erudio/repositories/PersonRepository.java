package com.andreitoledo.erudio.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.andreitoledo.erudio.model.Person;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long>{}
