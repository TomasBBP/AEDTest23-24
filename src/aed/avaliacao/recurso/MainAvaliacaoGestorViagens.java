package aed.avaliacao.recurso;

import aed.avaliacao.recurso.modelo.Data;
import aed.avaliacao.recurso.modelo.GestorViagens;
import aed.avaliacao.recurso.modelo.Viagem;

public class MainAvaliacaoGestorViagens {
    public static void main(String[] args) {
        Viagem[] viagens = {
                new Viagem("Porto", "Aveiro", new Data(28, 11, 2022), 4),
                new Viagem("Coimbra", "Porto", new Data(12, 6, 2023), 12),
                new Viagem("Leiria", "Lisboa", new Data(16, 11, 2022), 5),
                new Viagem("Nazaré", "Leiria", new Data(17, 3, 2023), 12),
                new Viagem("Leiria", "Braga", new Data(23, 10, 2021), 10)
        };

        for (Viagem viagem : viagens) {
            GestorViagens.INSTANCIA.inserir(viagem);
        }

        System.out.println("\nTodas as viagens ordenadas por partida ascendente seguido por chegada descendente:");
        for (Viagem viagem : GestorViagens.INSTANCIA.getViagens()) {
            System.out.println(viagem);
        }

        System.out.println("\nViagens com número de passageiros igual a 12 ordenadas por data da mais recente para a mais antiga:");
        for (Viagem viagem : GestorViagens.INSTANCIA.getViagens(12)) {
            System.out.println(viagem);
        }

        System.out.println("\nViagens com número de passageiros menor ou igual a 10:");
        for (Viagem viagem : GestorViagens.INSTANCIA.getViagensAteLimitePassageiros(10)) {
            System.out.println(viagem);
        }

        System.out.println("\nViagens com número de passageiros inferior à média de passageiros:");
        for (Viagem viagem : GestorViagens.INSTANCIA.getViagensNumeroPassageirosMenorOuIgualMedia()) {
            System.out.println(viagem);
        }
    }
}
