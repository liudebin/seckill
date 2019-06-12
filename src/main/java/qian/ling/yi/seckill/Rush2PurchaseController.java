package qian.ling.yi.seckill;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import qian.ling.yi.seckill.model.TrdOrder;
import qian.ling.yi.seckill.service.Rush2PurchaseService;

/**
 * TODO
 *
 * @date: 2019/6/11.
 * @author: guobin.liu@holaverse.com
 */

@RestController
public class Rush2PurchaseController {

    @Autowired
    Rush2PurchaseService rush2PurchaseService;

    @RequestMapping("seckill")
//    @ResponseBody
    int seckill(@RequestParam("productId") String productId) {
        TrdOrder trdOrder = new TrdOrder();
        trdOrder.setTrdNo("1");
        trdOrder.setRemark("test1");
        return rush2PurchaseService.add(trdOrder);
    }

}
