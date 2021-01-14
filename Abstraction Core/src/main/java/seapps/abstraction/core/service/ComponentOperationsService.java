package seapps.abstraction.core.service;

import seapps.abstraction.core.domain.Component;
import seapps.abstraction.core.dto.SimpleComponentRequest;

public interface ComponentOperationsService {
    Component getComponent(Long id);
    Component addComponent(Long innerComponentId, SimpleComponentRequest data);
}