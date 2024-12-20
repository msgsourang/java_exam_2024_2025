package ism.maecdsd;

import ism.maecdsd.entity.Classe;
import ism.maecdsd.entity.Cours;
import ism.maecdsd.entity.Niveau;
import ism.maecdsd.entity.Professeur;
import ism.maecdsd.entity.Role;
import ism.maecdsd.entity.User;
import ism.maecdsd.repository.implementation.CoursRepositoryImpl;
import ism.maecdsd.services.implementation.CoursServiceImpl;
import ism.maecdsd.services.interfaces.CoursService;
import ism.maecdsd.entity.*;
import ism.maecdsd.services.implementation.*;
import ism.maecdsd.services.interfaces.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        List<Cours> listeCours = new ArrayList<>();
        List<Classe> listeClasses = new ArrayList<>();
        List<Professeur> listeProfesseurs = new ArrayList<>();
        List<Niveau> listeNiveaux = new ArrayList<>();

        CoursService coursService = new CoursServiceImpl(new CoursRepositoryImpl(listeCours));

        Professeur prof1 = new Professeur(1, "Mbengue", "Alioune Badara");
        Professeur prof2 = new Professeur(2, "Melba", "Aurelie");
        listeProfesseurs.add(prof1);
        listeProfesseurs.add(prof2);

        Classe classe1 = new Classe(1, "MAE", new Niveau(1, "Licence 3"));
        Classe classe2 = new Classe(2, "CDSD", new Niveau(1, "Licence 3"));
        listeClasses.add(classe1);
        listeClasses.add(classe2);

        User admin = new User("admin", "pass123", Role.ADMIN);

        System.out.println("---- Connexion ----");
        System.out.print("Login : ");
        String login = sc.next();
        System.out.print("Password : ");
        String password = sc.next();

        if (admin.getLogin().equals(login) && admin.getPassword().equals(password)) {
            if (admin.getRole() == Role.ADMIN) {
                System.out.println("Bienvenue, Admin !");
                adminMenu(sc, coursService, listeProfesseurs, listeClasses, listeNiveaux);
            } else {
                System.out.println("Accès refusé !");
            }
        } else {
            System.out.println("Identifiants incorrects !");
        }

        sc.close();
    }

    private static void adminMenu(Scanner sc, CoursService coursService, List<Professeur> listeProfesseurs, List<Classe> listeClasses, List<Niveau> listeNiveaux) {
        int choix;
        do {
            System.out.println("---- Interface Admin ----");
            System.out.println("1 - Créer un cours");
            System.out.println("2 - Créer un niveau");
            System.out.println("3 - Afficher les cours d'une classe");
            System.out.println("4 - Afficher les cours d’un professeur");
            System.out.println("5 - Afficher les cours d’un niveau"); 
            System.out.println("6 - Quitter");
            System.out.print("Choisissez une option : ");
            choix = sc.nextInt();

            switch (choix) {
                case 1 -> {
                    Professeur professeur = choisirProfesseur(sc, listeProfesseurs);
                    System.out.print("Entrez le module : ");
                    String module = sc.next();
                    Classe classe = choisirClasse(sc, listeClasses);
                    Cours cours = new Cours(coursService.generateId(), professeur, List.of(classe), module);
                    coursService.ajouterCours(cours);
                    System.out.println("Cours ajouté avec succès !");
                }
                case 2 -> {
                    System.out.print("Nom du niveau : ");
                    String nomNiveau = sc.next();
                    listeNiveaux.add(new Niveau(listeNiveaux.size() + 1, nomNiveau));
                    System.out.println("Niveau créé !");
                }
                case 3 -> {
                    Classe classe = choisirClasse(sc, listeClasses);
                    coursService.afficherCours(coursService.afficherCoursClasse(classe));
                }
                case 4 -> {
                    Professeur professeur = choisirProfesseur(sc, listeProfesseurs);
                    coursService.afficherCours(coursService.afficherCoursProfesseur(professeur));
                }
                case 5 -> { 
                    Niveau niveau = choisirNiveau(sc, listeNiveaux);
                    coursService.afficherCours(coursService.afficherCoursNiveau(niveau));
                }
                case 6 -> System.out.println("Déconnexion réussie.");
                default -> System.out.println("Option non valide !");
            }
        } while (choix != 6);
    }
    private static Professeur choisirProfesseur(Scanner sc, List<Professeur> listeProfesseurs) {
        System.out.println("Liste des professeurs : ");
        listeProfesseurs.forEach(prof -> System.out.println(prof.getId() + " - " + prof.getNom()));
        System.out.print("Choisissez un professeur : ");
        int id = sc.nextInt();
        return listeProfesseurs.stream()
                .filter(prof -> prof.getId() == id)
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Professeur non trouvé !"));
    }

    private static Classe choisirClasse(Scanner sc, List<Classe> listeClasses) {
        System.out.println("Liste des classes : ");
        listeClasses.forEach(classe -> System.out.println(classe.getId() + " - " + classe.getNom()));
        System.out.print("Choisissez une classe : ");
        int id = sc.nextInt();
        return listeClasses.stream()
                .filter(classe -> classe.getId() == id)
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Classe non trouvée !"));
    }
    private static Niveau choisirNiveau(Scanner sc, List<Niveau> listeNiveaux) {
        if (listeNiveaux.isEmpty()) {
            System.out.println("Aucun niveau disponible !");
            return null;
        }
    
        System.out.println("Liste des niveaux : ");
        listeNiveaux.forEach(niveau -> System.out.println(niveau.getId() + " - " + niveau.getNom()));
        System.out.print("Choisissez un niveau : ");
        int id = sc.nextInt();
        return listeNiveaux.stream()
                .filter(niveau -> niveau.getId() == id)
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Niveau non trouvé !"));
    }
}
