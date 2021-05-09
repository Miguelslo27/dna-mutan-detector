package com.dna.analyzer.classes;

public class Genome {
	public int id;
	public String[] dna;
	public boolean is_mutant = false;
	public boolean is_human = false;
	public boolean is_defective = false;

	public Genome() {
	}

	public Genome(int id, String[] dna, boolean is_mutant, boolean is_human, boolean is_defective) {
		super();
		this.id = id;
		this.dna = dna;
		this.is_mutant = is_mutant;
		this.is_human = is_human;
		this.is_defective = is_defective;
	}
}
