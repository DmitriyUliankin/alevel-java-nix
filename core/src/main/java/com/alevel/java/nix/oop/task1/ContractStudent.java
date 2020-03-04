package com.alevel.java.nix.oop.task1;

public class ContractStudent extends Student {

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
