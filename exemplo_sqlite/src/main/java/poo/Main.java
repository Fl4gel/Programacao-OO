package poo;

import javax.swing.plaf.synth.SynthSpinnerUI;

import poo.dao.PessoaDAO;
import poo.model.Pessoa;

public class Main {
    
    public static void main(String[] args) {

        
        PessoaDAO dao = new PessoaDAO();

        Pessoa pessoa = dao.getPessoaById((long) 1);

        dao.deletarPessoa(pessoa);

    }
}
