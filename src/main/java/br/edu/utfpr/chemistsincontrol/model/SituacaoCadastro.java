package br.edu.utfpr.chemistsincontrol.model;

public enum SituacaoCadastro {
    A("Aprovado"),
    R("Reprovado"),
    P("Pendente");

    private  String valorSituacaoCadastro;

    SituacaoCadastro(String valorSituacaoCadastro) {
        this.valorSituacaoCadastro = valorSituacaoCadastro;
    }

    public String getValorSituacaoCadastro() {
        return valorSituacaoCadastro;
    }


}
