package br.edu.utfpr.chemistsincontrol.model;

import org.hibernate.validator.constraints.CodePointLength;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class Usuario extends AbstractModel {
    @Column(nullable = false, unique = true)
    private String email;
    @Column(nullable = false)
    private String senha;


}
