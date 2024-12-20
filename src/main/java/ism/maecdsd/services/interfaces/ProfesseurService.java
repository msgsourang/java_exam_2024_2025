package ism.maecdsd.services.interfaces;

import ism.maecdsd.entity.Professeur;

import java.util.List;

public interface ProfesseurService {
    void ajouterProfesseur(Professeur professeur);
    List<Professeur> listerProfesseurs();
    int generateId();
}
