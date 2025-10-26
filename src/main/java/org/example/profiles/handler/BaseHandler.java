package org.example.profiles.handler;

import java.util.List;
import java.util.Optional;

public abstract class BaseHandler<T, ID> {

    public abstract T create(T dto);

    public abstract Optional<T> getById(ID id);

    public abstract List<T> getAllByParentId(String parentId);

    public abstract T update(T dto);

    public abstract void delete(ID id);
}
