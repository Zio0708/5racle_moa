package com.moa.mybatis;

import com.moa.model.vo.DetailOptionVO;
import com.moa.model.vo.EntrustResultSearchVO;
import com.moa.model.vo.EntrustSearchVO;

import java.util.List;

public interface StoreBoardMapper {

    List<EntrustSearchVO> searchEntrust(DetailOptionVO detail);
}
