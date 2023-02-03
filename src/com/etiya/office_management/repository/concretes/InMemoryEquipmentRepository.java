package com.etiya.office_management.repository.concretes;

import com.etiya.office_management.entity.concrete.Equipment;
import com.etiya.office_management.repository.abstracts.IEquipmentRepository;

import java.util.ArrayList;
import java.util.List;

public class InMemoryEquipmentRepository implements IEquipmentRepository {

    private List<Equipment> equipments;

    public InMemoryEquipmentRepository() {
        this.equipments = new ArrayList<>();
    }

    @Override
    public List<Equipment> getAll() {
        return equipments;
    }

    @Override
    public Equipment getById(int id) {
        return equipments.stream().filter(equipment -> equipment.getId()==id).findFirst().orElse(null);
    }

    @Override
    public void add(Equipment entity) {
        equipments.add(entity);
    }

    @Override
    public void update(Equipment entity) {
        Equipment equipment = getById(entity.getId());
        int indexToBeUpdated = equipments.indexOf(equipment);
        equipments.set(indexToBeUpdated, entity);
    }

    @Override
    public void delete(Equipment entity) {
        equipments.remove(entity);
    }
}
