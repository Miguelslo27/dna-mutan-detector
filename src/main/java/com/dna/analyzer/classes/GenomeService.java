package com.dna.analyzer.classes;

import java.sql.SQLException;

public class GenomeService {
	public static void createGenome(Genome genome) throws SQLException {
		GenomeDAO.createGenomeDB(genome);
	}
	
	public static Genome[] getGenomes() throws SQLException {
		Genome[] genomes = null;
		return genomes;
	}
}
