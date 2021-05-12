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

@RestController
public class DNAAnalyzerController {
	@GetMapping("/")
	public String root() {
		return "Mutant checker API";
	}

	@PostMapping(value = "/mutant", consumes = { MediaType.APPLICATION_JSON_VALUE })
	@ResponseBody
	public ResponseEntity<Series> isMutant(@RequestBody Genome genome) throws Exception {
		switch (GenomeService.analyzeDNA(genome)) {
		case "OK":
			return new ResponseEntity<Series>(HttpStatus.OK);
		case "FORBIDDEN":
			return new ResponseEntity<Series>(HttpStatus.FORBIDDEN);
		case "PROBABLY_DUPLICATED":
			return new ResponseEntity<Series>(HttpStatus.FOUND);
		case "DEFECTIVE":
			return new ResponseEntity<Series>(HttpStatus.BAD_REQUEST);
		default:
			return new ResponseEntity<Series>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
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
