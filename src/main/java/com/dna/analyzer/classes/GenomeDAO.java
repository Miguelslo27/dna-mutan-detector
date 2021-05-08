package com.dna.analyzer.classes;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.fasterxml.jackson.databind.ObjectMapper;

public class GenomeDAO {
	public static void createGenomeDB(Genome genome) throws Exception {
		ObjectMapper mapper = new ObjectMapper();

		try (Connection db = DBConnection.getConnection()) {
			PreparedStatement statement = null;
			String query = "INSERT INTO genomes (dna, is_mutant, is_human, is_defective) values (?, ?, ?, ?)";

			try {
				String genomestr = mapper.writeValueAsString(genome.dna);

				try {
					statement = db.prepareStatement(query);
					statement.setString(1, genomestr);
					statement.setBoolean(2, genome.is_mutant);
					statement.setBoolean(3, genome.is_human);
					statement.setBoolean(4, genome.is_defective);
					statement.executeUpdate();

					System.out.println("Genome saved to the registry!");
				} catch (SQLException e) {
					throw e;
				}
			} catch (Exception e) {
				throw e;
			}
		} catch (SQLException e) {
			throw e;
		}
	}

	public static Genome[] getGenomesDB() {
		Genome[] genomes = null;
		return genomes;
	}
}
