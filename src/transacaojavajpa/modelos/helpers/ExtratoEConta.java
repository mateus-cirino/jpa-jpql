/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package transacaojavajpa.modelos.helpers;

/**
 *
 * @author mateu
 */
public class ExtratoEConta {

    private String descricaoConta;
    private int codigoExtrato;
    private String descricaoExtrato;
    private Double valorExtrato;

    public ExtratoEConta(int codigoExtrato, String descricaoExtrato, Double valorExtrato, String descricaoConta) {
        this.codigoExtrato = codigoExtrato;
        this.descricaoExtrato = descricaoExtrato;
        this.valorExtrato = valorExtrato;
        this.descricaoConta = descricaoConta;
    }

    @Override
    public String toString() {
        return "ExtratoEConta{" + "descricaoConta=" + descricaoConta + ", codigoExtrato=" + codigoExtrato + ", descricaoExtrato=" + descricaoExtrato + ", valorExtrato=" + valorExtrato + '}';
    }

}
