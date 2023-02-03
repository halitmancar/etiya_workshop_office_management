package com.etiya.office_management.service.rules;

import com.etiya.office_management.entity.concrete.Equipment;
import com.etiya.office_management.entity.concrete.Worker;
import com.etiya.office_management.repository.abstracts.IEquipmentRepository;

public class EquipmentBusinessRules {
    private IEquipmentRepository equipmentRepository;

    private static EquipmentBusinessRules instance;

    public static EquipmentBusinessRules getInstance(IEquipmentRepository equipmentRepository){
        if (instance==null){
            instance = new EquipmentBusinessRules();
            instance.equipmentRepository = equipmentRepository;
        }
        return instance;
    }
    public void checkIfEquipmentExistsByID(int id) throws Exception {
        Equipment equipment = equipmentRepository.getById(id);
        if (equipment==null){
            throw new Exception("Bu ID'ye kayıtlı ekipman bulunamadı.");
        }
    }
    public void checkIfEquipmentIsRegisteredToAnyWorker(int id) throws Exception {
        Equipment equipment = equipmentRepository.getById(id);
        if (equipment.getWorker()==null){
            throw new Exception("Equipment is not registered to any worker!");
        }
    }
}
