//Food and non-food goods have different % overcharge, that is determined in the shop. If the expiry date is close,
//i.e. there are less than a given number of days to it, the selling price of the goods is decreased by given %.
//The number of the days to the expiration date and the decreasing % are different in each shop.
//Goods which expiry date is passes cannot be sold.
//Goods can be sold only if there is enough quantity of it in the shop.
// If the quantity is not enough, an appropriate exception has to be thrown.
// This exception has to show the quantity needed to sell the goods.


package project.inventory;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;


public class Goods extends GoodsSellingPriceCalculator implements Serializable {

    private long goods_id;
    private String goods_name;
    private BigDecimal goods_delivery_price;
    private Category category;
    private LocalDate goods_expiry_date;
    private int goods_quantity;
    private BigDecimal overchargePercentage;
    private SellingPriceCalculation sellingPriceCalculator;



    public Goods(long goods_id, String goods_name, BigDecimal goods_delivery_price, Category category, LocalDate goods_expiry_date, int goods_quantity, SellingPriceCalculation sellingPriceCalculator) {
        this.goods_id = goods_id;
        this.goods_name = goods_name;
        this.goods_delivery_price = goods_delivery_price;
        this.category = category;
        this.goods_expiry_date = goods_expiry_date;
        this.goods_quantity = goods_quantity;
        //this.overchargePercentage = overchargePercentage;
        this.sellingPriceCalculator = sellingPriceCalculator;
    }

    public long getId() {
        return goods_id;
    }

    public String getName() {
        return goods_name;
    }

    public BigDecimal getDelivery_price() {
        return goods_delivery_price;
    }

    public Category getCategory() {
        return category;
    }

    public LocalDate getExpiry_date() {
        return goods_expiry_date;
    }

    public int getQuantity() {
        return goods_quantity;
    }

    public BigDecimal getOverchargePercentage() {
        return overchargePercentage;
    }
    public BigDecimal calculateSellingPrice() {
        return sellingPriceCalculator.calculateSellingPrice(this);
    }

    public void setQuantity(int goods_quantity) {
        if(goods_quantity > 0){
            this.goods_quantity = goods_quantity;
        }
        else {
            //method to not add something to the cart/receipt
            System.out.println("Quantity not enough");
        }
    }

    @Override
    public String toString() {
        return "Goods{" +
                "goods_id=" + goods_id +
                ", goods_name='" + goods_name + '\'' +
                ", goods_delivery_price=" + goods_delivery_price +
                ", category=" + category +
                ", goods_expiry_date=" + goods_expiry_date +
                ", goods_quantity=" + goods_quantity +
                '}';
    }
}