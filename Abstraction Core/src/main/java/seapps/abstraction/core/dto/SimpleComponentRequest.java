package seapps.abstraction.core.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import seapps.abstraction.core.domain.Component;

@Getter
@Setter
@NoArgsConstructor
public class SimpleComponentRequest {

    protected String title;
    protected String text;
    protected String color;

    public Component cast(Component component){
        if (title != null)
            component.setTitle(title);
        if (text != null)
            component.setText(text);
        if (color != null)
            component.setColor(color);
        return component;
    }
}