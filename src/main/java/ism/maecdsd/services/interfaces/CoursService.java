package ism.maecdsd.services.interfaces;

import ism.maecdsd.entity.Cours;
import ism.maecdsd.entity.Niveau;
import ism.maecdsd.entity.Classe;
import ism.maecdsd.entity.Professeur;
import java.util.List;

public interface CoursService {
    void ajouterCours(Cours cours);
    List<Cours> afficherCoursClasse(Classe classe);
    List<Cours> afficherCoursProfesseur(Professeur professeur);
    int generateId(); 
    void afficherCours(List<Cours> coursList);
    List<Cours> afficherCoursNiveau(Niveau niveau);
}
