package com.moa.model.dao;

import com.moa.model.vo.*;

public interface HostStorageDAO {
    boolean insertOriginHome(OriginHomeStorageVO originHomeStorageVO);
    boolean insertOriginCompany(OriginCompanyStorageVO originCompanyStorageVO);
    boolean insertOriginOther(OriginOtherStorageVO originOtherStorageVO);
    boolean insertNewHome(NewHomeStorageVO newHomeStorageVO);
    boolean insertNewCompany(NewCompanyStorageVO newCompanyStorageVO);
    boolean insertNewOther(NewOtherStorageVO newOtherStorageVO);
    HostReputationVO searchOne(int articleNum);
}
