package com.mimehoo.hrm.domain.company;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "co_department")
public class Department implements Serializable {
    private static final long serialVersionUID = -9084332495284489553L;
    //ID
    @Id
    private String id;
    /**
     * 父级ID
     */
    @Column(name = "parent_id")
    private String pid;
    /**
     * 企业ID
     */
    private String companyId;
    /**
     * 部门名称
     */
    private String name;
    /**
     * 部门编码，同级部门不可重复
     */
    private String code;

    /**
     * 负责人ID
     */
    private String managerId;
    /**
     *  负责人名称
     */
    private String manager;

    /**
     * 介绍
     */
    private String introduce;
    /**
     * 创建时间
     */
    private Date createTime;
}
