package qian.ling.yi.seckill;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * TODO
 *
 * @date: 2019/6/11.
 * @author: guobin.liu@holaverse.com
 */

@Controller
public class Rush2PurchaseController {

    @GetMapping("seckill")
    @ResponseBody
    String seckill(@RequestParam("rowKey") String rowKey) {
        return "seckill";
    }
}
