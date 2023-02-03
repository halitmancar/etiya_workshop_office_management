package com.etiya.office_management.repository.concretes;

import com.etiya.office_management.entity.concrete.Worker;
import com.etiya.office_management.repository.abstracts.IWorkerRepository;

import java.util.ArrayList;
import java.util.List;

public class InMemoryWorkerRepository implements IWorkerRepository {

    private List<Worker> workers;

    public InMemoryWorkerRepository() {
        this.workers = new ArrayList<>();
    }

    @Override
    public List<Worker> getAll() {
        return workers;
    }

    @Override
    public Worker getById(int id) {
        return workers.stream().filter(worker -> worker.getId()==id).findFirst().orElse(null);
    }

    @Override
    public void add(Worker entity) {
        workers.add(entity);
    }

    @Override
    public void update(Worker entity) {
        Worker worker = getById(entity.getId());
        int indexToBeUpdated = workers.indexOf(worker);
        workers.set(indexToBeUpdated, entity);
    }

    @Override
    public void delete(Worker entity) {
        workers.remove(entity);
    }

    @Override
    public List<Worker> getSubordinates(Worker worker) {
        return worker.getSubworkers();
    }
}
