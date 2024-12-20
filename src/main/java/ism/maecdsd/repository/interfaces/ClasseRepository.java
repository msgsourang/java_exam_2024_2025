package ism.maecdsd.repository.interfaces;

import ism.maecdsd.entity.Classe;
import ism.maecdsd.entity.Etudiant;
import ism.maecdsd.repository.Repository;

import java.util.List;

public interface ClasseRepository extends Repository<Classe> {
    Classe getClasseParId(int id);
    List<Etudiant> getEtudiantsParClasse(Classe classe);
    void insert(Classe classe);      
    List<Classe> findAll();
}
