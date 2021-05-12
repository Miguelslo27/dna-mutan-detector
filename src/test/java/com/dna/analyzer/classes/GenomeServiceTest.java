package com.dna.analyzer.classes;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class GenomeServiceTest {

	@Test
	void testAnalyzeDNAWithInvalidDNA() {
		String[] dnaMolecule = new String[] { "ATGCGA", "CAGTGC", "TTATGT", "AGAAGG", "CCCCTA" };
		
		try {
			Genome genome = new Genome(1, dnaMolecule, false, false, false);
			String defectiveDNA = GenomeService.analyzeDNA(genome);
			assertEquals("DEFECTIVE", defectiveDNA, "Should return true for a valid DNA Molecule");
		} catch (Exception e) { }
	}
	
	@Test
	void testAnalyzeDNAWithHumanDNA() {
		String[] dnaMolecule = new String[] { "ATGCGA", "CAGTGC", "TTATGT", "AGAAGG", "CCCCTA", "TCACTG" };
		
		try {
			Genome genome = new Genome(1, dnaMolecule, false, false, false);
			String defectiveDNA = GenomeService.analyzeDNA(genome);
			assertEquals("FORBIDDEN", defectiveDNA, "Should return true for a valid DNA Molecule");
		} catch (Exception e) { }
	}

}
