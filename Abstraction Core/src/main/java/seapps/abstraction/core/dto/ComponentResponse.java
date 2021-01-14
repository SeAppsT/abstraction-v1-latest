package seapps.abstraction.core.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import seapps.abstraction.core.domain.Component;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class ComponentResponse extends SimpleComponentResponse{

    protected List<SimpleComponentResponse> innerComponents = new ArrayList<>();
    protected List<SimpleComponentResponse> outerComponents = new ArrayList<>();

    public ComponentResponse(Component component){
        super(component);
        component.getInnerRelations().forEach(relation -> {
            innerComponents.add(new SimpleComponentResponse(relation.getInnerComponent()));
        });

        component.getOuterRelations().forEach(relation -> {
            outerComponents.add(new SimpleComponentResponse(relation.getOuterComponent()));
        });
    }
}