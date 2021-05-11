package com.dna.analyzer.classes;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.fasterxml.jackson.databind.ObjectMapper;

public class GenomeDAO {
	public static void createGenome(Genome genome) throws Exception {
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

	public static AnalysisStats getGenomesStats() throws Exception {
		AnalysisStats analysis = null;
		try (Connection db = DBConnection.getConnection()) {
			PreparedStatement statement = null;
			ResultSet result = null;

			String query = "SELECT SUM(is_mutant), SUM(is_human) FROM genomes WHERE is_defective = 0";

			statement = db.prepareStatement(query);
			result = statement.executeQuery();

			int countMutantDNA = 0;
			int countHumanDNA = 0;

			if (result.next()) {
				countMutantDNA = result.getInt("is_mutant");
				countHumanDNA = result.getInt("is_human");
			}

			analysis = new AnalysisStats(countMutantDNA, countHumanDNA);
		} catch (SQLException e) {
			throw e;
		}

		return analysis;
	}
}
