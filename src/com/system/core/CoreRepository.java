package com.system.core;

import java.util.List;

public interface CoreRepository {
    public List<?> getAll();
    public Object save(Object object);
    public Object getOne(int id);
    public Object update(Object object);
    public void delete(int id);
}
