package com.qf.sc.manage.service.impl;

import com.qf.api.ItemService;
import com.qf.entity.TbItem;
import com.qf.entity.TbItemDesc;
import com.qf.mapper.TbItemDescMapper;
import com.qf.mapper.TbItemMapper;
import common.AppException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import result.AppResult;

import java.util.Date;

@Service
public class ItemServiceImpl implements ItemService {
    @Autowired
    private TbItemMapper tbItemMapper;
    @Autowired
    private TbItemDescMapper  tbItemDescMapper;
    @Override
    public AppResult addItem(TbItem item) {
        System.out.println(1);
        int count=tbItemMapper.insertSelective(item);
        System.out.println(2);
        System.out.println(item.getItemDesc());
        TbItemDesc tbesc=new TbItemDesc();
        tbesc.setItemId(item.getId());
        tbesc.setItemDesc(item.getItemDesc());
        tbesc.setCreated(new Date());
        tbesc.setUpdated(new Date());
        tbItemDescMapper.insertSelective(tbesc);
        if(count<1){
            throw  new AppException(201,"添加失败");
        }

        return new AppResult(true,200,"添加成功",item);
    }
}
