package com.etiya.office_management.service.concrete;

import com.etiya.office_management.core.ccc.caching.ICaching;
import com.etiya.office_management.core.ccc.logging.ILogger;
import com.etiya.office_management.entity.concrete.Equipment;
import com.etiya.office_management.entity.concrete.Worker;
import com.etiya.office_management.repository.abstracts.IEquipmentRepository;
import com.etiya.office_management.service.abstracts.IEquipmentService;
import com.etiya.office_management.service.facade.EquipmentServiceFacade;

import java.util.List;

public class EquipmentService implements IEquipmentService {

    private EquipmentServiceFacade equipmentServiceFacade;

    public EquipmentService(EquipmentServiceFacade equipmentServiceFacade) {
        this.equipmentServiceFacade = equipmentServiceFacade;
    }

    @Override
    public List<Equipment> getAll() {
        return equipmentServiceFacade.equipmentRepository.getAll();
    }

    @Override
    public Equipment getByID(int id) {
        return equipmentServiceFacade.equipmentRepository.getById(id);
    }

    @Override
    public void add(Equipment equipment) throws Exception {
        equipmentServiceFacade.logger.log("equipment.add()");
        equipmentServiceFacade.equipmentRepository.add(equipment);
    }

    @Override
    public void update(Equipment equipment) throws Exception {
        equipmentServiceFacade.logger.log("equipment.update()");
        equipmentServiceFacade.equipmentRepository.update(equipment);
    }

    @Override
    public void delete(Equipment equipment) throws Exception {
        equipmentServiceFacade.equipmentRepository.delete(equipment);
    }

    /**
     * This method unregister the equipment from the worker and sets the variable worker of the Equipment to the null.
     * @param equipment this is the equipment to be unregistered.
     * @throws Exception
     */
    @Override
    public void unregisterEquipment(Equipment equipment) throws Exception {
        equipmentServiceFacade.equipmentBusinessRules.checkIfEquipmentIsRegisteredToAnyWorker(equipment.getId());
        Worker worker = equipment.getWorker();
        equipmentServiceFacade.workerService.unregisterEquipmentFromWorker(worker,equipment);
        equipment.setWorker(null);
    }
}
