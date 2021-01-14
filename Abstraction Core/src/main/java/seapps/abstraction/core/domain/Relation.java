package seapps.abstraction.core.domain;


import lombok.Getter;
import lombok.Setter;
import seapps.abstraction.core.domain.type.RelationType;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "relations")
@Getter
@Setter
public class Relation extends BaseEntity{

    private RelationType type;

    @ManyToOne(fetch = FetchType.LAZY)
    private Component innerComponent;

    @ManyToOne(fetch = FetchType.LAZY)
    private Component outerComponent;

}