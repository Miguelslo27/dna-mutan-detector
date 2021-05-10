package com.dna.analyzer.classes;

public class GenomeService {
	public static void createGenome(Genome genome) throws Exception {
		GenomeDAO.createGenome(genome);
	}

	public static AnalycisStats getGenomesStats() throws Exception {
		return GenomeDAO.getGenomesStats();
	}
}
