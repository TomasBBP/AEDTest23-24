package aed.avaliacao.recurso.modelo;

import aed.avaliacao.recurso.modelo.comparadores.ComparacaoDataDesc;
import aed.colecoes.iteraveis.IteradorIteravelDuplo;
import aed.colecoes.iteraveis.lineares.ordenadas.estruturas.ListaDuplaOrdenada;

public class GestorViagensNumeroPassageiros {
    private int numeroPassageiros;
    private ListaDuplaOrdenada<Viagem> viagens;

    public GestorViagensNumeroPassageiros(int numeroPassageiros){
        this.numeroPassageiros = numeroPassageiros;
        viagens = new ListaDuplaOrdenada<>(ComparacaoDataDesc.CRITERIO);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        GestorViagensNumeroPassageiros that = (GestorViagensNumeroPassageiros) o;

        return numeroPassageiros == that.numeroPassageiros;
    }

    @Override
    public int hashCode() {
        return numeroPassageiros;
    }
    public void inserir(Viagem viagem) {
        viagens.inserir(viagem);
    }

    public IteradorIteravelDuplo<Viagem> getPassageiros() {
        return viagens.iterador();
    }
}
