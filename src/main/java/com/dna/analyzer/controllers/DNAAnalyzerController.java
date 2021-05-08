package com.dna.analyzer.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DNAAnalyzerController {
	@GetMapping("/")
	public String isMutant() {
		return "Hey there!";
	}
}
