package com.dna.analyzer.classes;

import java.util.Arrays;

public class DNAAnalyzer {
	private static int moleculeSize = 0;

	public static boolean isMutant(String[] dnaMolecule) {
		boolean isMutantDNA = false;
		int mutantDNACounter = 0;

		if (!isValidDNA(dnaMolecule)) {
			return false;
		}

		// Check if is actually a mutant
		for (int c = 0; c < dnaMolecule.length; c++) {
			String chain = dnaMolecule[c];

			for (int b = 0; b < chain.length(); b++) {
				char base = chain.charAt(b);

				// Test the row
				if (b + 3 < chain.length()) {
					boolean mutantTrace = true;
					for (int i = 1; i <= 3; i++) {
						char nextBase = chain.charAt(b + i);
						if (base != nextBase) {
							mutantTrace = false;
						}
					}
					if (mutantTrace) {
						mutantDNACounter++;
						if (mutantDNACounter == 2) {
							isMutantDNA = true;
							break;
						}
					}
				}

				// Test the column
				if (c + 3 < Arrays.stream(dnaMolecule).count()) {
					boolean mutantTrace = true;
					for (int i = 1; i <= 3; i++) {
						char nextBase = dnaMolecule[c + i].charAt(b);
						if (base != nextBase) {
							mutantTrace = false;
						}
					}
					if (mutantTrace) {
						mutantDNACounter++;
						if (mutantDNACounter == 2) {
							isMutantDNA = true;
							break;
						}
					}
				}

				// Test the diagonal east
				if (b + 3 < chain.length() && c + 3 < dnaMolecule.length) {
					boolean mutantTrace = true;
					for (int i = 1; i <= 3; i++) {
						char nextBase = dnaMolecule[c + i].charAt(b + i);
						if (base != nextBase) {
							mutantTrace = false;
						}
					}
					if (mutantTrace) {
						mutantDNACounter++;
						if (mutantDNACounter == 2) {
							isMutantDNA = true;
							break;
						}
					}
				}

				// Test the diagonal west
				if (b - 3 > 0 && c + 3 < dnaMolecule.length) {
					boolean mutantTrace = true;
					for (int i = 1; i <= 3; i++) {
						char nextBase = dnaMolecule[c + i].charAt(b - 1);
						if (base != nextBase) {
							mutantTrace = false;
						}
					}
					if (mutantTrace) {
						mutantDNACounter++;
						if (mutantDNACounter == 2) {
							isMutantDNA = true;
							break;
						}
					}
				}
			}

			if (isMutantDNA)
				break;
		}

		return isMutantDNA;
	}

	public static boolean isValidDNA(String[] dnaMolecule) {
		String dnaAcceptableBases = "ATCG";
		moleculeSize = dnaMolecule.length;

		if (moleculeSize == 0) {
			return false;
		}

		for (String chain : dnaMolecule) {
			if (moleculeSize != chain.length()) {
				return false;
			}

			for (Character base : chain.toCharArray()) {
				// Check the base type
				if (!dnaAcceptableBases.contains(Character.toString(base))) {
					return false;
				}
			}
		}

		return true;
	}
}
