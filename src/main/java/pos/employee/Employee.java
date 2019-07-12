package pos.employee;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Employee")
@AllArgsConstructor @Getter @Setter
public class Employee {

    @Id
    private String id;

    private String firstName;

    private String lastName;
}
