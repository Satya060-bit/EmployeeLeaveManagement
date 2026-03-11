package EmployeeLeaveManagementApplication.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import EmployeeLeaveManagementApplication.entity.LeaveRequest;
import EmployeeLeaveManagementApplication.repository.LeaveRepository;

@Service
public class LeaveService {
	
	 @Autowired
	    private LeaveRepository leaveRepository;

	    public LeaveRequest requestLeave(LeaveRequest leave) {

	        leave.setStatus("Pending");
	        return leaveRepository.save(leave);
	    }

	    public List<LeaveRequest> getAllLeaves() {

	        return leaveRepository.findAll();
	    }
	    public LeaveRequest approveLeave(int id) {

	        LeaveRequest leave = leaveRepository.findById(id).get();
	        leave.setStatus("Approved");
	        return leaveRepository.save(leave);
	    }

	    public LeaveRequest rejectLeave(int id) {

	        LeaveRequest leave = leaveRepository.findById(id).get();
	        leave.setStatus("Rejected");
	        return leaveRepository.save(leave);
	    }

}
