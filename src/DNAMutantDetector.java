public class DNAMutantDetector {
    public static void main(String[] args) throws Exception {
        // Here starts the project
        System.out.println("Let's checkout if there is a mutant here!");

        new DNAAnalyzer();
        DNAAnalyzer.isMutant(new String[] {
            "ATGCGA",
            "CAGTTC",
            "TTATGT",
            "AGTCGG",
            "CTCTTA",
            "TCACTG"
        });
    }
}
