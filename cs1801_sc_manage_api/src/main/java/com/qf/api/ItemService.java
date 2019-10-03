package com.qf.api;

import com.qf.entity.TbItem;
import com.qf.entity.TbItemDesc;
import result.AppResult;

public interface ItemService {

    AppResult addItem(TbItem item);
}
