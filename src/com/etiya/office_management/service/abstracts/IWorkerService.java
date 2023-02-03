package com.etiya.office_management.service.abstracts;

import com.etiya.office_management.entity.concrete.Equipment;
import com.etiya.office_management.entity.concrete.Worker;

import java.util.List;

public interface IWorkerService {
    List<Worker> getAll();
    List<Worker> getSubordinates(Worker worker);
    List<Equipment> getRegisteredEquipments(int workerID);
    Worker getByID(int id);
    void add(Worker worker) throws Exception;
    void update(Worker worker) throws Exception;
    void delete(Worker worker) throws Exception;
    void addSubordinate(Worker superior, Worker sub) throws Exception;
    void registerEquipmentToWorker(Worker worker, Equipment equipment) throws Exception;
    void unregisterEquipmentFromWorker(Worker worker, Equipment equipment);
}
