package aed.avaliacao.recurso;

public class MainAvaliacaoSomaDigitos {
    public static void main(String[] args) {

        int[] ns = {1, 10, -7, 12345};
        for (int n : ns) {
            SomaDigitosRecursiva.apresentar(n);
            SomaDigitosIterativa.apresentar(n);
        }
    }
}
