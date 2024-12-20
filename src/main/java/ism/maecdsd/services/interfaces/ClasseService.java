package ism.maecdsd.services.interfaces;

import java.util.List;

import ism.maecdsd.entity.Classe;
import ism.maecdsd.entity.Etudiant;

public interface ClasseService {
    void inscrireEtudiant(Etudiant etudiant, Classe classe);
    Classe afficherClasseEtudiant(Etudiant etudiant);
    int generateId();
    void ajouterClasse(Classe classe);
    List<Classe> listerClasses();
}
