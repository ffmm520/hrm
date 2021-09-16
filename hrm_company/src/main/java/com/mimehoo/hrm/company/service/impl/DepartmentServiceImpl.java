package com.mimehoo.hrm.company.service.impl;

import com.mimehoo.hrm.common.service.BaseService;
import com.mimehoo.hrm.common.utils.IdWorker;
import com.mimehoo.hrm.company.dao.DepartmentDao;
import com.mimehoo.hrm.company.service.DepartmentService;
import com.mimehoo.hrm.domain.company.Department;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentServiceImpl extends BaseService<Department> implements DepartmentService{

    @Autowired
    private DepartmentDao departmentDao;

    @Autowired
    private IdWorker idWorker;
    /**
     * 根据 id 查询部门
     *
     * @param id
     */
    @Override
    public Department findById(String id) {
        return departmentDao.findById(id).get();
    }

    /**
     * 查询全部部门
     * 根据companyId 来查询
     */
    @Override
    public List<Department> findAll(String companyId) {
        // 条件构造，根据 companyId 来查询
        // Specification<Department> specification = (root, criteriaQuery, cb) -> cb.equal(root.get("companyId").as(String.class), companyId);
        // 调用父类的getSpec方法来获得 查询条件
        return departmentDao.findAll(getSpec(companyId));
    }

    /**
     * 新增部门
     *
     * @param department
     */
    @Override
    public void add(Department department) {
        department.setId(idWorker.nextId()+"");
        departmentDao.save(department);
    }

    /**
     * 修改部门
     *
     * @param department
     */
    @Override
    public Department update(Department department) {
        Department dbDepartment = departmentDao.findById(department.getId()).get();
        dbDepartment.setCode(department.getCode());
        dbDepartment.setIntroduce(department.getIntroduce());
        dbDepartment.setName(department.getName());
        return departmentDao.save(department);
    }

    /**
     * 删除部门
     *
     * @param id
     */
    @Override
    public void delete(String id) {
        departmentDao.deleteById(id);
    }
}
