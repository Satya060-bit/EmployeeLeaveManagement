package EmployeeLeaveManagementApplication.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import EmployeeLeaveManagementApplication.entity.LeaveRequest;
import EmployeeLeaveManagementApplication.repository.LeaveRepository;
import EmployeeLeaveManagementApplication.service.LeaveService;

@RestController
@RequestMapping("/leave")
@CrossOrigin
public class LeaveController {
	
	@Autowired
    private LeaveService leaveService;

    @PostMapping("/request")
    public LeaveRequest requestLeave(@RequestBody LeaveRequest leave) {
        return leaveService.requestLeave(leave);
    }

    @GetMapping("/all")
    public List<LeaveRequest> getAllLeaves() {
        return leaveService.getAllLeaves();
    }

    @PutMapping("/approve/{id}")
    public LeaveRequest approveLeave(@PathVariable int id) {
        return leaveService.approveLeave(id);
    }
    
    @PutMapping("/reject/{id}")
    public LeaveRequest rejectLeave(@PathVariable int id) {
        return leaveService.rejectLeave(id);
    }
}
