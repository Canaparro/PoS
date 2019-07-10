package pos.customer;

import com.mongodb.lang.Nullable;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.CompoundIndex;
import org.springframework.data.mongodb.core.index.CompoundIndexes;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import pos.posts.Post;

import java.io.Serializable;
import java.util.List;

@Document(collection = "Customer")
@CompoundIndexes({
        @CompoundIndex(name = "firstName_lastName", def = "{'firstName' : 1, 'lastName' : 1}", unique = true)
})
public class Customer implements Serializable {

    @Id
    private String id;

    private String firstName;

    private String lastName;

    @DBRef
    private List<Post> posts;

    public Customer() {
        super();
    }

    public Customer(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public List<Post> getPosts() {
        return posts;
    }

    public void setPosts(List<Post> posts) {
        this.posts = posts;
    }
}
