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

import com.dna.analyzer.classes.Genome;
import com.dna.analyzer.classes.GenomeService;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.dna.analyzer.classes.AnalysisStats;
import com.dna.analyzer.classes.DNAAnalyzer;

@RestController
public class DNAAnalyzerController {
	@GetMapping("/")
	public String root() {
		return "Mutant checker API";
	}

	@PostMapping(value = "/mutant", consumes = { MediaType.APPLICATION_JSON_VALUE })
	@ResponseBody
	public ResponseEntity<HttpStatus.Series> isMutant(@RequestBody Genome genome) throws Exception {
		ResponseEntity<HttpStatus.Series> response = null;

		try {
			boolean isAMutant = DNAAnalyzer.isMutant(genome.dna);

			if (isAMutant) {
				genome.is_mutant = true;
				response = new ResponseEntity<Series>(HttpStatus.OK);
			} else {
				genome.is_human = true;
				response = new ResponseEntity<Series>(HttpStatus.FORBIDDEN);
			}
		} catch (Exception e) {
			genome.is_defective = true;
			response = new ResponseEntity<Series>(HttpStatus.BAD_REQUEST);
		}

		try {
			GenomeService.createGenome(genome);
		} catch (Exception e) {
			response = new ResponseEntity<Series>(HttpStatus.FOUND);
		}

		return response;
	}

	@GetMapping(value = "/stats", produces = { MediaType.APPLICATION_JSON_VALUE })
	@ResponseBody
	public String getStats() throws Exception {
		AnalysisStats stats = GenomeService.getGenomesStats();
		ObjectMapper mapper = new ObjectMapper();
		String statsstr = mapper.writeValueAsString(stats);
		return statsstr;
	}
}
