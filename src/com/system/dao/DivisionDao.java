package com.system.dao;

import com.system.core.CoreCollectionRepository;
import com.system.model.Division;
import com.system.utils.Constant;
import com.system.utils.ResourceNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class DivisionDao extends CoreCollectionRepository {

    private static List<Division> divisions = new ArrayList<>();

    @Override
    public List<Division> getAll() {
        divisions = Stream.of(
                new Division(1, "DIV001", "Saturday", "Desc"),
                new Division(2, "DIV002", "Sunday", "Desc"))
                .collect(Collectors.toList());
        return divisions;
    }

    @Override
    public int getTotal() {
        return DivisionDao.divisions.size();
    }

    public static Division findById(int id) {
        return DivisionDao.divisions
                .stream()
                .filter(division -> division.getId() == id)
                .findFirst().orElseThrow(() -> new ResourceNotFoundException(Constant.RECORD_NOT_FOUND));
    }

    public static List<Division> loadToComboBox() {
        return DivisionDao.divisions;
    }

    public static Division getDivisionByName(String name) {
        return DivisionDao.divisions
                .stream()
                .filter(division -> division.getName().equals(name))
                .findFirst().orElseThrow(() -> new ResourceNotFoundException(Constant.RECORD_NOT_FOUND));
    }
}
