package com.eng.schooltrip.business.impl;

import java.io.Serializable;
import java.util.List;

public interface SimpleCRUD<T, PK extends Serializable>
{

    void create(T newInstance);

    T read(PK id);

    void update(T transientObject);

    void delete(T persistentObject);
    
    List<T> find(T seachEntity);
}
