package qian.ling.yi.seckill.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import qian.ling.yi.seckill.mapper.TrdOrderMapper;
import qian.ling.yi.seckill.model.TrdOrder;
import qian.ling.yi.seckill.service.Rush2PurchaseService;

/**
 * TODO
 *
 * @date: 2019/6/11.
 * @author: guobin.liu@holaverse.com
 */
@Service
public class Rush2PurchaseServiceImpl implements Rush2PurchaseService  {
    @Autowired
    TrdOrderMapper trdOrderMapper;

    @Override
    public int add(TrdOrder trdOrder) {
//        return trdOrderMapper.insertSelective(trdOrder);
        return 1;
    }
}
