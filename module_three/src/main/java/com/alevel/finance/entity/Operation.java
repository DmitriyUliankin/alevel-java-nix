package com.alevel.finance.entity;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "operations")
public class Operation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "operation_name")
    private String name;

    @Column(name = "operation_cost")
    private BigDecimal cost;

    @OneToOne
    @JoinColumn(name = "income_category")
    private IncomeCategory incomeCategory;

    @OneToOne
    @JoinColumn(name = "outcome_category")
    private OutcomeCategory outcomeCategory;

    @Embedded
    private Timestamp timestamps;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getCost() {
        return cost;
    }

    public void setCost(BigDecimal cost) {
        this.cost = cost;
    }

    public Timestamp getTimestamps() {
        return timestamps;
    }

    public void setTimestamps(Timestamp timestamps) {
        this.timestamps = timestamps;
    }

    public IncomeCategory getIncomeCategory() {
        return incomeCategory;
    }

    public void setIncomeCategory(IncomeCategory incomeCategory) {
        this.incomeCategory = incomeCategory;
        if (incomeCategory.getCost().compareTo(this.cost) > 0) {
            throw new IllegalArgumentException();
        }
    }

    public OutcomeCategory getOutcomeCategory() {
        return outcomeCategory;
    }

    public void setOutcomeCategory(OutcomeCategory outcomeCategory) {
        this.outcomeCategory = outcomeCategory;
        if (outcomeCategory.getCost().compareTo(this.cost) < 0) {
            throw new IllegalArgumentException();
        }
    }
}
