package com.valladares.raceapi.resource;

import javax.validation.Valid;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.valladares.raceapi.model.Pilot;
import com.valladares.raceapi.repository.Pilots;

import java.util.List;

@RestController
@RequestMapping("/api/racers")
public class PilotResource {
	
	@Autowired
	private Pilots pilots;
	
	@PostMapping
	public Pilot addPilot(@Valid @RequestBody Pilot pilot) {
		return pilots.save(pilot);
	}

	@GetMapping
    public List<Pilot> getAllPilots() {
	    return pilots.findAll();
    }
	
	@GetMapping("/api/pilots/{id}")
	public ResponseEntity<Pilot> getAPilot(@PathVariable Long id) {
		Pilot pilot = pilots.getOne(id);
		
		if(pilot == null)
			return ResponseEntity.notFound().build();

		return ResponseEntity.ok(pilot);
	}

	@PutMapping("/{id}")
	public ResponseEntity<Pilot> updatePilot(@PathVariable Long id, @Valid @RequestBody Pilot pilot) {
	    Pilot currentPilot = pilots.getOne(id);

	    if(currentPilot == null)
	        return ResponseEntity.notFound().build();

        BeanUtils.copyProperties(pilot, currentPilot, "id");

	    currentPilot = pilots.save(currentPilot);

	    return ResponseEntity.ok(currentPilot);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePilot(@PathVariable Long id) {
        Pilot pilot = pilots.getOne(id);

        if(pilot == null)
            return ResponseEntity.notFound().build();

        pilots.delete(pilot);

        return ResponseEntity.noContent().build();
    }

}
