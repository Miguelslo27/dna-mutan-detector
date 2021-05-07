import java.util.Arrays;

public class DNAAnalyzer {
    private static int moleculeSize = 0;

    public static void isMutant(String[] dnaMolecule) throws Exception {
        boolean isMutantDNA = false;
        System.out.printf("There are %d chains in the DNA Molecule%n", Arrays.stream(dnaMolecule).count());

        if (!isValidDNA(dnaMolecule)) {
            throw new Exception("The DNA Molecule is defective");
        }

        System.out.println("The DNA molecule is valid");

        int basesCountInARow = 0;
        int basesCountInAColumn = 0;
        int basesCountInEastDiagonal = 0;
        int basesCountInWestDiagonal = 0;

        // Check if is actually a mutant
        for (int c = 0; c < Arrays.stream(dnaMolecule).count(); c++) {
            System.out.printf("Chain %s%n", dnaMolecule[c]);

            String chain = dnaMolecule[c];

            // Check the base with the next in the row
            for (int b = 0; b < chain.length(); b++) {
                System.out.println(chain.toCharArray()[b]);

                if (b + 1 >= chain.length() || b + 2 >= chain.length() || b + 3 >= chain.length()) {
                    System.out.println("====================");
                    break;
                }

                System.out.println(chain.toCharArray()[b + 1]);
                System.out.println(chain.toCharArray()[b + 2]);
                System.out.println(chain.toCharArray()[b + 3]);

                if (
                    chain.toCharArray()[b] == chain.toCharArray()[b + 1]
                    && chain.toCharArray()[b] == chain.toCharArray()[b + 2]
                    && chain.toCharArray()[b] == chain.toCharArray()[b + 3]
                ) {
                    isMutantDNA = true;
                    break;
                }

                System.out.println("====================");
            }

            if (isMutantDNA) break;

            // Check the base with the next in the column
            // Check the base with the next in the diagonal east
        }
    }

    public static boolean isValidDNA(String[] dnaMolecule) {
        int chainLength = 0;
        boolean isTheFirstChain = true;
        boolean isValid = true;
        moleculeSize = (int) Arrays.stream(dnaMolecule).count();

        for (String chain : dnaMolecule) {
            // System.out.printf("Chain %s%n", chain);
            // System.out.printf("The chain has %d bases%n", chain.length());

            if ((!isTheFirstChain && chainLength != chain.length()) || moleculeSize != chain.length()) {
                isValid = false;
                break;
            }

            if (isTheFirstChain) {
                chainLength = chain.length();
                isTheFirstChain = false;
            }
        }

        return isValid;
    }
}
