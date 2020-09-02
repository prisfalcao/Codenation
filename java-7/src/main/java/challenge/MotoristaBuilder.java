package challenge;

import java.util.Objects;

public class MotoristaBuilder {

    private String nome;

    private int idade;

    private int pontos;

    private String habilitacao;

    public MotoristaBuilder withNome(String nome) {
        this.nome = nome;
        return this;
    }

    public MotoristaBuilder withIdade(int idade) {
        if(idade < 0){
            throw new IllegalArgumentException("A idade informada deve ser um número positivo!");
        }
        this.idade = idade;
        return this;
    }

    public MotoristaBuilder withPontos(int pontos) {
        if(pontos < 0){
            throw new IllegalArgumentException("O número de pontos informados deve ser positivo!");
        }
        this.pontos = pontos;
        return this;
    }

    public MotoristaBuilder withHabilitacao(String habilitacao) {
        this.habilitacao = habilitacao;
        return this;
    }

    public Motorista build() {
        Objects.requireNonNull(nome, "O nome do motorista é obrigatório!");
        Objects.requireNonNull(idade, "A idade do motorista é obrigatória!");
        Objects.requireNonNull(pontos, "Os pontos da habilitação do motoristas são obrigatórios!");
        Objects.requireNonNull(habilitacao, "O número da habilitação do motorista é obrigatório!.");
        return new Motorista(nome, idade, pontos, habilitacao);
    }
}
