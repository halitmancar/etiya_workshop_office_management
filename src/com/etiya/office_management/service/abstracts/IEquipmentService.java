package com.etiya.office_management.service.abstracts;

import com.etiya.office_management.entity.concrete.Equipment;

import java.util.List;

public interface IEquipmentService {
    List<Equipment> getAll();
    Equipment getByID(int id);
    void add(Equipment equipment) throws Exception;
    void update(Equipment equipment) throws Exception;
    void delete(Equipment equipment) throws Exception;
    void unregisterEquipment(Equipment equipment) throws Exception;
}
