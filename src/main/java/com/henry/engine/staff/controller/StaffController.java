package com.henry.engine.staff.controller;

import com.henry.engine.staff.model.Staff;
import com.henry.engine.staff.service.StaffService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class StaffController {
    private final StaffService staffService;

    public StaffController(StaffService staffService) {
        this.staffService = staffService;
    }

    @GetMapping(path="/staffs", produces= MediaType.APPLICATION_JSON_VALUE)
    private ResponseEntity<Staff[]> getAll()  {
        return ResponseEntity.ok(staffService.getAllStaff().toArray(new Staff[0]));
    }

    @PostMapping(path="/createStaff", produces= MediaType.APPLICATION_JSON_VALUE)
    public HttpStatus addStaff(@RequestBody Staff staff)  {
        return staffService.addStaff(staff);
    }

    @GetMapping(path="/getStaffById", produces= MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Optional<Staff>> getStaffById(@RequestParam long id)  {
        return ResponseEntity.ok(staffService.getStaffById(id));
    }

    @PutMapping(path="/updateStaff", produces= MediaType.APPLICATION_JSON_VALUE)
    public HttpStatus updateStaff(@RequestBody Staff staff)  {
        return staffService.updateStaff(staff);
    }

    @DeleteMapping(path="/deleteStaff", produces= MediaType.APPLICATION_JSON_VALUE)
    public HttpStatus deleteStaff(@RequestParam long id) {
        return staffService.deleteStaff(id);
    }
}
