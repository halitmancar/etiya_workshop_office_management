package com.etiya.office_management.presentation.console.factory;

import com.etiya.office_management.core.ccc.caching.ICaching;
import com.etiya.office_management.core.ccc.caching.InMemoryCaching;
import com.etiya.office_management.core.ccc.logging.ConsoleLogger;
import com.etiya.office_management.core.ccc.logging.ILogger;
import com.etiya.office_management.repository.abstracts.IEquipmentRepository;
import com.etiya.office_management.repository.abstracts.IWorkerRepository;
import com.etiya.office_management.repository.concretes.InMemoryEquipmentRepository;
import com.etiya.office_management.repository.concretes.InMemoryWorkerRepository;
import com.etiya.office_management.service.abstracts.IEquipmentService;
import com.etiya.office_management.service.abstracts.IWorkerService;
import com.etiya.office_management.service.concrete.EquipmentService;
import com.etiya.office_management.service.concrete.WorkerService;
import com.etiya.office_management.service.facade.EquipmentServiceFacade;
import com.etiya.office_management.service.facade.WorkerServiceFacade;

public class Factory implements IFactory{
    @Override
    public ILogger createLogger() {
        return new ConsoleLogger();
    }

    @Override
    public ICaching createCaching() {
        return new InMemoryCaching();
    }

    @Override
    public IWorkerRepository createWorkerRepository() {
        return new InMemoryWorkerRepository();
    }

    @Override
    public IEquipmentRepository createEquipmentRepository() {
        return new InMemoryEquipmentRepository();
    }

    @Override
    public IWorkerService createWorkerService() {
        WorkerServiceFacade facade = new WorkerServiceFacade(createCaching(), createLogger(), createWorkerRepository());
        return new WorkerService(facade);
    }

    @Override
    public IEquipmentService createEquipmentService() {
        EquipmentServiceFacade facade = new EquipmentServiceFacade(createEquipmentRepository(), createLogger(), createCaching(), createWorkerService());
        return new EquipmentService(facade);
    }
}
