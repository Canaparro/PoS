package pos.store;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import pos.employee.Employee;
import pos.table.Table;

import java.util.List;

@Document(collection = "Store")
@AllArgsConstructor @Getter @Setter
public class Store {

    @Id
    private String id;

    private String Name;

    @DBRef
    private List<Employee> employees;

    @DBRef
    private List<Table> tables;
}
