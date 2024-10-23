package aed.avaliacao.recurso;

public class SomaDigitosRecursiva {

    public static long executar(int n) {
        //todo pergunta 1.a)
        if(n==0) {
            return n;
        }
        //System.out.println(n%10);
        return (n%10)+executar(n/10);
    }

    public static void apresentar(int n) {
        try {
            System.out.println("Soma recursiva dos dígitos de " + n + " = " + executar(n));
        } catch (IllegalArgumentException ex) {
            System.out.println(ex.getMessage() + "\n");
        }
    }
}
