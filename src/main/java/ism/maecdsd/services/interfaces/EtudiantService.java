package ism.maecdsd.services.interfaces;

import ism.maecdsd.entity.Etudiant;
import ism.maecdsd.entity.Classe;

import java.util.List;

public interface EtudiantService {
    void ajouterEtudiant(Etudiant etudiant, Classe classe);
    Classe afficherClasseEtudiant(Etudiant etudiant);
    List<Etudiant> listerEtudiants();
    int generateId();
}
