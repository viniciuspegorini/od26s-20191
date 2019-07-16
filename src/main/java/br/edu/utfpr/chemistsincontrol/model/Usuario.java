package br.edu.utfpr.chemistsincontrol.model;


import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.persistence.*;

import javax.validation.constraints.NotNull;

import java.util.*;

@Entity
@Data
@Table(name = "usuario")
@AllArgsConstructor
@NoArgsConstructor
public class Usuario implements UserDetails {
    private static final long serialVersionUID = 1L;
    private static final BCryptPasswordEncoder bCrypt =
            new BCryptPasswordEncoder(10);

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "Opa!! Não esqueça de preencher o campo 'Nome'.")
    @Column(length = 100, nullable = false)
    private String nome;

    @NotNull(message = "Não esqueça de preencher o campo 'CPF'.")
    @Column(length = 14, nullable = false)
    private String cpfCnpj;

    @NotNull(message = "Opa!! Não esqueça de preencher o campo 'RG'.")
    @Column(length = 100, nullable = false)
    private String rg;

    @NotNull(message = "Opa!! Não esqueça de preencher o campo 'Telefone'.")
    @Column(length = 100, nullable = false)
    private String telefone;

    @NotNull(message = "Opa!! Não esqueça de preencher o campo 'Celular'.")
    @Column(length = 100, nullable = false)
    private String celular;

    @NotNull(message = "Opa!! Não esqueça de preencher o campo 'Tipo Pessoa'.")
    @Column(length = 100, nullable = false)
    private String tipoPessoa;


    @Column(length = 100)
    private String departamento;

    @NotNull(message = "Opa!! Não esqueça de preencher o campo 'Status'.")
    @Column(length = 100, nullable = false)
    private String status;

    @Column(length = 100, nullable = false)
    private String email;

    @Column(columnDefinition="FLOAT DEFAULT 0")
    private Float saldo;


    private Date dtCriacao;

    @Column(length = 512, nullable = false)
    private String password;


    @Column(nullable = false)
    private String endereco;


    @Column(length = 100, nullable = false)
    private String cidade;

    @Column(length = 30, nullable = false)
    private String uf;

    @Column(length = 20)
    private String cep;

    @ManyToOne
    @JoinColumn(referencedColumnName = "id")
    private Instituicao instituicao;

    @OneToOne
    @JoinColumn(referencedColumnName = "id")
    private Usuario orientador;

    @Enumerated(EnumType.STRING)
    @Column(nullable = true)
    private SituacaoCadastro situacaoCadastro;

    @Override
    @JsonIgnore
    public Collection<? extends GrantedAuthority> getAuthorities() {
        List<GrantedAuthority> auto = new ArrayList<>();
        auto.addAll(getPermissoes());

        return auto;
    }

    @ManyToMany(cascade = CascadeType.ALL,
            fetch = FetchType.EAGER)
    private Set<Permissao> permissoes;


    // @com.fasterxml.jackson.annotation.JsonIgnore
    public Set<Permissao> getPermissoes() {
        return permissoes;
    }


    public void addPermissao(Permissao permissao) {
        if (permissoes == null) {
            permissoes = new HashSet<>();
        }
        permissoes.add(permissao);
    }

    public String getEncodedPassword(String pass) {
        if (pass != null && !pass.equals("")) {
            return bCrypt.encode(pass);
        }
        return pass;
    }

    @Override
    public String getPassword() {
        return this.password;
    }



    @Override
    public String getUsername() {
        return this.email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public static BCryptPasswordEncoder getbCrypt() {
        return bCrypt;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpfCnpj() {
        return cpfCnpj;
    }

    public void setCpfCnpj(String cpfCnpj) {
        this.cpfCnpj = cpfCnpj;
    }

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public String getTipoPessoa() {
        return tipoPessoa;
    }

    public void setTipoPessoa(String tipoPessoa) {
        this.tipoPessoa = tipoPessoa;
    }

    public String getDepartamento() {
        return departamento;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Float getSaldo() {
        return saldo;
    }

    public void setSaldo(Float saldo) {
        this.saldo = saldo;
    }

    public Date getDtCriacao() {
        return dtCriacao;
    }

    public void setDtCriacao(Date dtCriacao) {
        this.dtCriacao = dtCriacao;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getUf() {
        return uf;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public Instituicao getInstituicao() {
        return instituicao;
    }

    public void setInstituicao(Instituicao instituicao) {
        this.instituicao = instituicao;
    }

    public Usuario getOrientador() {
        return orientador;
    }

    public void setOrientador(Usuario orientador) {
        this.orientador = orientador;
    }

    public SituacaoCadastro getSituacaoCadastro() {
        return situacaoCadastro;
    }

    public void setSituacaoCadastro(SituacaoCadastro situacaoCadastro) {
        this.situacaoCadastro = situacaoCadastro;
    }

    public void setPermissoes(Set<Permissao> permissoes) {
        this.permissoes = permissoes;
    }
}
