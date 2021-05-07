import java.util.Arrays;

public class DNAAnalyzer {
    public static void isMutant(String[] dnaMolecule) {
        System.out.printf("There is %d chains in the DNA Molecule%n", Arrays.stream(dnaMolecule).count());
    }
}
