package com.example.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "roles")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Role implements Serializable{

    public static final long serialVersionUID = 2016414618237L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String denomination;

    private int legalLevel;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDenomination() {
        return denomination;
    }

    public void setDenomination(String denomination) {
        this.denomination = denomination;
    }

    public int getLegalLevel() {
        return legalLevel;
    }

    public void setLegalLevel(int legalLevel) {
        this.legalLevel = legalLevel;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Role role = (Role) o;

        if (legalLevel != role.legalLevel) return false;
        if (!id.equals(role.id)) return false;
        return denomination.equals(role.denomination);

    }

    @Override
    public int hashCode() {
        int result = id.hashCode();
        result = 31 * result + denomination.hashCode();
        result = 31 * result + legalLevel;
        return result;
    }

    @Override
    public String toString() {
        return "Role{" +
                "id=" + id +
                ", denomination='" + denomination + '\'' +
                ", legalLevel=" + legalLevel +
                '}';
    }
}
