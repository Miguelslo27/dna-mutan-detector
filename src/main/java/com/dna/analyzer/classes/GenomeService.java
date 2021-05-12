package com.dna.analyzer.classes;

public class GenomeService {
	public static String analyzeDNA(Genome genome) {
		try {
			boolean isValid = DNAAnalyzer.isValidDNA(genome.dna);
			boolean isMutant = DNAAnalyzer.isMutant(genome.dna);
			genome.is_mutant = isMutant;
			genome.is_human = !isMutant;
			genome.is_defective = !isValid;
			createGenome(genome);
			return isValid ? isMutant ? "OK" : "FORBIDDEN" : "DEFECTIVE";
		} catch (Exception e) {
			return "PROBABLY_DUPLICATED";
		}
	}

	public static void createGenome(Genome genome) throws Exception {
		GenomeDAO.createGenome(genome);
	}

	public static AnalysisStats getGenomesStats() throws Exception {
		return GenomeDAO.getGenomesStats();
	}
}
