package ism.maecdsd.repository.implementation;

import ism.maecdsd.entity.Classe;
import ism.maecdsd.entity.Etudiant;
import ism.maecdsd.repository.interfaces.ClasseRepository;
import java.util.ArrayList;
import java.util.List;

public class ClasseRepositoryImpl implements ClasseRepository {
    private List<Classe> list = new ArrayList<>();
    private final List<Classe> classes;

    public ClasseRepositoryImpl() {
        this.classes = new ArrayList<>(); 
    }

    public ClasseRepositoryImpl(List<Classe> classes) {
        this.classes = classes;
    }

    @Override
    public void insert(Classe classe) {
        list.add(classe);
    }

    @Override
    public List<Classe> lister() {
        return list;
    }

    @Override
    public Classe getClasseParId(int id) {
        return list.stream()
            .filter(classe -> classe.getId() == id)
            .findFirst()
            .orElse(null);
    }

    @Override
    public List<Classe> findAll() {
        return new ArrayList<>(classes); 
    }

    @Override
    public List<Etudiant> getEtudiantsParClasse(Classe classe) {
        return classe.getEtudiants();
    }
}
