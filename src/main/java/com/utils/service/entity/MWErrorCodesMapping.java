/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.utils.service.entity;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @author abdelrahman ahmed
 */
@Getter
@Setter
@ToString
@Entity
@Table(name = "MW_Error_Codes_Mapping", catalog = "", schema = "")
public class MWErrorCodesMapping implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Long id;
    @Column(name = "MW_Error_Code")
    private String mwErrorCode;
    @Column(name = "MW_Error_Desc")
    private String mwErrorDesc;
    @Column(name = "BE_Error_Code")
    private String beErrorCode;
    @Column(name = "BE_Error_Desc")
    private String beErrorDesc;
    @Column(name = "BE_Name")
    private String beName;

    public MWErrorCodesMapping() {
    }

}
