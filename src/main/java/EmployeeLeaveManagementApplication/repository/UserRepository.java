package EmployeeLeaveManagementApplication.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import EmployeeLeaveManagementApplication.entity.User;

public interface UserRepository extends JpaRepository<User,Integer>{

       User findByEmailAndPassword(String email,String password);

}
