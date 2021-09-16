package com.mimehoo.hrm.company.dao;

import com.mimehoo.hrm.domain.company.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface DepartmentDao extends JpaRepository<Department, String>, JpaSpecificationExecutor<Department> {
}
