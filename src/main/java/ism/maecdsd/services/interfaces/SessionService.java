package ism.maecdsd.services.interfaces;

import ism.maecdsd.entity.Session;
import ism.maecdsd.entity.Cours;
import java.util.List;

public interface SessionService {
    void planifierSession(Session session);
    List<Session> afficherSessionsParCours(Cours cours);
    void ajouterSession(Session session, Cours cours);
    List<Session> listerSessions(Cours cours);
}
