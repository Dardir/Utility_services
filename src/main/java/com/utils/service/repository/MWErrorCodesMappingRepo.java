package com.utils.service.repository;

import com.utils.service.entity.MWErrorCodesMapping;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MWErrorCodesMappingRepo extends JpaRepository<MWErrorCodesMapping,Long> {

    MWErrorCodesMapping findByBeNameAndAndBeErrorCode(String beName,String beErrorCode);

}
