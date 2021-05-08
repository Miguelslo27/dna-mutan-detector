package com.dna.analyzer.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dna.analyzer.classes.DNAAnalyzer;

@RestController
public class DNAAnalyzerController {
	@GetMapping("/")
	public String root() {
		return "Mutant checker API";
	}

	@PostMapping("/mutant")
	public boolean isMutant() throws Exception {
		boolean isAMutant = DNAAnalyzer.isMutant(new String[] {
	        "ATGCGA",
	        "CAGTTC",
	        "TTATGT",
	        "AGTCGG",
	        "CTCTTA",
	        "CCACTG"
		});
		return isAMutant;
	}
}
