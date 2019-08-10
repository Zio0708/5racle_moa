package com.moa.model.dao;

import com.moa.model.vo.SimpleStorageAddressVO;
import com.moa.model.vo.StoreBoardFormVO;
import com.moa.mybatis.StoreBoardMapper;
import lombok.NoArgsConstructor;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
import sun.java2d.pipe.SpanShapeRenderer;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

@Repository
@NoArgsConstructor
public class StoreBoardDAOImpl implements StoreBoardDAO {
    @Autowired
    @Qualifier("sqlSession_oracle")
    private SqlSession sqlSession_oracle;

    /*init*/
    @Override
    public List<SimpleStorageAddressVO> selectStorageAddress(String hostId) {
        StoreBoardMapper mapper = sqlSession_oracle.getMapper(StoreBoardMapper.class);
        List<SimpleStorageAddressVO> storage = mapper.selectStorages(Integer.parseInt(hostId));
        return storage;
    }
    @Override
    public List<String> selectTransaction() {
        StoreBoardMapper mapper = sqlSession_oracle.getMapper(StoreBoardMapper.class);
        List<String> transactionList = mapper.selectTransaction();
        return transactionList;
    }
    @Override
    public List<String> selectCategory() {
        StoreBoardMapper mapper = sqlSession_oracle.getMapper(StoreBoardMapper.class);
        List<String> categoryList = mapper.selectCategory();
        return categoryList;
    }
    @Override
    public List<String> selectStoragePeriod() {
        StoreBoardMapper mapper = sqlSession_oracle.getMapper(StoreBoardMapper.class);
        List<String> periodList = mapper.selectStoragePeriod();
        return periodList;
    }
    @Override
    public List<String> selectPrice() {
        StoreBoardMapper mapper = sqlSession_oracle.getMapper(StoreBoardMapper.class);
        List<String> priceList = mapper.selectPrice();
        return priceList;
    }

    @Override
    public int insert(StoreBoardFormVO storeBoardFormVO) {
        StoreBoardMapper mapper = sqlSession_oracle.getMapper(StoreBoardMapper.class);
        int i, articleNum, transaction, cctv, storagePeriod, categoryId;
        String pet = null;
        Map<String, Object> parameters = new HashMap<>();  // 전송용
        Map<String, Object> result = null;      // return 용

        /*selectParameters*/
        parameters.put("transaction", storeBoardFormVO.getTransactionType());
        parameters.put("cctv", storeBoardFormVO.getCctv());
        parameters.put("storagePeriod", storeBoardFormVO.getStoragePeriodType());

        result = mapper.selectParameters(parameters);
        articleNum = ((BigDecimal) result.get("NEXTVAL")).intValue();
        transaction = ((BigDecimal) result.get("SR_TRANSACTION_TYPE_ID")).intValue();
        cctv = ((BigDecimal) result.get("SECURITY_FACILITY_ID")).intValue();
        storagePeriod = ((BigDecimal) result.get("STORAGE_PERIOD_TYPE_ID")).intValue();

        /*insertIntoStoreBoard*/
        parameters.clear();
        parameters.put("articleNum", articleNum);
        parameters.put("hostId", storeBoardFormVO.getHostId());
        parameters.put("storagePeriod", storagePeriod);
        parameters.put("transaction", transaction);
        parameters.put("title", storeBoardFormVO.getTitle());
        parameters.put("content", storeBoardFormVO.getContent());
        parameters.put("storageId", storeBoardFormVO.getStorageId());
        mapper.insertIntoStoreBoard(parameters);

        /*insertIntoPetType*/
        parameters.clear();
        pet = storeBoardFormVO.getPet();
        if(pet!=null) {
            parameters.put("articleNum", articleNum);
            parameters.put("pet", pet);
            mapper.insertIntoPetType(parameters);
        }

        /*insertIntoSF_SB*/
        parameters.clear();
        parameters.put("cctv", cctv);
        parameters.put("articleNum", articleNum);
        mapper.insertIntoSF_SB(parameters);

        /*insertIntoSBAttachedPicture*/
        parameters.clear();
        parameters.put("articleNum", articleNum);
        List<String> list = storeBoardFormVO.getPictureName();
        int length = list.size();
        for (i = 0; i < length; i++) {
            parameters.put("pictureName", list.get(i));
            mapper.insertIntoSBAttachedPicture(parameters);
        }

        /*insertIntoDetailPriceFibo*/
        parameters.clear();
        parameters.put("articleNum", articleNum);
        list = storeBoardFormVO.getPrice();
        length = list.size();
        for (i = 0; i < length; i++) {
            parameters.put("priceId", i + 1);
            String price = "";
            if(list.get(i).length()>3) {
                StringTokenizer tokenizer = new StringTokenizer(list.get(i), ",");
                while(tokenizer.hasMoreTokens()) {
                    price+=tokenizer.nextToken();
                }
            }
            parameters.put("price", price);
            mapper.insertIntoDetailPriceFibo(parameters);
        }

        /*insertIntoForbiddenProduct*/
        parameters.clear();
        parameters.put("articleNum", articleNum);
        list = storeBoardFormVO.getForbiddenCategoryList();
        List<String> list2 = storeBoardFormVO.getForbiddenProductList();
        length = list.size();
        for (i = 0; i < length; i++) {
            categoryId = mapper.selectCategoryId(list.get(0));
            parameters.put("categoryId", categoryId);
            parameters.put("productName", list2.get(i));
            mapper.insertIntoForbiddenProduct(parameters);
        }
        return articleNum;
    }

    @Override
    public int delete(int articleNum) {
        StoreBoardMapper mapper=sqlSession_oracle.getMapper(StoreBoardMapper.class);
        return mapper.deleteOne(articleNum);
    }
}
