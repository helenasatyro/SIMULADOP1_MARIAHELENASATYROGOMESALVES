package dog;

public class DogHost {
    private final int maxDogs;
    private final int maxRacao;
    private final String nomeHost;
    private final Dog[] dogs;
    private int quantDogs;
    private int racaoDiaria;
    private int proxIndice;

    public DogHost(int maxDogs, int maxRacao, String nomeHost) {
        this.maxDogs = maxDogs;
        dogs = new Dog[maxDogs];
        this.maxRacao = maxRacao;
        this.nomeHost = nomeHost;
        this.racaoDiaria = 0;
        this.quantDogs = 0;
        proxIndice = 0;
    }

    public boolean adicionaDog(String nome, String tutor, int qtdRacao, String tipoRestricao) {
        String rest;
        int r;
        if (tipoRestricao != "") {
            r = 2;
            rest = tipoRestricao;
        } else {
            r = 1;
            rest = "";
        }
        if (quantDogs + 1 <= maxDogs && r * qtdRacao + racaoDiaria <= maxRacao) {
            quantDogs++;
            racaoDiaria += qtdRacao * r;
            dogs[proxIndice] = new Dog(nome, tutor, qtdRacao, rest);
            proxIndice++;
            return true;
        }
        return false;
    }

    public boolean adicionaDog(String nome, String tutor, int qtdRacao) {
        return this.adicionaDog(nome, tutor, qtdRacao, "");
    }

    String listaDogs() {
        String retorno = nomeHost + ":\n";

        for (int i = 0; i < maxDogs; i++ ) {
            if (dogs[i] != null) {
                retorno += dogs[i].toString() + "\n";
            }
        }
        return retorno;
    }

    public double consultaValorHospedagem(Dog toto, int dias) {

        for (int i = 0; i < maxDogs; i++ ) {
            if (dogs[i] != null && dogs[i].equals(toto)) {
                double custoRacao = 0.4 * toto.getRacao();
                return custoRacao * dias;
            }
        }
        throw new IllegalArgumentException("IllegalArgumentException");
    }

    int consultaRacaoTotal() {
        return this.racaoDiaria;
    }

    double consultaHospedagens() {
        double retorno = 0;
        for (int i = 0; i < maxDogs; i++ ) {
            if (dogs[i] != null) {
                retorno += dogs[i].getRacao() * 0.4;
            }
        }
        return retorno;
    }
}
