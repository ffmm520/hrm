package com.mimehoo.hrm.company.service;

import com.mimehoo.hrm.domain.company.Department;

import java.util.List;

public interface DepartmentService {
    /**
     * 根据 id 查询部门
     */
    Department findById(String id);


    /**
     * 查询全部部门
     */

    List<Department> findAll(String companyId);

    /**
     * 新增部门
     */

    void add(Department department);

    /**
     * 修改部门
     */

    Department update(Department department);

    /**
     * 删除部门
     */

    void delete(String id);
}
