package com.mimehoo.hrm.company.service;

import com.mimehoo.hrm.domain.company.Company;

import java.util.List;

public interface CompanyService {
    /**
     * 保存企业
     */
    void add(Company company);

    /**
     * 更新企业
     * @return
     */
    Company update(Company company);

    void deleteById(String id);

    Company findById(String id);

    List<Company> findAll();

    // 删除企业

// 根据id查询企业

// 查询全部企业
}
