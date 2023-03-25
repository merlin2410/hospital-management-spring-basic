package com.example.hospital.management;

public class Doctor {
    private int doctorId;
    private String name;
    private int age;
    private String specialization;
    private String degree;

    public Doctor(int doctorId, String name, int age, String specialization, String degree) {
        this.doctorId = doctorId;
        this.name = name;
        this.age = age;
        this.specialization = specialization;
        this.degree = degree;
    }

    public int getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(int doctorId) {
        this.doctorId = doctorId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getSpecialization() {
        return specialization;
    }

    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }

    public String getDegree() {
        return degree;
    }

    public void setDegree(String degree) {
        this.degree = degree;
    }
}
