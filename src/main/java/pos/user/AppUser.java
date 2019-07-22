package pos.user;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "AppUser")
public @Data class AppUser {

    @Id
    private String id;

    @Indexed(unique = true)
    private String userName;

    private String password;

}
