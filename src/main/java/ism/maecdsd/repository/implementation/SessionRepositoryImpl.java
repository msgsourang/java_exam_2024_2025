package ism.maecdsd.repository.implementation;

import ism.maecdsd.entity.Session;
import ism.maecdsd.entity.Cours;
import ism.maecdsd.repository.interfaces.SessionRepository;
import java.util.ArrayList;
import java.util.List;

public class SessionRepositoryImpl implements SessionRepository {
    private List<Session> list = new ArrayList<>();

    public SessionRepositoryImpl(List<Session> list) {
        this.list = list;
    }
    @Override
    public void insert(Session session) {
        list.add(session);
    }

    @Override
    public List<Session> lister() {
        return list;
    }

    @Override
    public List<Session> getSessionsByCours(Cours cours) {
        return list.stream()
            .filter(session -> session.getCours().equals(cours))
            .toList();
    }
}
