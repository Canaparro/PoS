package pos.table;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.CompoundIndex;
import org.springframework.data.mongodb.core.index.CompoundIndexes;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import pos.order.Order;

import java.io.Serializable;

@Document(collection = "Table")
@CompoundIndexes({
        @CompoundIndex(name = "store_table", def = "{'storeId' : 1, 'name' : 1}", unique = true)
})
public @Data class Table implements Serializable {

    @Id
    private String id;

    private String name;

    private String storeId;

    @DBRef
    private Order order;
}