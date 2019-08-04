package com.moa.model.dao;

import com.moa.model.vo.DetailOptionVO;
import com.moa.model.vo.EntrustResultSearchVO;
import com.moa.model.vo.EntrustSearchVO;

import java.util.List;

public interface StoreBoardDAO {
    List<EntrustSearchVO> searchEntrust(DetailOptionVO detail);
}
