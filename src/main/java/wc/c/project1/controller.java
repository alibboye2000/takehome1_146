/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package wc.c.project1;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author lenovo
 */
@Controller
public class controller {

    @RequestMapping("/input")
   // @ResponseBody
    public String inputdata(
            @RequestParam(value = "name") String name,
            @RequestParam(value = "price") String price,
            @RequestParam(value = "amount") String amount,
            Model courier
    ) {
        int nprice = Integer.parseInt(price);
        int namount = Integer.parseInt(amount);
        int sumpriceamount = nprice * namount;
        int discount = 0;
        int totalprice;
        
        if(sumpriceamount <= 10000){
            discount=0;
        }else if(sumpriceamount > 10000 && sumpriceamount <= 50000){
            discount=10;
        }else{
            discount=25;
        }
        
        totalprice = sumpriceamount - (discount * sumpriceamount / 100);
        
        courier.addAttribute("nameofpacket", name);
        courier.addAttribute("priceofproduct", price);
        courier.addAttribute("amountofproduct", amount);
        courier.addAttribute("discount", discount);
        courier.addAttribute("totalprice", totalprice);
        
        
        return "showdata";
    }

}
