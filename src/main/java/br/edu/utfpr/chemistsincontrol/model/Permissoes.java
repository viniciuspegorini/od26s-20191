package br.edu.utfpr.chemistsincontrol.model;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class Permissoes extends AbstractModel {

    @Column( nullable = false )
    private String roleName;

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }
}
