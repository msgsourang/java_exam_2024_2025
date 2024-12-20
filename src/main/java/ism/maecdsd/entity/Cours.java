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

public class Cours {
    private int id;
    private Professeur professeur;
    private List<Classe> classes = new ArrayList<>();
    private String module;

    public Cours(int id, Professeur professeur, List<Classe> classes, String module) {
        this.id = id;
        this.professeur = professeur;
        this.classes = classes;
        this.module = module;
    }

}