import java.util.Arrays;

public class DNAAnalyzer {
    private static int moleculeSize = 0;

    public static boolean isMutant(String[] dnaMolecule) throws Exception {
        boolean isMutantDNA = false;

        System.out.printf("There are %d chains in the DNA Molecule%n", Arrays.stream(dnaMolecule).count());

        if (!isValidDNA(dnaMolecule)) {
            throw new Exception("The DNA Molecule is defective");
        }

        System.out.println("The DNA molecule is valid");

        // Check if is actually a mutant
        for (int c = 0; c < Arrays.stream(dnaMolecule).count(); c++) {
            System.out.printf("Chain %s%n", dnaMolecule[c]);

            int basesCountInARow = 0;
            int basesCountInAColumn = 0;
            int basesCountInEastDiagonal = 0;
            int basesCountInWestDiagonal = 0;
            String chain = dnaMolecule[c];

            for (int b = 0; b < chain.length(); b++) {
                // Check the base with the next in the row
                System.out.printf("Base %s%n", chain.toCharArray()[b]);

                String base = Character.toString(chain.toCharArray()[b]);

                // Test the column
                if (b + 3 == chain.length()) {
                    // This is out of row scope, so can brake the loop here
                    break;
                }

                String baseOneStepNext = Character.toString(chain.toCharArray()[b + 1]);
                String baseTwoStepsNext = Character.toString(chain.toCharArray()[b + 2]);
                String baseThreeStepsNext = Character.toString(chain.toCharArray()[b + 3]);

                if (c + 3 == Arrays.stream(dnaMolecule).count()) {
                    // this is out of the column scope, so can brake the loop here
                    break;
                }

                String baseOneStepBelow = Character.toString(dnaMolecule[c + 1].toCharArray()[b]);
                String baseTwoStepsBelow = Character.toString(dnaMolecule[c + 2].toCharArray()[b]);
                String baseThreeStepsBelow = Character.toString(dnaMolecule[c + 3].toCharArray()[b]);

                String baseOneStepDiagonalEast = Character.toString(dnaMolecule[c + 1].toCharArray()[b + 1]);
                String baseTwoStepDiagonalEast = Character.toString(dnaMolecule[c + 2].toCharArray()[b + 2]);
                String baseThreeStepDiagonalEast = Character.toString(dnaMolecule[c + 2].toCharArray()[b + 3]);

                //if (base == chain.toCharArray()[b])
            }

            System.out.println("===");
            if (isMutantDNA) break;
        }

        return isMutantDNA;
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
