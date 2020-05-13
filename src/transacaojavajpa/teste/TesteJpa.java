/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package transacaojavajpa.teste;

import java.util.List;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.Query;
import transacaojavajpa.modelos.Conta;
import transacaojavajpa.modelos.Extrato;

/**
 *
 * @author Mateus
 */
public class TesteJpa {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Persistence persistence = new Persistence();
        EntityManagerFactory fabrica = persistence.createEntityManagerFactory("persistencia");
        EntityManager em = fabrica.createEntityManager();

        Conta contaMateus = new Conta("Conta do Mateus", -1000.0);
        Conta contaFelipe = new Conta("Conta do Felipe", 3000.0);
        Conta contaMaria = new Conta("Conta do Felipe", 4000.0);

        Extrato extrato1 = new Extrato("Compra XBOX", 1000.0, Extrato.Operacao.S, contaMateus);
        Extrato extrato2 = new Extrato("Compra Playstation 4", 2000.0, Extrato.Operacao.S, contaMateus);
        Extrato extrato3 = new Extrato("Salario", 1000.0, Extrato.Operacao.E, contaMateus);
        Extrato extrato4 = new Extrato("Compra Controle", 100.0, Extrato.Operacao.S, contaMateus);

        em.getTransaction().begin();

        em.persist(contaMateus);
        em.persist(contaFelipe);
        em.persist(contaMaria);

        em.persist(extrato1);
        em.persist(extrato2);
        em.persist(extrato3);
        em.persist(extrato4);

        em.getTransaction().commit();

        System.out.println("Todas as contas");
        Query query = em.createNamedQuery("Conta.todas");
        query.getResultList().forEach(System.out::println);

        System.out.println("Todas as contas com o saldo maior que zero");
        query = em.createNamedQuery("Conta.saldoMaiorQueZero");
        query.getResultList().forEach(System.out::println);

        System.out.println("Maior saldo");
        query = em.createNamedQuery("Conta.maiorSaldo");
        query.getResultList().forEach(System.out::println);

        System.out.println("Todos os extratos");
        query = em.createNamedQuery("Extrato.todos");
        query.getResultList().forEach(System.out::println);

        System.out.println("Descricao e valor de todos os extratos com data de hoje e do tipo S");
        query = em.createNamedQuery("Extrato.descricaoEValorComDataDeHojeEDoTipoS");
        query.setParameter("tipo", Extrato.Operacao.S).getResultList().forEach(System.out::println);

        System.out.println("Codigo, descricao, valor e descricao da conta de todos os extratos com data de hoje e do tipo S");
        query = em.createNamedQuery("Extrato.codigoDescricaoEDescricaoDaConta");
        query.getResultList().forEach(System.out::println);

        fabrica.close();
    }

}
