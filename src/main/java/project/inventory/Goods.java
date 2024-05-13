//Food and non-food goods have different % overcharge, that is determined in the shop. If the expiry date is close,
//i.e. there are less than a given number of days to it, the selling price of the goods is decreased by given %.
//The number of the days to the expiration date and the decreasing % are different in each shop.
//Goods which expiry date is passes cannot be sold.
//Goods can be sold only if there is enough quantity of it in the shop.
// If the quantity is not enough, an appropriate exception has to be thrown.
// This exception has to show the quantity needed to sell the goods.


package project.inventory;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;


public class Goods{

    private long goods_id;
    private String goods_name;
    private double goods_delivery_price;
    private Category category;
    private LocalDate goods_expiry_date;
    private int goods_quantity;

    public Goods(long goods_id, String goods_name, double goods_delivery_price, Category category, LocalDate goods_expiry_date, int goods_quantity) {
        this.goods_id = goods_id;
        this.goods_name = goods_name;
        this.goods_delivery_price = goods_delivery_price;
        this.category = category;
        this.goods_expiry_date = goods_expiry_date;
        this.goods_quantity = goods_quantity;
    }

    public long getId() {
        return goods_id;
    }

    public String getName() {
        return goods_name;
    }

    public double getDelivery_price() {
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

    public void setQuantity(int goods_quantity) {
        if(goods_quantity > 0){
            //adding the goods to the cart/receipt
            this.goods_quantity = goods_quantity;
        }
        else {
            //method to not add something to the cart/receipt
            System.out.println("Quantity not enough");
        }
    }
    public double calculatingSellingPrice() {

        double selling_price = 0;
        //getting the overcharge percentage for the specific category
        double overcharge_percent = (this.category == Category.FOOD) ? Category.FOOD.getDefaultOverchargePercent() : Category.NON_FOOD.getDefaultOverchargePercent();

        selling_price = this.goods_delivery_price * (1 + (overcharge_percent / 100));


        long days_until_expiration = ChronoUnit.DAYS.between(LocalDate.now(), getExpiry_date());        //should be put in another method

        if (days_until_expiration > 0 && days_until_expiration <= 3) { // Considered close to expiration if less than or equal to 3 days left
            selling_price *= (1 - this.category.getDefaultOverchargePercent() / 100);

        }

        selling_price = Math.round(selling_price * 100.0) / 100.0; //should be put in another method and used in shop too!!!

        return selling_price;
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

