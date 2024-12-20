package ism.maecdsd.services.implementation;

import ism.maecdsd.entity.Cours;
import ism.maecdsd.entity.Niveau;
import ism.maecdsd.entity.Classe;
import ism.maecdsd.entity.Professeur;
import ism.maecdsd.repository.interfaces.CoursRepository;
import ism.maecdsd.services.interfaces.CoursService;

import java.util.List;
import java.util.stream.Collectors;

public class CoursServiceImpl implements CoursService {
    private final CoursRepository coursRepository;
    private int currentId = 1;
    private static int idCounter = 1;

    public CoursServiceImpl(CoursRepository coursRepository) {
        this.coursRepository = coursRepository;
    }

    @Override
    public void ajouterCours(Cours cours) {
        coursRepository.insert(cours);
    }

    @Override
    public List<Cours> afficherCoursClasse(Classe classe) {
        return coursRepository.getCoursByClasse(classe);
    }

    
    @Override
    public List<Cours> afficherCoursProfesseur(Professeur professeur) {
        return coursRepository.getCoursByProfesseur(professeur);
    }
    public int generateId() {
        return currentId++;
    }
    @Override
    public void afficherCours(List<Cours> coursList) {
        if (coursList.isEmpty()) {
            System.out.println("Aucun cours trouvé.");
        } else {
            coursList.forEach(cours -> System.out.println(cours.toString()));
        }
    }

      @Override
    public List<Cours> afficherCoursNiveau(Niveau niveau) {
        return coursRepository.findAll().stream()
                .filter(cours -> cours.getClasses().stream()
                        .anyMatch(classe -> classe.getNiveau().equals(niveau)))
                .collect(Collectors.toList());
    }
}
