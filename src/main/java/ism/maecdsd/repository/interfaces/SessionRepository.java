package ism.maecdsd.repository.interfaces;

import ism.maecdsd.entity.Session;
import ism.maecdsd.repository.Repository;
import ism.maecdsd.entity.Cours;
import java.util.List;

public interface SessionRepository extends Repository<Session> {
    List<Session> getSessionsByCours(Cours cours);
}
