package seapps.abstraction.core.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "grants")
@Getter
@Setter
public class Grant extends BaseEntity{
    private String name;

    @ManyToOne
    private Component component;

    @ManyToOne
    private AccessedUser user;
}