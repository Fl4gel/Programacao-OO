package poo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity // Informando que a classe é uma entidade, e se não existir uma tabela pessoa ela será criada com os atributos abaixo
public class Pessoa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //id vai ser gerado automaticamente, hibernate faz isso
    private Long id;

    private String nome;

    private String Email;

    public Pessoa() {
    }

    public Pessoa(Long id, String nome, String Email) {
        this.id = id;
        this.nome = nome;
        this.Email = Email;
    }

    public Pessoa(String nome, String Email) {
        this.nome = nome;
        this.Email = Email;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return this.Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

}
