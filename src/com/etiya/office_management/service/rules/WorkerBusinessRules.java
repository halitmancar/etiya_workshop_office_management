package com.etiya.office_management.service.rules;

import com.etiya.office_management.entity.concrete.Equipment;
import com.etiya.office_management.entity.concrete.Worker;
import com.etiya.office_management.repository.abstracts.IWorkerRepository;

public class WorkerBusinessRules {
    private IWorkerRepository workerRepository;

    private static WorkerBusinessRules instance;

    public static WorkerBusinessRules getInstance(IWorkerRepository workerRepository){
        if (instance==null){
            instance = new WorkerBusinessRules();
        }
        instance.workerRepository=workerRepository;
        return instance;
    }

    public void checkIfWorkerExistsByID(int id) throws Exception {
        Worker worker = workerRepository.getById(id);
        if (worker==null){
            throw new Exception("Bu ID'ye sahip çalışan bulunamadı!");
        }
    }
    public void checkIfEquipmentIsAlreadyRegisteredToThatSpecificWorker(Equipment equipment, Worker worker) throws Exception {
        if (equipment.getWorker()==worker){
            throw new Exception("Equipment is already registered to worker: " + worker.getName() + " " + worker.getLastName());
        }
    }
    public boolean checkIfEquipmentIsRegisteredToAnotherWorker(Equipment equipment){
        if (equipment.getWorker()!=null){
            return true;
        }
        return false;
    }
}
