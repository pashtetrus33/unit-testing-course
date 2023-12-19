package seminars.first.Shop;


import java.util.ArrayList;
import java.util.List;


import static org.assertj.core.api.Assertions.*;

public class ShopTest {

    /*
   1. Напишите тесты, чтобы проверить, что магазин хранит верный список продуктов (правильное количество продуктов, верное содержимое корзины).
   2. Напишите тесты для проверки корректности работы метода getMostExpensiveProduct.
   3. Напишите тесты для проверки корректности работы метода sortProductsByPrice (проверьте правильность сортировки).
   */

    public static void main(String[] args) {
        Shop shop = new Shop();
        List<Product> products = new ArrayList<>();
        Product meat = new Product(500, "Meat");
        Product fish = new Product(300, "Fish");
        Product bread = new Product(52, "Bread");
        Product milk = new Product(65, "Milk");
        products.add(meat);
        products.add(fish);
        products.add(bread);
        products.add(milk);

        shop.setProducts(products);

        assertThat(shop.getProducts()).isNotEmpty().hasSize(4).containsAll(products);
        assertThat(shop.getMostExpensiveProduct()).isEqualTo(meat);
        assertThat(shop.sortProductsByPrice()).containsSequence(bread, milk, fish, meat);

    }

}