package ism.maecdsd.repository.interfaces;

import java.util.List;

import ism.maecdsd.entity.Classe;
import ism.maecdsd.entity.Cours;
import ism.maecdsd.entity.Professeur;
import ism.maecdsd.repository.Repository;

public interface CoursRepository extends Repository<Cours> {
    List<Cours> getCoursByClasse(Classe classe);
    List<Cours> getCoursByProfesseur(Professeur professeur);
    void insert(Cours cours);       
    List<Cours> findAll(); 
}
