package com.agan.book.order.domain;

import java.io.Serializable;
import java.math.BigDecimal;

public class Goods
     implements Serializable

    {
        /**
         *
         */
        private static final long serialVersionUID = 1L;

        private Integer id;

        private Integer goodsId;

        private String goodsName;

        private String goodsTitle;

        private Integer goodsPrice;

        public Integer getId() {
            return id;
        }

        public void setId(Integer id) {
            this.id = id;
        }

        public Integer getGoodsId() {
            return goodsId;
        }

        public void setGoodsId(Integer goodsId) {
            this.goodsId = goodsId;
        }

        public String getGoodsName() {
            return goodsName;
        }

        public void setGoodsName(String goodsName) {
            this.goodsName = goodsName;
        }

        public String getGoodsTitle() {
            return goodsTitle;
        }

        public void setGoodsTitle(String goodsTitle) {
            this.goodsTitle = goodsTitle;
        }

        public Integer getGoodsPrice() {
            return goodsPrice;
        }

        public void setGoodsPrice(Integer goodsPrice) {
            this.goodsPrice = goodsPrice;
        }
    }
