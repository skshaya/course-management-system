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

    public DivisionDao() {
        this.getAll();
    }

    @Override
    public List<Division> getAll() {
        divisions = Stream.of(
                new Division(1, "DIV001", "SATURDAY", "Desc"),
                new Division(2, "DIV002", "SUNDAY", "Desc"))
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
}
