package aed.avaliacao.recurso;

public class SomaDigitosIterativa {

    public static long executar(int n) {
        //todo pergunta 1.b)
        long soma = 0;
        while(n!=0){
            soma += n%10;
            n /= 10;
        }
        return soma;
    }

    public static void apresentar(int n) {
        try {
            System.out.println("Soma iterativa dos dígitos de " + n + " = " + executar(n));
        } catch (IllegalArgumentException ex) {
            System.out.println(ex.getMessage() + "\n");
        }
    }
}
