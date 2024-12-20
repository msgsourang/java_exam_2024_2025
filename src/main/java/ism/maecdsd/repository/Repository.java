package ism.maecdsd.repository;

import java.util.List;

public interface Repository<T> {
    void insert(T data);
    List<T> lister();
}