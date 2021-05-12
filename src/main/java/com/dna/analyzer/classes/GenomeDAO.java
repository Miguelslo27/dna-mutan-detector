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
			String genomestr = mapper.writeValueAsString(genome.dna);

			statement = db.prepareStatement(query);
			statement.setString(1, genomestr);
			statement.setBoolean(2, genome.is_mutant);
			statement.setBoolean(3, genome.is_human);
			statement.setBoolean(4, genome.is_defective);
			statement.executeUpdate();
		} catch (SQLException e) {
			throw e;
		}
	}

	public static AnalysisStats getGenomesStats() throws Exception {
		AnalysisStats analysis = null;
		try (Connection db = DBConnection.getConnection()) {
			PreparedStatement statement = null;
			ResultSet result = null;

			String query = "SELECT SUM(is_mutant) as count_mutant_dna, SUM(is_human) as count_human_dna FROM genomes WHERE is_defective = 0";

			statement = db.prepareStatement(query);
			result = statement.executeQuery();

			int countMutantDNA = 0;
			int countHumanDNA = 0;

			if (result.next()) {
				countMutantDNA = result.getInt("count_mutant_dna");
				countHumanDNA = result.getInt("count_human_dna");
			}

			analysis = new AnalysisStats(countMutantDNA, countHumanDNA);
		} catch (SQLException e) {
			throw e;
		}

		return analysis;
	}
}
