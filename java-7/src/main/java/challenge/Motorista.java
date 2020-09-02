package challenge;

public class Motorista {

    private String nome;

    private int idade;

    private int pontos;

    private String habilitacao;

    public Motorista(String nome, int idade, int pontos, String habilitacao) {
        this.nome = nome;
        this.idade = idade;
        this.pontos = pontos;
        this.habilitacao = habilitacao;
    }

    public String getNome() {
        return nome;
    }

    public int getIdade() {
        return idade;
    }

    public int getPontos() {
        return pontos;
    }

    public String getHabilitacao() {
        return habilitacao;
    }

    public static MotoristaBuilder builder() {
        return new MotoristaBuilder();
    }
}
