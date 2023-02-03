package com.etiya.office_management.service.facade;

import com.etiya.office_management.core.ccc.caching.ICaching;
import com.etiya.office_management.core.ccc.logging.ILogger;
import com.etiya.office_management.repository.abstracts.IEquipmentRepository;
import com.etiya.office_management.service.abstracts.IWorkerService;
import com.etiya.office_management.service.rules.EquipmentBusinessRules;

public class EquipmentServiceFacade {
    public IEquipmentRepository equipmentRepository;
    public ILogger logger;
    public ICaching caching;
    public EquipmentBusinessRules equipmentBusinessRules;
    public IWorkerService workerService;

    public EquipmentServiceFacade(IEquipmentRepository equipmentRepository, ILogger logger, ICaching caching, IWorkerService workerService) {
        this.equipmentRepository = equipmentRepository;
        this.logger = logger;
        this.caching = caching;
        this.equipmentBusinessRules = EquipmentBusinessRules.getInstance(equipmentRepository);
        this.workerService = workerService;
    }
}
