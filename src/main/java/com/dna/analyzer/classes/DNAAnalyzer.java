package com.dna.analyzer.classes;

public class DNAAnalyzer {
	private static int moleculeSize = 0;

	public static boolean isMutant(String[] dnaMolecule) throws Exception {
		boolean isMutantDNA = false;
		int mutantDNACounter = 0;

		if (!isValidDNA(dnaMolecule)) {
			throw new Exception("DNA is malformed");
		}

		// Check if is actually a mutant
		for (int c = 0; c < dnaMolecule.length; c++) {
			String chain = dnaMolecule[c];

			for (int b = 0; b < chain.length(); b++) {
				char base = chain.charAt(b);

				if (isAMutantDNATraceInMolecule(dnaMolecule, chain, c, base, b)) {
					mutantDNACounter++;
					if (mutantDNACounter == 2) {
						return true;
					}
				}
			}
		}

		return isMutantDNA;
	}

	public static boolean isAMutantDNATraceInMolecule(String[] dnaMolecule, String chain, int chain_index, char base,
			int base_index) {
		boolean isMutantTrace = false;

		// Test the row
		if (base_index + 3 < chain.length()) {
			isMutantTrace = true; // start assuming there is a mutant trace
			for (int i = 1; i <= 3; i++) {
				char nextBase = chain.charAt(base_index + i);
				if (base != nextBase) {
					isMutantTrace = false;
				}
			}
		}

		// Test the column
		if (chain_index + 3 < dnaMolecule.length) {
			isMutantTrace = true;
			for (int i = 1; i <= 3; i++) {
				char nextBase = dnaMolecule[chain_index + i].charAt(base_index);
				if (base != nextBase) {
					isMutantTrace = false;
				}
			}
		}

		// Test the diagonal east
		if (base_index + 3 < chain.length() && chain_index + 3 < dnaMolecule.length) {
			isMutantTrace = true;
			for (int i = 1; i <= 3; i++) {
				char nextBase = dnaMolecule[chain_index + i].charAt(base_index + i);
				if (base != nextBase) {
					isMutantTrace = false;
				}
			}
		}

		// Test the diagonal west
		if (base_index - 3 > 0 && chain_index + 3 < dnaMolecule.length) {
			isMutantTrace = true;
			for (int i = 1; i <= 3; i++) {
				char nextBase = dnaMolecule[chain_index + i].charAt(base_index - 1);
				if (base != nextBase) {
					isMutantTrace = false;
				}
			}
		}

		System.out.println("So true?");
		return isMutantTrace;
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
