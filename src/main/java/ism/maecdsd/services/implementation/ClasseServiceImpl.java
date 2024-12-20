package ism.maecdsd.services.implementation;

import java.util.List;

import ism.maecdsd.entity.Classe;
import ism.maecdsd.entity.Etudiant;
import ism.maecdsd.repository.interfaces.ClasseRepository;
import ism.maecdsd.services.interfaces.ClasseService;

public class ClasseServiceImpl implements ClasseService {
    private final ClasseRepository classeRepository;
    private static int idCounter = 1;

    public ClasseServiceImpl(ClasseRepository classeRepository) {
        this.classeRepository = classeRepository;
    }

    @Override
    public void inscrireEtudiant(Etudiant etudiant, Classe classe) {
        classe.getEtudiants().add(etudiant);
        etudiant.setClasse(classe);
    }
     @Override
    public void ajouterClasse(Classe classe) {
        classeRepository.insert(classe); 
    }

    @Override
    public List<Classe> listerClasses() {
        return classeRepository.findAll(); 
    }

    @Override
    public Classe afficherClasseEtudiant(Etudiant etudiant) {
        return etudiant.getClasse();
    }

    

    @Override
    public int generateId() {
        return idCounter++;
    }
}
