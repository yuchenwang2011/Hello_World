package cn.itheima.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import cn.itheima.pojo.Items;

@Controller
public class ItemsController {
	
	@RequestMapping("/list")
	//This will enable visiting localhost:8080/SpringMVC01/list.action
	public ModelAndView itemsList() {
		List<Items>itemList = new ArrayList<>();
		
		//商品列表
		Items items_1 = new Items();
		items_1.setName("Laptop");
		items_1.setPrice(6000f);
		items_1.setDetail("ThinkPad T430");
		
		Items items_2 = new Items();
		items_2.setName("Iphone");
		items_2.setPrice(5000f);
		items_2.setDetail("iphone6 Phone");
		
		itemList.add(items_1);
		itemList.add(items_2);

		ModelAndView mv = new ModelAndView();
		mv.addObject("itemList", itemList);
		mv.setViewName("/WEB-INF/jsp/itemList.jsp");
		return mv;
	}
}
