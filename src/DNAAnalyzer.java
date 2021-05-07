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

            String chain = dnaMolecule[c];

            for (int b = 0; b < chain.length(); b++) {
                // Check the base with the next in the row
                System.out.printf("Base %s%n", chain.toCharArray()[b]);

                String base = Character.toString(chain.toCharArray()[b]);

                // Test the column
                if (b + 3 < chain.length()) {
                    String baseOneStepNext = Character.toString(chain.toCharArray()[b + 1]);
                    String baseTwoStepsNext = Character.toString(chain.toCharArray()[b + 2]);
                    String baseThreeStepsNext = Character.toString(chain.toCharArray()[b + 3]);

                    System.out.printf("%s - %s - %s - %s%n", base, baseOneStepNext, baseTwoStepsNext, baseThreeStepsNext);
                    System.out.printf("For %s == %s: %b%n", base, baseOneStepNext, base.equals(baseOneStepNext));
                    System.out.printf("For %s == %s: %b%n", base, baseTwoStepsNext, base.equals(baseTwoStepsNext));
                    System.out.printf("For %s == %s: %b%n", base, baseThreeStepsNext, base.equals(baseThreeStepsNext));

                    if (base.equals(baseOneStepNext) && base.equals(baseTwoStepsNext) && base.equals(baseThreeStepsNext)) {
                        isMutantDNA = true;
                        break;
                    }
                }

                if (c + 3 < Arrays.stream(dnaMolecule).count()) {
                    String baseOneStepBelow = Character.toString(dnaMolecule[c + 1].toCharArray()[b]);
                    String baseTwoStepsBelow = Character.toString(dnaMolecule[c + 2].toCharArray()[b]);
                    String baseThreeStepsBelow = Character.toString(dnaMolecule[c + 3].toCharArray()[b]);
                }

                if (b + 3 < chain.length() && c + 3 < Arrays.stream(dnaMolecule).count()) {
                    String baseOneStepDiagonalEast = Character.toString(dnaMolecule[c + 1].toCharArray()[b + 1]);
                    String baseTwoStepDiagonalEast = Character.toString(dnaMolecule[c + 2].toCharArray()[b + 2]);
                    String baseThreeStepDiagonalEast = Character.toString(dnaMolecule[c + 3].toCharArray()[b + 3]);
                }

                if (b - 3 > 0 && c + 3 < Arrays.stream(dnaMolecule).count()) {
                    String baseOneStepDiagonalWest = Character.toString(dnaMolecule[c + 1].toCharArray()[b - 1]);
                    String baseTwoStepDiagonalWest = Character.toString(dnaMolecule[c + 2].toCharArray()[b - 2]);
                    String baseThreeStepDiagonalWest = Character.toString(dnaMolecule[c + 3].toCharArray()[b - 3]);
                }
            }

            System.out.println("===");
            if (isMutantDNA) break;
        }

        System.out.printf("This is a Mutant DNA? %b", isMutantDNA);

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
        }

        return isValid;
    }
}
