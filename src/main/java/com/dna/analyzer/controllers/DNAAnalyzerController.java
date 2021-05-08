package com.dna.analyzer.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatus.Series;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.dna.analyzer.classes.Genoma;
import com.dna.analyzer.classes.DNAAnalyzer;

@RestController
public class DNAAnalyzerController {
	@GetMapping("/")
	public String root() {
		return "Mutant checker API";
	}

	@PostMapping(
		value = "/mutant",
		consumes = {MediaType.APPLICATION_JSON_VALUE}
	)
	@ResponseBody
	public ResponseEntity<HttpStatus.Series> isMutant(@RequestBody Genoma dna) {
		try {
			boolean isAMutant = DNAAnalyzer.isMutant(dna.dna);

			if (isAMutant) {
				return new ResponseEntity<Series>(HttpStatus.OK);
			} else {
				return new ResponseEntity<Series>(HttpStatus.FORBIDDEN);
			}
		} catch (Exception e) {
			return new ResponseEntity<Series>(HttpStatus.BAD_REQUEST);
		}
	}
}
