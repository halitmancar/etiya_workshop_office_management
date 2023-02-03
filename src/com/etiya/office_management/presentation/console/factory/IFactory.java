package com.etiya.office_management.presentation.console.factory;

import com.etiya.office_management.core.ccc.caching.ICaching;
import com.etiya.office_management.core.ccc.logging.ILogger;
import com.etiya.office_management.repository.abstracts.IEquipmentRepository;
import com.etiya.office_management.repository.abstracts.IWorkerRepository;
import com.etiya.office_management.service.abstracts.IEquipmentService;
import com.etiya.office_management.service.abstracts.IWorkerService;

public interface IFactory {
    ILogger createLogger();
    ICaching createCaching();
    IWorkerRepository createWorkerRepository();
    IEquipmentRepository createEquipmentRepository();
    IWorkerService createWorkerService();
    IEquipmentService createEquipmentService();
}
