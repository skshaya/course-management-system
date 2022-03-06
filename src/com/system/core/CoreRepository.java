
package com.system.core;

import java.util.List;

public interface CoreRepository {
    public List<?> getAll();
    public void save(Object object);
    public Object getOne(int id);
    public void update(Object object);
    public void delete(int id);
}
