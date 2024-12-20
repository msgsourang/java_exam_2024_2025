package ism.maecdsd.services.implementation;

import ism.maecdsd.entity.Session;
import ism.maecdsd.entity.Cours;
import ism.maecdsd.repository.interfaces.SessionRepository;
import ism.maecdsd.services.interfaces.SessionService;

import java.util.ArrayList;
import java.util.List;

public class SessionServiceImpl implements SessionService {
    private final SessionRepository sessionRepository;
    private final List<Session> sessions = new ArrayList<>();


    public SessionServiceImpl(SessionRepository sessionRepository) {
        this.sessionRepository = sessionRepository;
        
    }

    @Override
    public void planifierSession(Session session) {
        sessionRepository.insert(session);
    }

    @Override
    public List<Session> afficherSessionsParCours(Cours cours) {
        return sessionRepository.getSessionsByCours(cours);
    }

    @Override
    public void ajouterSession(Session session, Cours cours) {
        session.setCours(cours);
        sessions.add(session);
        sessionRepository.insert(session);
    }

    @Override
    public List<Session> listerSessions(Cours cours) {
        return sessions.stream()
                       .filter(session -> session.getCours().equals(cours))
                       .toList();
    }
}
