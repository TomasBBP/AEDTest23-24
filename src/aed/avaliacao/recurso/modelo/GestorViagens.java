package aed.avaliacao.recurso.modelo;

import aed.avaliacao.recurso.modelo.comparadores.ComparacaoNumeroPassageirosAsc;
import aed.avaliacao.recurso.modelo.comparadores.ComparacaoViagemPartidaAscSegPorChegadaDesc;
import aed.colecoes.iteraveis.IteradorIteravelDuplo;
import aed.colecoes.iteraveis.associativas.estruturas.TabelaHashOrdenada;
import aed.colecoes.iteraveis.lineares.naoordenadas.estruturas.ListaDuplaNaoOrdenada;
import aed.colecoes.iteraveis.lineares.ordenadas.estruturas.ListaDuplaOrdenada;

public enum GestorViagens {
    INSTANCIA;
    private static final IteradorIteravelDuplo<Viagem> ITERADOR_DUPLO_VAZIO_VIAGENS = new ListaDuplaNaoOrdenada<Viagem>().iterador();
    private int mediaPassageiros = 0;
    private ListaDuplaOrdenada<Viagem> listaViagens;
    private TabelaHashOrdenada<Integer, GestorViagensNumeroPassageiros> tabelaViagensPorNumeroPassageiros;
    GestorViagens() {
        listaViagens = new ListaDuplaOrdenada<>(ComparacaoViagemPartidaAscSegPorChegadaDesc.CRITERIO);
        tabelaViagensPorNumeroPassageiros = new TabelaHashOrdenada<>(ComparacaoNumeroPassageirosAsc.CRITERIO,5);
    }

    public IteradorIteravelDuplo<Viagem> getViagens() {
        //todo pergunta 3.a)
        return listaViagens.iterador();
    }

    public IteradorIteravelDuplo<Viagem> getViagens(int numeroPassageiros) {
        //todo pergunta 3.b)
        GestorViagensNumeroPassageiros gestorViagensNumeroPassageiros = tabelaViagensPorNumeroPassageiros.consultar(numeroPassageiros);
        if(gestorViagensNumeroPassageiros != null){
            return gestorViagensNumeroPassageiros.getPassageiros();
        }
        return null;
    }

    public IteradorIteravelDuplo<Viagem> getViagensAteLimitePassageiros(int limitePassageiros) {
        //todo pergunta 3.c)
        return new Iterador(limitePassageiros);
    }

    public IteradorIteravelDuplo<Viagem> getViagensNumeroPassageirosMenorOuIgualMedia() {
        //todo pergunta 3.d)
        return new Iterador(mediaPassageiros);
    }

    public void inserir(Viagem viagem) {
        //todo pergunta 3.e)
        //fazer media;
        listaViagens.inserir(viagem);
        int numeroPassageiros = viagem.getNumeroPassageiros();
        GestorViagensNumeroPassageiros gestorViagensNumeroPassageiros = tabelaViagensPorNumeroPassageiros.consultar(numeroPassageiros);
        if(gestorViagensNumeroPassageiros == null){
            gestorViagensNumeroPassageiros = new GestorViagensNumeroPassageiros(numeroPassageiros);
            tabelaViagensPorNumeroPassageiros.inserir(numeroPassageiros,gestorViagensNumeroPassageiros);
        }
        gestorViagensNumeroPassageiros.inserir(viagem);
        int numeroElementos = listaViagens.getNumeroElementos();
        mediaPassageiros = (mediaPassageiros*(numeroElementos-1) + viagem.getNumeroPassageiros()) / numeroElementos;
        }

    private class Iterador implements IteradorIteravelDuplo<Viagem> {
        //pode avancar entre 0 e limite
        private IteradorIteravelDuplo<GestorViagensNumeroPassageiros> iteradorGestorViagensNumeroPassageiros;
        private IteradorIteravelDuplo<Viagem> iteradorViagens;
        public Iterador(int limitePassageiros) {
            iteradorGestorViagensNumeroPassageiros = tabelaViagensPorNumeroPassageiros.consultarValores(0,limitePassageiros);
            reiniciar();
        }

        @Override
        public void reiniciar() {
            iteradorGestorViagensNumeroPassageiros.reiniciar();
            iteradorViagens = ITERADOR_DUPLO_VAZIO_VIAGENS;
        }

        @Override
        public Viagem corrente() {
            return iteradorViagens.corrente();
        }

        @Override
        public boolean podeAvancar() {
            return iteradorViagens.podeAvancar() || iteradorGestorViagensNumeroPassageiros.podeAvancar();
        }

        @Override
        public Viagem avancar() {
            if(!iteradorViagens.podeAvancar()){
                iteradorViagens = iteradorGestorViagensNumeroPassageiros.avancar().getPassageiros();
            }
            return iteradorViagens.avancar();
        }

        @Override
        public boolean podeRecuar() {
            return iteradorViagens.podeRecuar() || iteradorGestorViagensNumeroPassageiros.podeRecuar();
        }

        @Override
        public Viagem recuar() {
            if(!iteradorViagens.podeRecuar()){
                iteradorViagens = iteradorGestorViagensNumeroPassageiros.recuar().getPassageiros();
            }
            return iteradorViagens.recuar();        }
    }
}
