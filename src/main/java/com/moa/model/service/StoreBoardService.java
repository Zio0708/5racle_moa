package com.moa.model.service;

import java.util.Map;

public interface StoreBoardService {
    public Map<String,Object> selectStorage(int articleNum);
    boolean deleteStorage(int articleNum);
}
