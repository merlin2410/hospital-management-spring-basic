package com.example.hospital.management;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("/patient")
public class PatientController {

    HashMap<Integer,Patient> patientDb = new HashMap<>();

    @PostMapping("/add")
    public String addPatient(@RequestParam("patientId")Integer patientId, @RequestParam("name")String name,
                           @RequestParam("disease")String disease, @RequestParam("age")Integer age)
    {
        Patient patient = new Patient(patientId, name, disease, age);
        patientDb.put(patientId,patient);
        return "Patient added successfully";
    }

    @PostMapping("/addViaRequestBody")
    public String addPatient(@RequestBody Patient patient)
    {
        int key = patient.getPatientId();
        patientDb.put(key,patient);
        return "Patient added successfully";
    }

    @GetMapping("/getInfoViaPathVariable/{patientId}")
    public Patient getPatientViaPath(@PathVariable("patientId")Integer patientId)
    {
        Patient patient = patientDb.get(patientId);
        return patient;
    }

    @GetMapping("/getInfo")
    public Patient getPatient(@RequestParam("patientId")Integer patientId)
    {
        Patient patient = patientDb.get(patientId);
        return patient;
    }

    @GetMapping("/getAll")
    public List<Patient> getAllPatients()
    {
        List<Patient> listOfPatients= new ArrayList<>();
        for(Patient patient: patientDb.values())
        {
            listOfPatients.add(patient);
        }
        return listOfPatients;
    }

    @GetMapping("/getByName")
    public Patient getPatientByName(@RequestParam("name")String name)
    {
        for(Patient patient: patientDb.values())
        {
            if(patient.getName().equals(name))
                return patient;
        }
        return null;
    }

    @GetMapping("/getListAgeDisease/{age}/{disease}")
    public List<Patient> getPatientListAgeDisease(@PathVariable("age")Integer age, @PathVariable("disease")String disease)
    {
        List<Patient> patientList = new ArrayList<>();
        for(Patient patient: patientDb.values())
        {
            if(patient.getAge()>age && patient.getDisease().equals(disease))
                patientList.add(patient);

        }
        return patientList;
    }

    @PutMapping("/update")
    public String updatePatient(@RequestBody Patient patient)
    {
        int key = patient.getPatientId();
        if(patientDb.containsKey(key))
        {
            patientDb.put(key,patient);
            return "Patient Details Added Successfully";
        }
        return "Patient does not exist";
    }

    @PutMapping("/updateDisease")
    public String updateDisease(@RequestParam("patientId")Integer patientId, @RequestParam("disease")String disease)
    {
        if(patientDb.containsKey(patientId))
        {
            Patient patient = patientDb.get(patientId);
            patient.setDisease(disease);
            patientDb.put(patientId,patient);
            return "Disease update successfully";
        }
        return "Patient does not exist";
    }

    @DeleteMapping("/delete")
    public String deletePatient(@RequestParam("patientId")Integer patientId)
    {
        patientDb.remove(patientId);
        return "Patient Deleted Successfully";
    }
}
