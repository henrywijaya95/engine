package com.henry.engine.staff.service;

import com.henry.engine.staff.model.Staff;
import com.henry.engine.staff.repository.StaffRepository;
import io.lettuce.core.api.sync.RedisCommands;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StaffService {
    @Autowired
    private RedisCommands<String,String> commands;

    private final StaffRepository staffRepository;

    public StaffService(RedisCommands<String, String> commands, StaffRepository staffRepository) {
        this.commands = commands;
        this.staffRepository = staffRepository;
    }

    public List<Staff> getAllStaff() {
        return staffRepository.findAll();
    }

    public HttpStatus addStaff(Staff newStaff) {
        staffRepository.save(newStaff);
        commands.set("email", newStaff.getEmail());
        commands.save();

        return HttpStatus.OK;
    }

    public Optional<Staff> getStaffById(long id) {
        return staffRepository.findById(id);
    }

    public HttpStatus updateStaff(Staff updateStaff) {
        staffRepository.save(updateStaff);

        return HttpStatus.OK;
    }

    public HttpStatus deleteStaff(long id) {
        staffRepository.deleteById(id);

        return HttpStatus.OK;
    }
}
