package com.etiya.office_management.entity.concrete;

public class Equipment {
    int id;
    String name;
    String color;
    EquipmentCategory category;
    String serialNumber;
    double price;
    Worker worker;

    public Equipment(int id, String name, String color, EquipmentCategory category, String serialNumber, double price, Worker worker) {
        this.id = id;
        this.name = name;
        this.color = color;
        this.category = category;
        this.serialNumber = serialNumber;
        this.price = price;
        this.worker = worker;
        if (worker!=null){
            worker.addRegisteredEquipment(this);
        }
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public EquipmentCategory getCategory() {
        return category;
    }

    public void setCategory(EquipmentCategory category) {
        this.category = category;
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Worker getWorker() {
        return worker;
    }

    public void setWorker(Worker worker) {
        this.worker = worker;
    }

    @Override
    public String toString() {
        return "Equipment{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", color='" + color + '\'' +
                ", category=" + category +
                ", serialNumber='" + serialNumber + '\'' +
                ", price=" + price +
                ", worker=" + worker +
                '}';
    }
}
