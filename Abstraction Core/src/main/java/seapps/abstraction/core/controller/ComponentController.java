package seapps.abstraction.core.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import seapps.abstraction.core.dto.ComponentRequest;
import seapps.abstraction.core.dto.ComponentResponse;
import seapps.abstraction.core.dto.SimpleComponentRequest;
import seapps.abstraction.core.dto.SimpleComponentResponse;
import seapps.abstraction.core.fasade.ComponentFasade;
import seapps.abstraction.core.security.AccessDeniedException;

@RestController
@RequestMapping("/components")
@RequiredArgsConstructor
public class ComponentController {
    private final ComponentFasade componentFasade;

    @GetMapping("/{id}")
    public ComponentResponse get(@PathVariable Long id) throws AccessDeniedException {
        return componentFasade.getComponent(id);
    }

    @PostMapping("/{innerComponentId}")
    public SimpleComponentResponse add(@PathVariable Long innerComponentId, @RequestBody SimpleComponentRequest data) throws AccessDeniedException {
        return componentFasade.addComponent(innerComponentId, data);
    }

    @PatchMapping("/{id}")
    public SimpleComponentResponse update(@PathVariable Long id, @RequestBody ComponentRequest patch) throws AccessDeniedException {
        return componentFasade.updateComponent(id, patch);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) throws AccessDeniedException {
        componentFasade.deleteComponent(id);
    }
}