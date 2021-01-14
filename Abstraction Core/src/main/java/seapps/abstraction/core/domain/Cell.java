package seapps.abstraction.core.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "cells")
@Getter
@Setter
public class Cell extends BaseEntity{
    private Integer coordX;
    private Integer coordY;

    @ManyToOne(fetch = FetchType.LAZY)
    private Relation relation;
}