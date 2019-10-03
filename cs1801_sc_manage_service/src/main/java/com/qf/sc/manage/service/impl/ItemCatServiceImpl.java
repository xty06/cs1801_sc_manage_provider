package com.qf.sc.manage.service.impl;

import com.qf.api.ItemCatService;
import com.qf.entity.TbItemCat;
import com.qf.entity.TbItemCatExample;
import com.qf.mapper.TbItemCatMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import result.AppResult;

import java.util.List;

@Service
public class ItemCatServiceImpl implements ItemCatService {
    @Autowired
    private TbItemCatMapper itemCatMapper;
    @Override
    public AppResult findallCats(Long pid) {
        TbItemCatExample example=new TbItemCatExample();
        example.createCriteria().andParentIdEqualTo(pid);
        List<TbItemCat> list=itemCatMapper.selectByExample(example);
        return new AppResult(true,200,null,list);
    }
}
