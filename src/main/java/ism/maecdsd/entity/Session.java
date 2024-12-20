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

public class Session {
    private int id;
    private Cours cours;
    private String date;
    private String heureDebut;
    private String heureFin;
    private String salle;

}