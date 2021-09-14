package com.mimehoo.hrm.company.service.impl;

import com.mimehoo.hrm.common.utils.IdWorker;
import com.mimehoo.hrm.company.dao.CompanyDao;
import com.mimehoo.hrm.company.service.CompanyService;
import com.mimehoo.hrm.domain.company.Company;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CompanyServiceImpl implements CompanyService {
    @Autowired
    private CompanyDao companyDao;

    @Autowired
    private IdWorker idWorker;

    /**
     * 保存企业
     *
     * @param company
     */
    @Override
    public void add(Company company) {
        String id = idWorker.nextId() + "";
        company.setId(id);
        company.setAuditState("0");
        company.setState(1);
        companyDao.save(company);
    }

    /**
     * 更新企业
     *
     * @param company
     * @return
     */
    @Override
    public Company update(Company company) {
        return companyDao.save(company);
    }

    @Override
    public void deleteById(String id) {
        companyDao.deleteById(id);
    }

    @Override
    public Company findById(String id){
        return companyDao.findById(id).get();
    }

    @Override
    public List<Company> findAll() {
        return companyDao.findAll();
    }
}
