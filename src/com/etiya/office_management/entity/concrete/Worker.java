package com.etiya.office_management.entity.concrete;

import com.etiya.office_management.entity.abstracts.IEntity;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Worker implements IEntity {
    int id;
    String name;
    String lastName;
    String birthDate;
    String email;
    String password;
    List<Worker> subworkers;
    List<Equipment> registeredEquipments;

    public Worker(int id, String name, String lastName, String birthDate, String email, String password) {
        this.id = id;
        this.name = name;
        this.lastName = lastName;
        this.birthDate = birthDate;
        this.email = email;
        this.password = password;
        subworkers = new ArrayList<>();
        registeredEquipments = new ArrayList<>();
    }

    public List<Equipment> getRegisteredEquipments() {
        return registeredEquipments;
    }

    public void addRegisteredEquipment(Equipment equipment) {
        this.registeredEquipments.add(equipment);
    }

    public void unRegisterEquipment(Equipment equipment){
        this.registeredEquipments.remove(equipment);
    }

    public List<Worker> getSubworkers() {
        return subworkers;
    }

    public void addSubworker(Worker subworker) {
        this.subworkers.add(subworker);
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

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {

        return "Worker{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", lastName='" + lastName + '\'' +
                ", birthDate='" + birthDate + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", subworkers=" + subworkers.stream().toList().toString() +
                '}';
    }
}
