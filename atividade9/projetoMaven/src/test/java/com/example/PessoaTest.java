package com.example;

import org.junit.Test;// Serve para usar a marcação @Test para informar que é um mmétodo de teste
import static org.junit.Assert.assertEquals; // serve paa verificar se o valor esperado na resposta é igual ao do teste (?)

public class PessoaTest {
    @Test
    public void TestedizerOla(){
        Pessoa pessoa = new Pessoa();
        String cumprimento = pessoa.dizerOla();
        assertEquals("Olá, mundo!", cumprimento);
    }
    
}
