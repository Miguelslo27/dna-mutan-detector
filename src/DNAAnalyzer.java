import java.util.Arrays;

public class DNAAnalyzer {
    private static int moleculeSize = 0;

    public static void isMutant(String[] dnaMolecule) throws Exception {
        System.out.printf("There are %d chains in the DNA Molecule%n", Arrays.stream(dnaMolecule).count());

        if (!isValidDNA(dnaMolecule)) {
            throw new Exception("The DNA Molecule is defective");
        }

        System.out.printf("The DNA molecule is valid");
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
