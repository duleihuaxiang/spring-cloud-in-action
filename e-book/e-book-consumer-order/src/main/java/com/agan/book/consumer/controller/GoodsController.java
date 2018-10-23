package com.agan.book.consumer.controller;

import com.agan.book.consumer.service.OrderService;
import com.agan.book.consumer.service.ProductService;
import com.agan.book.consumer.service.TradeService;
import com.agan.book.consumer.service.UserService;
import com.agan.book.order.domain.Goods;
import com.agan.book.order.domain.Order;
import com.agan.book.product.domain.Product;
import com.agan.book.trade.domain.Trade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController
public class GoodsController {
	


	@RequestMapping(value = "/goods", method = RequestMethod.GET)
	public List<Goods> getGoods()  {


		List<Goods> goodsList = new ArrayList<Goods>();
		Goods goods = new Goods();
		goods.setGoodsId(1);
		goods.setGoodsName("红茶");
		goods.setGoodsTitle("汇源红茶");
		goods.setGoodsPrice(2000);
		goodsList.add(goods);
		return goodsList;
	}


}
