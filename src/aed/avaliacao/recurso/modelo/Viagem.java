package aed.avaliacao.recurso.modelo;

import java.io.Serializable;
import java.util.Objects;

public class Viagem implements Serializable {
    private static final long serialVersionUID = 1L;

    private final String partida;
    private final String chegada;
    private final Data data;
    private final int numeroPassageiros;

    public Viagem(String partida, String chegada, Data data, int numeroPassageiros) {
        this.partida = partida;
        this.chegada = chegada;
        this.data = data;
        this.numeroPassageiros = numeroPassageiros;
    }

    public String getPartida() {
        return partida;
    }

    public String getChegada() {
        return chegada;
    }

    public Data getData() {
        return data;
    }

    public int getNumeroPassageiros() {
        return numeroPassageiros;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Viagem viagem = (Viagem) o;

        return numeroPassageiros == viagem.numeroPassageiros &&
                Objects.equals(partida, viagem.partida) &&
                Objects.equals(chegada, viagem.chegada) &&
                Objects.equals(data, viagem.data);
    }

    @Override
    public int hashCode() {
        return Objects.hash(partida, chegada, data, numeroPassageiros);
    }

    @Override
    public String toString() {
        return partida + "\t" + chegada + "\t" + data + "\tNP: " + numeroPassageiros;
    }
}
