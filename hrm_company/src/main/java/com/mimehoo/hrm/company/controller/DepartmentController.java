package com.mimehoo.hrm.company.controller;

import com.mimehoo.hrm.common.controller.BaseController;
import com.mimehoo.hrm.common.entity.Result;
import com.mimehoo.hrm.common.entity.ResultCode;
import com.mimehoo.hrm.company.service.CompanyService;
import com.mimehoo.hrm.company.service.DepartmentService;
import com.mimehoo.hrm.domain.company.Company;
import com.mimehoo.hrm.domain.company.Department;
import com.mimehoo.hrm.domain.company.response.DepartmentList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/company/department")
public class DepartmentController extends BaseController {

    @Autowired
    private DepartmentService departmentService;

    @Autowired
    private CompanyService companyService;

    @GetMapping("/{id}")
    public Result findById(@PathVariable("id") String id) {
        Department department = departmentService.findById(id);
        return new Result(ResultCode.SUCCESS, department);
    }

    @GetMapping
    public Result findAll() {
        // String companyId = "1";
        Company company = companyService.findById(super.companyId);
        List<Department> departmentList = departmentService.findAll(super.companyId);
        DepartmentList list = new DepartmentList(company, departmentList);
        return new Result(ResultCode.SUCCESS, list);
    }

    @PostMapping
    public Result add(@RequestBody Department department) {
        department.setCompanyId(super.companyId);
        departmentService.add(department);
        return Result.SUCCESS();
    }

    @PutMapping("/{id}")
    public Result update(@PathVariable("id") String id, @RequestBody Department department) {
        department.setId(id);
        department.setCompanyId(super.companyId);
        Department updatedDept = departmentService.update(department);
        return new Result(ResultCode.SUCCESS, updatedDept);
    }

    @DeleteMapping("/{id}")
    public Result delete(@PathVariable("id") String id) {
        departmentService.delete(id);
        return Result.SUCCESS();
    }
}
