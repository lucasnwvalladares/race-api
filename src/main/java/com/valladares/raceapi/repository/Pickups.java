package com.valladares.raceapi.repository;

import com.valladares.raceapi.model.Pickup;
import org.springframework.data.jpa.repository.JpaRepository;

public interface Pickups extends JpaRepository<Pickup, Long> {
}
