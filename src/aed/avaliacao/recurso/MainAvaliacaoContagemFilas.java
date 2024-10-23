package aed.avaliacao.recurso;

import aed.colecoes.naoiteraveis.estruturas.Fila;

public class MainAvaliacaoContagemFilas {

    public static int contarElementosFilas(Fila<Integer> fila1, Fila<Integer> fila2) {
        //todo pergunta 2.
        /*if(fila1.isVazia()&&fila2.isVazia())
            return 0;
        if(fila1.isVazia())
            return contarFila(fila2);
        if(fila2.isVazia())
            return contarFila(fila1);

        int soma = 2;
        Integer primeiroElementoFila1 = fila1.remover();
        Integer primeiroElementoFila2 = fila2.remover();
        fila1.inserir(primeiroElementoFila1);
        fila2.inserir(primeiroElementoFila2);

        while(primeiroElementoFila2!=fila2.consultar() || primeiroElementoFila1!=fila1.consultar()){
            if(primeiroElementoFila1!=fila1.consultar()){
                fila1.inserir(fila1.remover());
                soma++;
            }
            if(primeiroElementoFila2!=fila2.consultar()){
                fila2.inserir(fila2.remover());
                soma++;
            }
        }
        return soma;*/

        //Solução eficiente
        int soma = 0;
        Integer primeiroElementoFila1=null;
        Integer primeiroElementoFila2=null;
        if(fila1.isVazia()&&fila2.isVazia())
            return 0;

        if(!fila1.isVazia()){
            soma++;
            primeiroElementoFila1 = fila1.remover();
            fila1.inserir(primeiroElementoFila1);
        }
        if(!fila2.isVazia()){
            soma++;
            primeiroElementoFila2 = fila2.remover();
            fila2.inserir(primeiroElementoFila2);
        }
            //return contarFila(fila1);
        while(primeiroElementoFila2!=fila2.consultar() || primeiroElementoFila1!=fila1.consultar()){
            if(primeiroElementoFila1!=fila1.consultar()){
                fila1.inserir(fila1.remover());
                soma++;
            }
            if(primeiroElementoFila2!=fila2.consultar()){
                fila2.inserir(fila2.remover());
                soma++;
            }
        }
        return soma;
    }

    /*private static int contarFila(Fila<Integer> fila) {
        int soma = 1;
        Integer primeiroElemento = fila.remover();
        fila.inserir(primeiroElemento);
        while(fila.consultar()!=primeiroElemento){
            fila.inserir(fila.remover());
            soma++;
        }
        return soma;
    }*/

    public static void main(String[] args) {
        Fila<Integer> fila1 = new Fila<>();
        Fila<Integer> fila2 = new Fila<>();
        for (int i = 1; i < 7; i++) {
            fila1.inserir(i);
        }
        for (int i = 7; i < 9; i++) {
            fila2.inserir(i);
        }

        System.out.println("Antes de contar elementos:");
        System.out.println("fila1: " + fila1);
        System.out.println("fila2: " + fila2);

        System.out.println("Numero total de elementos: " + contarElementosFilas(fila1, fila2));

        System.out.println("Depois de contar elementos:");
        System.out.println("fila1: " + fila1);
        System.out.println("fila2: " + fila2);
    }

}
