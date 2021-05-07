import java.util.Arrays;

public class DNAAnalyzer {
    private static int moleculeSize = 0;

    public static boolean isMutant(String[] dnaMolecule) throws Exception {
        boolean isMutantDNA = false;

        if (!isValidDNA(dnaMolecule)) {
            throw new Exception("The DNA Molecule is defective");
        }

        // Check if is actually a mutant
        for (int c = 0; c < Arrays.stream(dnaMolecule).count(); c++) {
            String chain = dnaMolecule[c];

            for (int b = 0; b < chain.length(); b++) {
                String base = Character.toString(chain.toCharArray()[b]);

                // Test the row
                if (b + 3 < chain.length()) {
                    String baseOneStepNext = Character.toString(chain.toCharArray()[b + 1]);
                    String baseTwoStepsNext = Character.toString(chain.toCharArray()[b + 2]);
                    String baseThreeStepsNext = Character.toString(chain.toCharArray()[b + 3]);

                    if (base.equals(baseOneStepNext) && base.equals(baseTwoStepsNext) && base.equals(baseThreeStepsNext)) {
                        isMutantDNA = true;
                        break;
                    }
                }

                // Test the column
                if (c + 3 < Arrays.stream(dnaMolecule).count()) {
                    String baseOneStepBelow = Character.toString(dnaMolecule[c + 1].toCharArray()[b]);
                    String baseTwoStepsBelow = Character.toString(dnaMolecule[c + 2].toCharArray()[b]);
                    String baseThreeStepsBelow = Character.toString(dnaMolecule[c + 3].toCharArray()[b]);

                    if (base.equals(baseOneStepBelow) && base.equals(baseTwoStepsBelow) && base.equals(baseThreeStepsBelow)) {
                        isMutantDNA = true;
                        break;
                    }
                }

                // Test the diagonal east
                if (b + 3 < chain.length() && c + 3 < Arrays.stream(dnaMolecule).count()) {
                    String baseOneStepDiagonalEast = Character.toString(dnaMolecule[c + 1].toCharArray()[b + 1]);
                    String baseTwoStepDiagonalEast = Character.toString(dnaMolecule[c + 2].toCharArray()[b + 2]);
                    String baseThreeStepDiagonalEast = Character.toString(dnaMolecule[c + 3].toCharArray()[b + 3]);

                    if (base.equals(baseOneStepDiagonalEast) && base.equals(baseTwoStepDiagonalEast) && base.equals(baseThreeStepDiagonalEast)) {
                        isMutantDNA = true;
                        break;
                    }
                }

                // Test the diagonal west
                if (b - 3 > 0 && c + 3 < Arrays.stream(dnaMolecule).count()) {
                    String baseOneStepDiagonalWest = Character.toString(dnaMolecule[c + 1].toCharArray()[b - 1]);
                    String baseTwoStepDiagonalWest = Character.toString(dnaMolecule[c + 2].toCharArray()[b - 2]);
                    String baseThreeStepDiagonalWest = Character.toString(dnaMolecule[c + 3].toCharArray()[b - 3]);

                    if (base.equals(baseOneStepDiagonalWest) && base.equals(baseTwoStepDiagonalWest) && base.equals(baseThreeStepDiagonalWest)) {
                        isMutantDNA = true;
                        break;
                    }
                }
            }

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
            if ((!isTheFirstChain && chainLength != chain.length()) || moleculeSize != chain.length()) {
                isValid = false;
                break;
            }

            if (isTheFirstChain) {
                chainLength = chain.length();
                isTheFirstChain = false;
            }

            // Check bases types
        }

        return isValid;
    }
}
