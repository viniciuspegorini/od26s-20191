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


    @Column(length = 100, nullable = false)
    private String email;

    @ManyToMany(cascade = CascadeType.ALL,
            fetch = FetchType.EAGER)
    private Set<Permissao> permissoes;        
    
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
    
    @NotNull(message = "Opa!! Não esqueça de preencher o campo 'Departamento'.")
    @Column(length = 100, nullable = false)
    private String departamento;

    @ManyToOne
    @JoinColumn(referencedColumnName = "id")
    private Instituicao instituicao;
    
    @NotNull(message = "Opa!! Não esqueça de preencher o campo 'Status'.")
    @Column(length = 100, nullable = false)
    private String status;
        
    @Column(nullable = false, columnDefinition="FLOAT DEFAULT 0")
    private Float saldo;
    
    @Column()
    private Date dtCriacao;
    


    @Column(length = 512, nullable = false)
    private String password;



    @Override
    @JsonIgnore
    public Collection<? extends GrantedAuthority> getAuthorities() {
        List<GrantedAuthority> auto = new ArrayList<>();
        auto.addAll(getPermissoes());

        return auto;
    }

    @com.fasterxml.jackson.annotation.JsonIgnore
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

}
