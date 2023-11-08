package com.ticketgo.entity;

import java.math.BigDecimal;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author ${author}
 * @since 2023-11-08
 */
public class Item extends Model<Item> {

    private static final long serialVersionUID = 1L;

      @TableId(value = "item_id", type = IdType.AUTO)
    private Long itemId;

    private String itemName;

    private BigDecimal price;


    public Long getItemId() {
        return itemId;
    }

    public void setItemId(Long itemId) {
        this.itemId = itemId;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }


    @Override
    public String toString() {
        return "Item{" +
        "itemId=" + itemId +
        ", itemName=" + itemName +
        ", price=" + price +
        "}";
    }
}
