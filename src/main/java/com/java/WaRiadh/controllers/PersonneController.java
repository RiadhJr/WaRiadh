package com.java.WaRiadh.controllers;

import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;
import java.util.Calendar;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.java.WaRiadh.DTO.PersonneDTO;
import com.java.WaRiadh.entities.Personne;
import com.java.WaRiadh.repositories.PersonneRepository;


@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api")
public class PersonneController {
	
	@Autowired
	PersonneRepository personneRepository;
	
	@PostMapping("/personnes")
    public ResponseEntity<String> createPerson(@RequestBody  Personne  personne) {

		Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.YEAR, -150);
        Date maxAllowedDate = calendar.getTime();

        if (personne.getDate_de_naissance().after(maxAllowedDate)) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body("Only persons under 150 years old can be registered");
        }

        personneRepository.save(personne);

        return ResponseEntity.status(HttpStatus.CREATED)
                .body("Person successfully registered");
    }
	
	
	 @GetMapping("/personnes")
	    public List<PersonneDTO> getAllPersons() {
	        List<Personne> personnes = personneRepository.findAll();

	        return personnes.stream()
	                .map(this::mapPersonToDTO)
	                .sorted(Comparator.comparing(PersonneDTO::getNom))
	                .collect(Collectors.toList());
	    }
	 
	 
	 private PersonneDTO mapPersonToDTO(Personne personne) {
	        LocalDate currentDate = LocalDate.now();
	        LocalDate birthdate = personne.getDate_de_naissance().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
	        int age = Period.between(birthdate, currentDate).getYears();

	        return new PersonneDTO(personne.getPersonne_nom(), age);
	    }
}