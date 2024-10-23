package aed.avaliacao.recurso.modelo.comparadores;

import aed.Comparacao;
import aed.avaliacao.recurso.modelo.Viagem;

public enum ComparacaoDataDesc implements Comparacao<Viagem> {
    CRITERIO;

    @Override
    public int comparar(Viagem o1, Viagem o2) {
        return -o1.getData().compareTo(o2.getData());
    }
}
