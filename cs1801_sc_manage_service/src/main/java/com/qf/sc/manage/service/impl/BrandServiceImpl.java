package com.qf.sc.manage.service.impl;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.qf.api.BrandService;
import com.qf.entity.TbBrand;
import com.qf.mapper.TbBrandMapper;
import common.AppException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import result.AppResult;
import result.PageResult;

import java.util.List;
@Service
@Transactional
public class BrandServiceImpl implements BrandService {
    @Autowired
    private TbBrandMapper brandMapper;

    @Override
    @Transactional(propagation = Propagation.SUPPORTS,readOnly = true)
    public AppResult findall() {

        return new AppResult(true,200,"success",brandMapper.selectByExample(null));
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS,readOnly = true)
    public AppResult findAllBrandPagging(int pageno,int size) {
        PageHelper.startPage(pageno,size);
        List<TbBrand> list=brandMapper.selectByExample(null);
        PageInfo<TbBrand> model=new PageInfo<>(list);
        PageResult<TbBrand> result=new PageResult<>(model.getTotal(),model.getList());

        return  new AppResult(true,200,"null",result);
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS,readOnly = true)
    public AppResult AddBrand(TbBrand brand) {
        int count=brandMapper.insertSelective(brand);
        if(count<1){
             throw  new AppException(201,"添加失败");
        }
        return new AppResult(true,200,"添加品牌成功",brand);
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS,readOnly = true)
    public AppResult UpdBrand(TbBrand brand) {
        int count=brandMapper.updateByPrimaryKeySelective(brand);
        if(count<1){
            throw  new AppException(201,"更新失败");
        }
        return new AppResult(true,200,"更新品牌成功",brand);
    }

    @Override
    public AppResult delBatch(Long[] ids) {
        for (int i=0;i<ids.length;i++) {
             Long id=ids[i];
             int count=brandMapper.deleteByPrimaryKey(id);
             if(count<0){
                 throw  new  AppException(201,"删除失败");
             }
        }
        return new AppResult(true,200,"删除成功",null);
    }
}
