package ism.maecdsd.entity;

import java.util.ArrayList;
import java.util.List;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Data
@NoArgsConstructor
@Getter
@Setter
@ToString
@EqualsAndHashCode


public class Classe {
    private int id;
    private String nom;
    private Niveau niveau;
    private List<Etudiant> etudiants = new ArrayList<>();

    public Classe(int id, String nom, Niveau niveau) {
        this.id = id;
        this.nom = nom;
        this.niveau = niveau;
    }

    public Classe(int id, String nom) {
        this.id = id;
        this.nom = nom;
    }
}
