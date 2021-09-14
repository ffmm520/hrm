package com.mimehoo.hrm.company.controller;

import com.mimehoo.hrm.common.entity.Result;
import com.mimehoo.hrm.company.service.CompanyService;
import com.mimehoo.hrm.domain.company.Company;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("company")
public class CompanyController {

    @Autowired
    private CompanyService companyService;

    /**
     * 根据id 查询
     * @param id id
     * @return Result
     */
    @GetMapping("/{id}")
    public Result findById(@PathVariable("id") String id) {
        Company company = companyService.findById(id);
        Result result = Result.SUCCESS();
        result.setData(company);
        return result;
    }

    /**
     * 查询全部
     * @return companyList
     */
    @GetMapping()
    public Result findAll(){
        List<Company> companyList = companyService.findAll();
        Result result = Result.SUCCESS();
        result.setData(companyList);
        return result;
    }

    // 新增企业
    @PostMapping
    public Result add(@RequestBody Company company) {
        companyService.add(company);
        return Result.SUCCESS();
    }

    /**
     * 更新企业信息
     * @param id id
     * @param company 更新信息
     * @return 更新后的信息
     */
    @PutMapping("/{id}")
    public Result update(@PathVariable("id") String id, @RequestBody Company company){
        Company dbCompany = companyService.findById(id);
        BeanUtils.copyProperties(company,dbCompany);
        dbCompany.setId(id);
        Company updatedCompany = companyService.update(dbCompany);
        Result result = Result.SUCCESS();
        result.setData(updatedCompany);
        return result;
    }

    /**
     * 根据 id 删除企业信息
     * @param id 企业id
     * @return result
     */
    @DeleteMapping("/{id}")
    public Result delete(@PathVariable("id")String id){
        companyService.deleteById(id);
        return Result.SUCCESS();
    }
}
