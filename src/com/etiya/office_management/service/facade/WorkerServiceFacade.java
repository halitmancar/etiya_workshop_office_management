package com.etiya.office_management.service.facade;

import com.etiya.office_management.core.ccc.caching.ICaching;
import com.etiya.office_management.core.ccc.logging.ILogger;
import com.etiya.office_management.repository.abstracts.IEquipmentRepository;
import com.etiya.office_management.repository.abstracts.IWorkerRepository;
import com.etiya.office_management.service.rules.EquipmentBusinessRules;
import com.etiya.office_management.service.rules.WorkerBusinessRules;

public class WorkerServiceFacade {
    public ICaching caching;
    public ILogger logger;
    public WorkerBusinessRules workerBusinessRules;
    public IWorkerRepository workerRepository;

    public WorkerServiceFacade(ICaching caching, ILogger logger, IWorkerRepository workerRepository) {
        this.caching = caching;
        this.logger = logger;
        this.workerRepository = workerRepository;
        this.workerBusinessRules = WorkerBusinessRules.getInstance(workerRepository);
    }
}
