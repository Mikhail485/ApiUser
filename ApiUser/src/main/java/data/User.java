package data;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

@Accessors(chain = true)
@EqualsAndHashCode()
public class User {

    public User(){super();}
    public User(int id, String username, String firstName, String email, String password, String phone, int userStatus) {
        this.id = id;
        this.username = username;
        this.firstName = firstName;
        this.email = email;
        this.password = password;
        this.phone = phone;
        this.userStatus = userStatus;
    }

    @Setter
    @Getter
    public int id;
    @Setter
    @Getter
    public String username;
    @Setter
    @Getter
    public String firstName;

    @Setter
    @Getter
    public String email;
    @Setter
    @Getter
    public String password;
    @Setter
    @Getter
    public String phone;
    @Setter
    @Getter
    public int userStatus;

}
