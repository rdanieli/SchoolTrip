package com.eng.framework.dao;

import java.io.Serializable;
import java.util.List;

public interface FrameworkDAO<T, PK extends Serializable>
{

    void create(T newInstance);

    T read(PK id);

    void update(T transientObject);

    void delete(T persistentObject);
    
    List<T> find(T seachEntity);
    
    T findUnique(T searchEntity);
}
