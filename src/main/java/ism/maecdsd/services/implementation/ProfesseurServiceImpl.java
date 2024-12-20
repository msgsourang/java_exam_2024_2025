package ism.maecdsd.services.implementation;

import ism.maecdsd.entity.Professeur;
import ism.maecdsd.services.interfaces.ProfesseurService;

import java.util.ArrayList;
import java.util.List;

public class ProfesseurServiceImpl implements ProfesseurService {
    private final List<Professeur> professeurs = new ArrayList<>();
    private static int idCounter = 1;

    @Override
    public void ajouterProfesseur(Professeur professeur) {
        professeurs.add(professeur);
    }

    @Override
    public List<Professeur> listerProfesseurs() {
        return professeurs;
    }

    @Override
    public int generateId() {
        return idCounter++;
    }
}
