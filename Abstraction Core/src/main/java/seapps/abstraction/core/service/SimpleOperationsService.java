package seapps.abstraction.core.service;

import seapps.abstraction.core.domain.Component;
import seapps.abstraction.core.dto.ComponentRequest;

public interface SimpleOperationsService {
    Component updateComponent(Long id, ComponentRequest patch);
    void deleteComponent(Long id);
    void deleteRelation(Long id);
}