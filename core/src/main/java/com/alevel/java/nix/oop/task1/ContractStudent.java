package com.alevel.java.nix.oop.task1;

import java.util.List;

public class ContractStudent extends Student {

    private List<ContractStudent> contractStudents = null;
    private double contractPrice;

    public ContractStudent(String name, int age, double contractPrice) {
        super(name, age);
        this.contractPrice = contractPrice;
    }

    public double getContractPrice() {
        return contractPrice;
    }

    public void setContractPrice(double contractPrice) {
        this.contractPrice = contractPrice;
    }
}
