package com.alevel.java.nix.oop.task1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Group {

    private List<Student> students;

    private ContractStudents contractStudents;

    public Group() {
        students = new ArrayList<>();
        contractStudents = new ContractStudents();
    }

    public List<Student> getStudents() {
        return Collections.unmodifiableList(students);
    }

    public void add(Student student) {
        students.add(student);
        contractStudents.addIfContract(student);
    }

    public void addAll(Student[] students) {
        for (Student student : students) {
            add(student);
        }
    }

    private static class ContractStudents {

        private List<ContractStudent> listContract;

        private ContractStudents() {
            listContract = new ArrayList<>();
        }

        private void addIfContract(Student student) {
            if (student instanceof ContractStudent) {
                var contractStudent = (ContractStudent) student;
                listContract.add(contractStudent);
            }
        }

        public List<Student> getContractStudents() {
            return Collections.unmodifiableList(listContract);
        }
    }
}
