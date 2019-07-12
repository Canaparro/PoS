package pos.order;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import pos.product.Product;

import java.io.Serializable;
import java.util.List;


@Document(collection = "Order")
@AllArgsConstructor
@Getter
@Setter
public class Order implements Serializable {

    @Id
    private String id;

    private List<Product> products;
}
