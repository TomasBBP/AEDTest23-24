package aed.avaliacao.recurso.modelo.comparadores;

import aed.Comparacao;

public enum ComparacaoNumeroPassageirosAsc implements Comparacao<Integer> {
    CRITERIO;

    @Override
    public int comparar(Integer o1, Integer o2) {
        return o1.compareTo(o2);
    }
}
