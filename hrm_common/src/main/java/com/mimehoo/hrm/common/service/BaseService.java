package com.mimehoo.hrm.common.service;

import org.springframework.data.jpa.domain.Specification;

/**
 * 公共 service
 */
public class BaseService<T> {
    /**
     * 获取companyId
     * @param companyId companyId
     * @return spec
     */
    protected Specification<T> getSpec(String companyId){
        return (root, criteriaQuery, cb) -> cb.equal(root.get("companyId").as(String.class), companyId);
    }
}
