package com.dna.analyzer.classes;

public class GenomeService {
	public static void createGenome(Genome genome) throws Exception {
		GenomeDAO.createGenomeDB(genome);
	}
	
	public static Genome[] getGenomes() throws Exception {
		Genome[] genomes = null;
		return genomes;
	}
}
