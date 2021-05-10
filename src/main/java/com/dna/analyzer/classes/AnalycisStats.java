package com.dna.analyzer.classes;

import java.text.DecimalFormat;

public class AnalycisStats {
	public int count_mutant_dna;
	public int count_human_dna;
	public double ratio;

	public AnalycisStats(double count_mutant_dna, double count_human_dna) {
		DecimalFormat decFormat = new DecimalFormat("###.#");

		try {
			this.count_mutant_dna = (int) count_mutant_dna;
			this.count_human_dna = (int) count_human_dna;
			this.ratio = Double.parseDouble(decFormat.format(count_mutant_dna / count_human_dna));
		} catch (Exception e) {
			this.count_mutant_dna = (int) count_mutant_dna;
			this.count_human_dna = (int) count_human_dna;
			this.ratio = 0;
		}
	}
}
