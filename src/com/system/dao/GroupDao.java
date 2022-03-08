package com.system.dao;

import com.system.core.CoreCollectionRepository;
import com.system.core.CoreRepository;
import com.system.model.Group;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class GroupDao extends CoreCollectionRepository {

    private List<Group> groups = new ArrayList<>();

    public GroupDao() {
        this.getAll();
    }

    @Override
    public List<Group> getAll() {
        groups = Stream.of(
                new Group(1, "GP001", "MORNING", "Desc"),
                new Group(1, "GP001", "AFTERNOON", "Desc"),
                new Group(1, "GP001", "EVENING", "Desc"))
                .collect(Collectors.toList());
        return groups;
    }

    @Override
    public int getTotal() {
        return this.groups.size();
    }
}
