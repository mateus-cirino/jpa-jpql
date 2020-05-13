/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package transacaojavajpa.modelos;

import java.text.SimpleDateFormat;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
/**
 *
 * @author Mateus
 */
@Entity
@NamedQueries({
    @NamedQuery(name = "Extrato.todos",
            query = "SELECT e FROM Extrato e")
    ,
    @NamedQuery(name = "Extrato.descricaoEValorComDataDeHojeEDoTipoS",
            query = "SELECT e.descricao, e.valor FROM Extrato e WHERE e.tipo = :tipo AND e.data = CURRENT_DATE")
    ,
    @NamedQuery(name = "Extrato.codigoDescricaoEDescricaoDaConta",
            query = "SELECT NEW transacaojavajpa.modelos.helpers.ExtratoEConta(e.id as codigoExtrato, e.descricao as descricaoExtrato, e.valor as valorExtrato, c.descricao as descricaoConta) FROM Extrato e, Conta c WHERE e.Conta.id = c.id"),})
public class Extrato {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String descricao;
    private Double valor;

    public enum Operacao {
        E("Entrada"),
        S("Saída");

        private String descricao;

        Operacao(String descricao) {
            this.descricao = descricao;
        }

        public String getDescricao() {
            return descricao;
        }
    }
    private Operacao tipo;
    @ManyToOne
    private Conta Conta;
    private String data = new SimpleDateFormat("yyyy-MM-dd").format(new Date());

    public Extrato() {

    }

    public Extrato(String descricao, Double valor, Operacao tipo, Conta Conta) {
        this.descricao = descricao;
        this.valor = valor;
        this.tipo = tipo;
        this.Conta = Conta;
    }

    public Integer getId() {
        return this.id;
    }

    public String getDescricao() {
        return this.descricao;
    }

    public Double getValor() {
        return this.valor;
    }

    public Operacao getTipo() {
        return this.tipo;
    }

    public Conta getidConta() {
        return this.Conta;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public void setTipo(Operacao tipo) {
        this.tipo = tipo;
    }

    public void setidConta(Conta Conta) {
        this.Conta = Conta;
    }

    @Override
    public String toString() {
        return "Extrato{" + "id=" + id + ", descricao=" + descricao + ", valor=" + valor + ", tipo=" + tipo + ", Conta=" + Conta + ", data=" + data + '}';
    }

}
