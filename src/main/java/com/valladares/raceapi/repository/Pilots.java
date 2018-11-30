package com.valladares.raceapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.valladares.raceapi.model.Pilot;

public interface Pilots extends JpaRepository<Pilot, Long> {}
