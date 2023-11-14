package poo.dao;
//DAO -> data access objetive, vai fazer a transação?

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import poo.model.Pessoa;

public class PessoaDAO {

    private static final SessionFactory sessionFactory;

    static {
        try {
            // Configurando a sessão do Hibernate a partir do arquivo hibernate.cfg.xml
            Configuration configuration = new Configuration().configure();
            sessionFactory = configuration.buildSessionFactory();
        } catch (Throwable ex) {
            throw new ExceptionInInitializerError(ex);
        }
    }

    public void close() {
        sessionFactory.close();
    }

    public void salvarPessoa(Pessoa pessoa) {
        Transaction transaction = null;

        try {

            Session session = sessionFactory.openSession();
            transaction = session.beginTransaction(); // ta começando a fazer a transação como salvar apagar ou alterar
                                                      // dadods no BD
            session.save(pessoa);// Ta mandando salvar o registro de pessoa
            transaction.commit();// está dando o commit
        } catch (Exception e) {
            if (transaction != null) { // caso tenha parado é porque deu ruim
                transaction.rollback(); // Ele volta a transação e não confirma
            }
            e.printStackTrace();
            // TODO: handle exception
        }
    }

    public Pessoa getPessoaById(Long id) {
        Pessoa p = null;
        try (Session session = sessionFactory.openSession()) { // se der erro é só passar o () do try pra dentro da classe

            p = session.get(Pessoa.class, id);

        }
        catch (Exception e){
            e.printStackTrace();
        }
        return p;
    }


    public void atualizarPessoa(Pessoa pessoa) {
        Transaction transaction = null;
        try (Session session = sessionFactory.openSession()) {
            transaction = session.beginTransaction();
            session.update(pessoa);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }


    public void deletarPessoa(Pessoa pessoa) {
        Transaction transaction = null;
        try (Session session = sessionFactory.openSession()) {
            transaction = session.beginTransaction();
            session.delete(pessoa);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

}
