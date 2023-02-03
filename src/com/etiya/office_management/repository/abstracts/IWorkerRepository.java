package com.etiya.office_management.repository.abstracts;

import com.etiya.office_management.core.ccc.dataAccess.GenericRepository;
import com.etiya.office_management.entity.concrete.Worker;

import java.util.List;

public interface IWorkerRepository extends GenericRepository<Worker> {
    List<Worker> getSubordinates(Worker worker);
}
