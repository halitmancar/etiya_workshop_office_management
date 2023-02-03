package com.etiya.office_management.presentation.console;

import com.etiya.office_management.entity.concrete.Equipment;
import com.etiya.office_management.entity.concrete.EquipmentCategory;
import com.etiya.office_management.entity.concrete.Worker;
import com.etiya.office_management.presentation.console.factory.Factory;
import com.etiya.office_management.presentation.console.factory.IFactory;
import com.etiya.office_management.service.abstracts.IEquipmentService;
import com.etiya.office_management.service.abstracts.IWorkerService;

import java.util.List;

public class Main {


    public static void main(String[] args) throws Exception {

        Worker worker = new Worker(1,"Halit","Mancar","14.07.1997", "halit.mancar@etiya.com", "123");
        Worker worker1 = new Worker(2,"Erdi","Tuna","22.03.1996", "erdi.tuna@etiya.com", "123");
        Worker worker2 = new Worker(3,"Doruk","Şenay","12.04.1998", "doruk.senay@etiya.com", "123");
        Worker worker3 = new Worker(4,"Mehmet","Özlü","30.07.1995", "mehmet.ozlu@etiya.com", "123");
        Worker worker4 = new Worker(5,"Ahmet","Terzi","04.05.1996", "ahmet.terzi@etiya.com", "123");
        Worker worker5 = new Worker(1, "Metin", "Gürler", "22.02.1995","metin.gurler@etiya.com","123");

        IFactory factory = new Factory();
        IEquipmentService equipmentService = factory.createEquipmentService();
        IWorkerService workerService = factory.createWorkerService();
        workerService.add(worker);
        workerService.add(worker1);
        workerService.add(worker2);
        workerService.add(worker3);
        workerService.add(worker4);
        Equipment equipment = new Equipment(1,"Mouse", "Gray", EquipmentCategory.COMPUTER_PARTS, "MO001",50.0, workerService.getByID(1));
        Equipment equipment1 = new Equipment(2,"Desk", "Black", EquipmentCategory.FURNITURE, "DE001",350.0, workerService.getByID(1));
        Equipment equipment2 = new Equipment(3,"Chair", "Red", EquipmentCategory.FURNITURE, "CH001",250.0, workerService.getByID(1));
        Equipment equipment3 = new Equipment(4,"Mouse", "Gray", EquipmentCategory.COMPUTER_PARTS, "MO002",50.0, workerService.getByID(2));
        Equipment equipment4 = new Equipment(5,"Desk", "Black", EquipmentCategory.FURNITURE, "DE002",350.0, workerService.getByID(2));
        Equipment equipment5 = new Equipment(6,"Chair", "Red", EquipmentCategory.FURNITURE, "CH002",250.0, null);
        Equipment equipment6 = new Equipment(7,"Mouse", "Gray", EquipmentCategory.COMPUTER_PARTS, "MO003",50.0, workerService.getByID(3));
        Equipment equipment7 = new Equipment(8,"Desk", "Black", EquipmentCategory.FURNITURE, "DE003",350.0, workerService.getByID(5));
        Equipment equipment8 = new Equipment(9,"Chair", "Red", EquipmentCategory.FURNITURE, "CH003",250.0, workerService.getByID(4));
        Equipment equipment9 = new Equipment(10,"Oven", "White", EquipmentCategory.KITCHEN, "OV001",500.0, workerService.getByID(3));
        Equipment equipment10 = new Equipment(11,"Keyboard", "Black", EquipmentCategory.COMPUTER_PARTS, "KE001",100.0, workerService.getByID(2));
        Equipment equipment11 = new Equipment(12,"USB Drive", "Red", EquipmentCategory.COMPUTER_PARTS, "US001",25.0, workerService.getByID(5));
        equipmentService.add(equipment);
        equipmentService.add(equipment1);
        equipmentService.add(equipment2);
        equipmentService.add(equipment3);
        equipmentService.add(equipment4);
        equipmentService.add(equipment5);
        equipmentService.add(equipment6);
        equipmentService.add(equipment7);
        equipmentService.add(equipment8);
        equipmentService.add(equipment9);
        equipmentService.add(equipment10);
        equipmentService.add(equipment11);

        List<Equipment> equipmentList2 = worker1.getRegisteredEquipments();

        for (Equipment e: equipmentList2) {
            System.out.println(e.getSerialNumber());
        }

        //System.out.println(equipment5.getWorker().getName());
        System.out.println("******************");

        workerService.registerEquipmentToWorker(worker, equipment3);
        workerService.registerEquipmentToWorker(worker1,equipment5);

        List<Equipment> equipmentList = worker1.getRegisteredEquipments();

        for (Equipment e: equipmentList) {
            System.out.println(e.getSerialNumber());
        }
        System.out.println(equipment5.getWorker().getName());
        System.out.println("******************");
        equipmentService.unregisterEquipment(equipment4);

        List<Equipment> equipmentList1 = worker1.getRegisteredEquipments();

        for (Equipment e: equipmentList1) {
            System.out.println(e.getSerialNumber());
        }

        worker.addSubworker(worker1);
        worker.addSubworker(worker2);
        worker1.addSubworker(worker3);
        worker2.addSubworker(worker4);
        //System.out.println(worker.toString());

        //System.out.println(equipmentService.getAll());

        //System.out.println(equipmentService.getByID(3));

        System.out.println(workerService.getByID(1).getName());
        workerService.update(worker5);
        System.out.println(workerService.getByID(1).getName());

    }


}
