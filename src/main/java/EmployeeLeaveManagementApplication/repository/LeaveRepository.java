package EmployeeLeaveManagementApplication.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import EmployeeLeaveManagementApplication.entity.LeaveRequest;

public interface LeaveRepository extends JpaRepository<LeaveRequest,Integer>{

}
