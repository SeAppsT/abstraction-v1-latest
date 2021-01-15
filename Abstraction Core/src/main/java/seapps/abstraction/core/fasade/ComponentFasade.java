package seapps.abstraction.core.fasade;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import seapps.abstraction.core.dto.ComponentRequest;
import seapps.abstraction.core.dto.ComponentResponse;
import seapps.abstraction.core.dto.SimpleComponentRequest;
import seapps.abstraction.core.dto.SimpleComponentResponse;
import seapps.abstraction.core.repository.AccessedUserRepository;
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
//  private final AccessedUserRepository repository;

//    @PostConstruct
//    private void init(){
//        AccessedUser user = new AccessedUser();
//        user.setId(UUID.randomUUID());
//        user.setToken("6muf6um56756r56m57mff");
//        repository.save(user);
//    }

    public ComponentResponse getComponent(Long id) throws AccessDeniedException {
        if (!securityManager.checkGrant("LOOK_COMPONENT", id)) {
            throw new AccessDeniedException("Privilege 'LOOK_COMPONENT' required for this action");
        }
        return new ComponentResponse(componentOperationsService.getComponent(id));
    }

    public SimpleComponentResponse addComponent(Long innerComponentId, SimpleComponentRequest data) throws AccessDeniedException {
        if (!securityManager.checkGrant("ADD_COMPONENT", innerComponentId))
            throw new AccessDeniedException("Privilege 'ADD_COMPONENT' required for this action");
        return new SimpleComponentResponse(componentOperationsService.addComponent(innerComponentId, data));
    }

    public SimpleComponentResponse updateComponent(Long id, ComponentRequest patch) throws AccessDeniedException {
        if (!securityManager.checkGrant("UPDATE_COMPONENT", id))
            throw new AccessDeniedException("Privilege 'UPDATE_COMPONENT' required for this action");
        return new SimpleComponentResponse(simpleOperationsService.updateComponent(id, patch));
    }

    public void deleteComponent(Long id) throws AccessDeniedException {
        if (!securityManager.checkGrant("DELETE_COMPONENT", id))
            throw new AccessDeniedException("Privilege 'DELETE_COMPONENT' required for this action");
        simpleOperationsService.deleteComponent(id);
    }
}