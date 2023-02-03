package com.etiya.office_management.service.concrete;

import com.etiya.office_management.core.ccc.caching.ICaching;
import com.etiya.office_management.core.ccc.logging.ILogger;
import com.etiya.office_management.entity.concrete.Equipment;
import com.etiya.office_management.entity.concrete.Worker;
import com.etiya.office_management.repository.abstracts.IWorkerRepository;
import com.etiya.office_management.service.abstracts.IWorkerService;
import com.etiya.office_management.service.facade.WorkerServiceFacade;
import com.etiya.office_management.service.rules.WorkerBusinessRules;

import java.util.List;

public class WorkerService implements IWorkerService {

    private WorkerServiceFacade workerServiceFacade;

    public WorkerService(WorkerServiceFacade workerServiceFacade) {
        this.workerServiceFacade = workerServiceFacade;
    }

    @Override
    public List<Worker> getAll() {
        return workerServiceFacade.workerRepository.getAll();
    }

    @Override
    public List<Worker> getSubordinates(Worker worker) {
        return workerServiceFacade.workerRepository.getSubordinates(worker);
    }

    @Override
    public List<Equipment> getRegisteredEquipments(int workerID) {
        Worker worker = workerServiceFacade.workerRepository.getById(workerID);
        return worker.getRegisteredEquipments();
    }

    @Override
    public Worker getByID(int id) {
        return workerServiceFacade.workerRepository.getById(id);
    }

    @Override
    public void add(Worker worker) throws Exception {

        workerServiceFacade.workerRepository.add(worker);
    }

    @Override
    public void update(Worker worker) throws Exception {
        workerServiceFacade.workerBusinessRules.checkIfWorkerExistsByID(worker.getId());
        workerServiceFacade.workerRepository.update(worker);
    }

    @Override
    public void delete(Worker worker) throws Exception {
        workerServiceFacade.workerBusinessRules.checkIfWorkerExistsByID(worker.getId());
        workerServiceFacade.workerRepository.delete(worker);
    }

    @Override
    public void addSubordinate(Worker superior, Worker sub) throws Exception {
        workerServiceFacade.workerBusinessRules.checkIfWorkerExistsByID(superior.getId());
        workerServiceFacade.workerRepository.getById(superior.getId()).addSubworker(sub);
    }

    @Override
    public void registerEquipmentToWorker(Worker worker, Equipment equipment) throws Exception {
        workerServiceFacade.workerBusinessRules.checkIfEquipmentIsAlreadyRegisteredToThatSpecificWorker(equipment,worker);
        if (workerServiceFacade.workerBusinessRules.checkIfEquipmentIsRegisteredToAnotherWorker(equipment)){
            equipment.getWorker().unRegisterEquipment(equipment);
        }
        worker.addRegisteredEquipment(equipment);
        equipment.setWorker(worker);
    }

    @Override
    public void unregisterEquipmentFromWorker(Worker worker, Equipment equipment) {
        worker.unRegisterEquipment(equipment);
    }
}
