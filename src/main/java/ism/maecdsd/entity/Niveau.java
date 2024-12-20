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

public class Niveau {
    private int id;
    private String nom;

    public Niveau(int id, String nom) {
        this.id = id;
        this.nom = nom;
    }

}
