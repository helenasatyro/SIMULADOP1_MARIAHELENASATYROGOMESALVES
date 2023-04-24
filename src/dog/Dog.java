package dog;

import java.util.Objects;

public class Dog {
    private String nome;
    private String tutor;
    private int racao;
    private String restricao;

    public Dog(String nome, String tutor, int racao, String restricao ) {
        this.nome = nome;
        this.tutor = tutor;
        this.racao = racao;
        this.restricao = restricao;
    }

    public Dog(String nome, String tutor, int racao ) {
        this(nome, tutor, racao, null);
    }

    public int getRacao() {
        return racao;
    }

    @Override
    public String toString(){
        return "dog.Dog [nome=" + nome + ", tutor=" + tutor + "]";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Dog dog = (Dog) o;
        return nome.equals(dog.nome) && tutor.equals(dog.tutor);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nome, tutor);
    }
}
