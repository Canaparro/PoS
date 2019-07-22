package pos.store;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Store")
public @Data class Store {

    @Id
    private String id;

    private String name;

}
