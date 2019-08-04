package com.moa.mybatis;

import java.util.Map;

public interface TransactionMapper {
    boolean updateState(Map<String, Object> map);
}
