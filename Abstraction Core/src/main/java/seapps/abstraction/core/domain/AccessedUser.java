package seapps.abstraction.core.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "accessed_users")
@Getter
@Setter
@NoArgsConstructor
public class AccessedUser {
    @Id
    @GeneratedValue
    private UUID id;

    private String token;

    private String name;

    @OneToMany
    private List<Grant> grants = new ArrayList<>();
}