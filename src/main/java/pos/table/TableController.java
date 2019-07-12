package pos.table;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/table")
public class TableController {

    @Autowired
    private TableRepository tableRepository;

    @GetMapping("/name/{name}")
    public Table getTableByName(@PathVariable("name") String name) {
        return tableRepository.findByName(name);
    }

    @GetMapping
    public Table addTable(Table table) {
        return tableRepository.save(table);
    }
}
