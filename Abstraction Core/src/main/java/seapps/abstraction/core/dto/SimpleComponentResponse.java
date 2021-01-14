package seapps.abstraction.core.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import seapps.abstraction.core.domain.Component;

@Getter
@Setter
@NoArgsConstructor
public class SimpleComponentResponse {

    protected Long id;
    protected String title;
    protected String text;
    protected String color;

    public SimpleComponentResponse(Component component){
        id = component.getId();
        title = component.getTitle();
        text = component.getText();
        color = component.getColor();
    }
}