package com.dna.analyzer.classes;

public class AnalycisStats {
	public int count_mutant_dna;
	public int count_human_dna;
	public float ratio;

	public AnalycisStats(int count_mutant_dna, int count_human_dna) {
		try {
			this.count_mutant_dna = count_mutant_dna;
			this.count_human_dna = count_human_dna;
			this.ratio = count_mutant_dna / count_human_dna;
		} catch (Exception e) {
			this.count_mutant_dna = count_mutant_dna;
			this.count_human_dna = count_human_dna;
			this.ratio = 0;
		}
	}
}
