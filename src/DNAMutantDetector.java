public class DNAMutantDetector {
    public static void main(String[] args) {
        // Here starts the project
        System.out.println("Let's checkout if there is a mutant here!");

        new DNAAnalyzer();
        DNAAnalyzer.isMutant(new String[] {
            "ATGCGA",
            "CAGTGC",
            "TTATGT",
            "AGAAGG",
            "CCCCTA",
            "TCACTG"
        });
    }
}
