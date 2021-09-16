package com.mimehoo.hrm.domain.company.response;

import com.mimehoo.hrm.domain.company.Company;
import com.mimehoo.hrm.domain.company.Department;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class DepartmentList {
    private String companyId;
    private String companyName;
    private String companyManage;
    private List<Department> dept;

    public DepartmentList(Company company, List<Department> list) {
        this.companyId = company.getId();
        this.companyName = company.getName();
        this.companyManage = company.getLegalRepresentative();
        this.dept = list;
    }

}
