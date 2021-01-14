package seapps.abstraction.core.fasade;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import seapps.abstraction.core.dto.ComponentRequest;
import seapps.abstraction.core.dto.ComponentResponse;
import seapps.abstraction.core.dto.SimpleComponentRequest;
import seapps.abstraction.core.dto.SimpleComponentResponse;
import seapps.abstraction.core.security.AccessDeniedException;
import seapps.abstraction.core.security.SecurityManager;
import seapps.abstraction.core.service.ComponentOperationsService;
import seapps.abstraction.core.service.SimpleOperationsService;

@Service
@RequiredArgsConstructor
public class ComponentFasade {
    private final SimpleOperationsService simpleOperationsService;
    private final ComponentOperationsService componentOperationsService;
    private final SecurityManager securityManager;

    public ComponentResponse getComponent(Long id) throws AccessDeniedException {
        if (!securityManager.checkGrant("LOOK_COMPONENT", id))
            throw new AccessDeniedException();
        return new ComponentResponse(componentOperationsService.getComponent(id));
    }

    public SimpleComponentResponse addComponent(Long innerComponentId, SimpleComponentRequest data) throws AccessDeniedException {
        if (!securityManager.checkGrant("ADD_COMPONENT", innerComponentId))
            throw new AccessDeniedException();
        return new SimpleComponentResponse(componentOperationsService.addComponent(innerComponentId, data));
    }

    public SimpleComponentResponse updateComponent(Long id, ComponentRequest patch) throws AccessDeniedException {
        if (!securityManager.checkGrant("UPDATE_COMPONENT", id))
            throw new AccessDeniedException();
        return new SimpleComponentResponse(simpleOperationsService.updateComponent(id, patch));
    }

    public void deleteComponent(Long id) throws AccessDeniedException {
        if (!securityManager.checkGrant("DELETE_COMPONENT", id))
            throw new AccessDeniedException();
        simpleOperationsService.deleteComponent(id);
    }
}