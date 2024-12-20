package ism.maecdsd.repository.implementation;

import ism.maecdsd.entity.Cours;
import ism.maecdsd.entity.Classe;
import ism.maecdsd.entity.Professeur;
import ism.maecdsd.repository.interfaces.CoursRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class CoursRepositoryImpl implements CoursRepository {
    private final List<Cours> list; 

    public CoursRepositoryImpl(List<Cours> list) {
        this.list = list;
    }

    @Override
    public List<Cours> lister() {
        return findAll(); 
    }

    @Override
    public void insert(Cours cours) {
        list.add(cours);
    }

    @Override
    public List<Cours> findAll() {
        return new ArrayList<>(list); 
    }

    @Override
    public List<Cours> getCoursByClasse(Classe classe) {
        return list.stream()
            .filter(cours -> cours.getClasses().contains(classe))
            .collect(Collectors.toList());
    }

    @Override
    public List<Cours> getCoursByProfesseur(Professeur professeur) {
        return list.stream()
            .filter(cours -> cours.getProfesseur().equals(professeur))
            .collect(Collectors.toList());
    }
}
