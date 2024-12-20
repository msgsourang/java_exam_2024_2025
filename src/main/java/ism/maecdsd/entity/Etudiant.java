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


public class Etudiant {
    private int id;
    private String nom;
    private String prenom;
    private Classe classe;

    public Etudiant(int id, String nom) {
        this.id = id;
        this.nom = nom;
    }
}
