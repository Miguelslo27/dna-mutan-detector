package com.dna.analyzer.classes;

public class Genoma {
	private String[] dna;
	private boolean is_mutant;
	private boolean is_human;
	private boolean is_defective;

	public String[] getDna() {
		return dna;
	}

	public void setDna(String[] dna) {
		this.dna = dna;
	}

	public boolean isIs_mutant() {
		return is_mutant;
	}

	public void setIs_mutant(boolean is_mutant) {
		this.is_mutant = is_mutant;
	}

	public boolean isIs_human() {
		return is_human;
	}

	public void setIs_human(boolean is_human) {
		this.is_human = is_human;
	}

	public boolean isIs_defective() {
		return is_defective;
	}

	public void setIs_defective(boolean is_defective) {
		this.is_defective = is_defective;
	}
}
