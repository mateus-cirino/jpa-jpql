/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package transacaojavajpa.modelos;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

/**
 *
 * @author Mateus
 */
@Entity
@NamedQueries({
    @NamedQuery(name = "Conta.todas",
            query = "SELECT c FROM Conta c")
    ,
    @NamedQuery(name = "Conta.saldoMaiorQueZero",
            query = "SELECT c FROM Conta c WHERE c.saldo > 0"),
    @NamedQuery(name = "Conta.maiorSaldo",
            query = "SELECT MAX(c.saldo) FROM Conta c"),})
public class Conta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String descricao;
    private Double saldo;
    public Conta() {
        
    }
    public Conta(String descricao, Double saldo) {
        this.descricao = descricao;
        this.saldo = saldo;
    }
    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @return the descricao
     */
    public String getDescricao() {
        return descricao;
    }

    /**
     * @return the saldo
     */
    public Double getSaldo() {
        return saldo;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @param descricao the descricao to set
     */
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    /**
     * @param saldo the saldo to set
     */
    public void setSaldo(Double saldo) {
        if (saldo < 0) {
            throw new RuntimeException("saldo inválido");
        }
        this.saldo = saldo;
    }

    @Override
    public String toString() {
        return "codigo: " + this.id + " descricao: " + this.descricao + " saldo: " + this.saldo;
    }
}
