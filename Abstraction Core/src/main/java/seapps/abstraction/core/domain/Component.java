package seapps.abstraction.core.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.List;

@Entity
@Table(name = "components")
@Getter
@Setter
public class Component extends BaseEntity{
    private String title;
    private String text;
    private String color;
    private String image;
    private String type;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "outerComponent")
    private List<Relation> innerRelations;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "innerComponent")
    private List<Relation> outerRelations;
}