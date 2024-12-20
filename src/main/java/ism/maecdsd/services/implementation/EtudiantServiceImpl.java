package ism.maecdsd.services.implementation;

import ism.maecdsd.entity.Classe;
import ism.maecdsd.entity.Etudiant;
import ism.maecdsd.repository.interfaces.ClasseRepository;
import ism.maecdsd.services.interfaces.EtudiantService;

import java.util.ArrayList;
import java.util.List;

public class EtudiantServiceImpl implements EtudiantService {
    private final ClasseRepository classeRepository;
    private final List<Etudiant> etudiants = new ArrayList<>();
    private static int idCounter = 1;

    public EtudiantServiceImpl(ClasseRepository classeRepository) {
        this.classeRepository = classeRepository;
    }

    @Override
    public void ajouterEtudiant(Etudiant etudiant, Classe classe) {
        classe.getEtudiants().add(etudiant);
        etudiant.setClasse(classe);
        etudiants.add(etudiant);
    }

    @Override
    public Classe afficherClasseEtudiant(Etudiant etudiant) {
        return etudiant.getClasse();
    }

    @Override
    public List<Etudiant> listerEtudiants() {
        return etudiants;
    }

    @Override
    public int generateId() {
        return idCounter++;
    }
}
