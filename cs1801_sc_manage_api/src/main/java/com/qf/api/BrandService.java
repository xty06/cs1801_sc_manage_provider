package com.qf.api;

import com.qf.entity.TbBrand;
import result.AppResult;

import java.util.List;

public interface BrandService {

    AppResult findall();

    AppResult findAllBrandPagging(int  pageno,int size);

    AppResult AddBrand(TbBrand brand);

    AppResult UpdBrand(TbBrand brand);

    AppResult delBatch(Long[] ids );
}
