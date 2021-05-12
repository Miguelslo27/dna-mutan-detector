package com.dna.analyzer.classes;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class DNAAnalyzerTest {

	@Test
	void testIsValidDNAWithValidDNA() {
		String[] dnaMolecule = new String[] { "ATGCGA", "CAGTGC", "TTATGT", "AGAAGG", "CCCCTA", "TCACTG" };

		try {
			boolean isValid = DNAAnalyzer.isValidDNA(dnaMolecule);
			assertTrue(isValid, "Should return true for a valid DNA Molecule");
		} catch (Exception e) { }
	}

	@Test
	void testIsValidDNAWithInvalidDNA() {
		String[] defectiveDNAMolecule_incompleteChain = new String[] { "ATGCGA", "CAGTGC", "TTATGT", "AGAAG", "CCCCTA",
				"TCACTG" };

		try {
			boolean isNotValid = DNAAnalyzer.isValidDNA(defectiveDNAMolecule_incompleteChain);
			assertFalse(isNotValid, "Should return false for a DNA Molecule with an incomplete chain");
		} catch (Exception e) { }

		String[] defectiveDNAMolecule_incompleteMolecule = new String[] { "ATGCGA", "CAGTGC", "TTATGT", "CCCCTA",
				"TCACTG" };

		try {
			boolean isNotValid = DNAAnalyzer.isValidDNA(defectiveDNAMolecule_incompleteMolecule);
			assertFalse(isNotValid, "Should return false for an incomplete DNA Molecule");
		} catch (Exception e) { }

		String[] defectiveDNAMolecule_incompleteMolecule_oneChainOnly = new String[] { "ATGCGA" };

		try {
			boolean isNotValid = DNAAnalyzer.isValidDNA(defectiveDNAMolecule_incompleteMolecule_oneChainOnly);
			assertFalse(isNotValid, "Should return false for an incomplete DNA Molecule");
		} catch (Exception e) { }

		String[] defectiveDNAMolecule_incompleteMolecule_noChain = new String[] {};

		try {
			boolean isNotValid = DNAAnalyzer.isValidDNA(defectiveDNAMolecule_incompleteMolecule_noChain);
			assertFalse(isNotValid, "Should return false for an incomplete DNA Molecule");
		} catch (Exception e) { }

		String[] defectiveDNAMolecule_unknownBases = new String[] { "ATGCGA", "CAGTGC", "TTATGT", "AQAAGG", "RCCCTA", "TCACTG" };

		try {
			boolean isNotValid = DNAAnalyzer.isValidDNA(defectiveDNAMolecule_unknownBases);
			assertFalse(isNotValid, "Should return false for an unknonw base in the DNA Molecule");
		} catch (Exception e) { }
	}

	@Test
	void testIsMutantDNAWithMutantDNA() {
		String[] dnaMolecule = new String[] { "ATGCGA", "CAGTGC", "TTATGT", "AGAAGG", "CCCCTA", "TCACTG" };

		try {
			boolean isMutant = DNAAnalyzer.isMutant(dnaMolecule);
			assertTrue(isMutant, "Should return true for a Mutant DNA Molecule");
		} catch (Exception e) { }
	}
	
	@Test
	void testIsMutantDNAWithHumanDNA() {
		String[] dnaMolecule = new String[] { "ATGCGA", "CAGTGC", "TTCTGT", "AGAAGG", "CCCCTA", "TCACTG" };

		try {
			boolean isMutant = DNAAnalyzer.isMutant(dnaMolecule);
			assertFalse(isMutant, "Should return false for a Human DNA Molecule");
		} catch (Exception e) { }
	}
}
