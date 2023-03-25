package com.example.hospital.management;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@RestController
public class PatientController {

    HashMap<Integer,Patient> patientDb = new HashMap<>();

    @PostMapping("/addPatient")
    public String addPatient(@RequestParam("patientId")Integer patientId, @RequestParam("name")String name,
                           @RequestParam("disease")String disease, @RequestParam("age")Integer age)
    {
        Patient patient = new Patient(patientId, name, disease, age);
        patientDb.put(patientId,patient);
        return "Patient added successfully";
    }

    @PostMapping("/addPatientViaRequestBody")
    public String addPatient(@RequestBody Patient patient)
    {
        int key = patient.getPatientId();
        patientDb.put(key,patient);
        return "Patient added successfully";
    }

    @GetMapping("/getPatientInfo")
    public Patient getPatient(@RequestParam("patientId")Integer patientId)
    {
        Patient patient = patientDb.get(patientId);
        return patient;
    }

    @GetMapping("/getAllPatients")
    public List<Patient> getAllPatients()
    {
        List<Patient> listOfPatients= new ArrayList<>();
        for(Patient patient: patientDb.values())
        {
            listOfPatients.add(patient);
        }
        return listOfPatients;
    }

    @GetMapping("/getPatientByName")
    public Patient getPatientByName(@RequestParam("name")String name)
    {
        for(Patient patient: patientDb.values())
        {
            if(patient.getName().equals(name))
                return patient;
        }
        return null;
    }
}
