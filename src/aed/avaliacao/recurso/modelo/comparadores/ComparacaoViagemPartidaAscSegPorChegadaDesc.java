package aed.avaliacao.recurso.modelo.comparadores;

import aed.Comparacao;
import aed.avaliacao.recurso.modelo.Viagem;

public enum ComparacaoViagemPartidaAscSegPorChegadaDesc implements Comparacao<Viagem> {
    CRITERIO;

    @Override
    public int comparar(Viagem o1, Viagem o2) {
        int compPartida = o1.getPartida().compareTo(o2.getPartida());
        return compPartida == 0 ? -o1.getChegada().compareTo(o2.getChegada()) : compPartida;
    }
}
