package ru.job4j.pojo;

import java.util.Date;

public class College {

    public static void main(String[] args) {
        Student student = new Student();
        student.setFullName("Ревунок Олег");
        student.setGroup("123");
        student.setReceiptDate(new Date());
        System.out.println("Студент " + student.getFullName() + " из группы " + student.getGroup() + " поступил " + student.getReceiptDate());
    }
}
