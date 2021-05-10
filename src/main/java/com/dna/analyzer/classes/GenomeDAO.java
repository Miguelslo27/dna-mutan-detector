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

	public static AnalycisStats getGenomesStats() throws Exception {
		AnalycisStats analycis = null;
		try (Connection db = DBConnection.getConnection()) {
			PreparedStatement statement = null;
			ResultSet result = null;

			String query = "SELECT" + " SUM(CASE WHEN is_mutant = 1 THEN 1 ELSE 0 END) as count_mutant_dna,"
					+ " SUM(CASE WHEN is_human = 1 THEN 1 ELSE 0 END) as count_human_dna" + " FROM genomes LIMIT 1";

			statement = db.prepareStatement(query);
			result = statement.executeQuery();

			int countMutantDNA = 0;
			int countHumanDNA = 0;

			if (result.next()) {
				countMutantDNA = result.getInt("count_mutant_dna");
				countHumanDNA = result.getInt("count_human_dna");
			}

			analycis = new AnalycisStats(countMutantDNA, countHumanDNA);
		} catch (SQLException e) {
			throw e;
		}

		return analycis;
	}
}
