package com.system.dao;

import com.system.core.CoreCollectionRepository;
import com.system.model.Group;
import com.system.utils.Constant;
import com.system.utils.ResourceNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class GroupDao implements CoreCollectionRepository {

    private static List<Group> groups = new ArrayList<>();

    @Override
    public List<Group> getAll() {
        groups = Stream.of(
                new Group(1, "GP001", "Morning", "Desc"),
                new Group(2, "GP001", "Afternoon", "Desc"),
                new Group(3, "GP001", "Evening", "Desc"))
                .collect(Collectors.toList());
        return groups;
    }

    public static Group findById(int id) {
        return GroupDao.groups
                .stream()
                .filter(group -> group.getId() == id)
                .findFirst().orElseThrow(() -> new ResourceNotFoundException(Constant.RECORD_NOT_FOUND));
    }

    public static List<Group> findAll() {
        return GroupDao.groups;
    }

    public static Group getGroupByName(String name) {
        return GroupDao.groups
                .stream()
                .filter(group -> group.getName().equals(name))
                .findFirst().orElseThrow(() -> new ResourceNotFoundException(Constant.RECORD_NOT_FOUND));
    }
}
