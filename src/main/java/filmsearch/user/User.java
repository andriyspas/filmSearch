package filmsearch.user;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Created by Stas on 30-Nov-16.
 */
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "user_account")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Getter
    @Setter
    private Long id;

    @Getter
    @Setter
    private String username;

    @Getter
    @Setter
    private String firstName;

    @Getter
    @Setter
    private String lastName;

    @Getter
    @Setter
    private String email;

    @Getter
    @Setter
    @Column(length = 60)
    private String password;

    @Getter
    @Setter
    private boolean enabled;


    /*@Getter
    @Setter
    @ElementCollection(targetClass = UserRoles.class)
    @Enumerated(EnumType.STRING)
    private List<UserRoles> roles;


    public List<String> getRolesAsStrings(){
        List<String> roleList = new ArrayList<>();

        roles.forEach(userRole -> roleList.add(userRole.name()));

        return roleList;
    }*/
}
