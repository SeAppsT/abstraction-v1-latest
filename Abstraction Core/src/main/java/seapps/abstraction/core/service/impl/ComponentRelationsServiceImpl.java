package seapps.abstraction.core.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import seapps.abstraction.core.domain.Component;
import seapps.abstraction.core.domain.Relation;
import seapps.abstraction.core.domain.type.RelationType;
import seapps.abstraction.core.dto.ComponentRequest;
import seapps.abstraction.core.dto.SimpleComponentRequest;
import seapps.abstraction.core.repository.ComponentRepository;
import seapps.abstraction.core.repository.RelationRepository;
import seapps.abstraction.core.service.ComponentOperationsService;
import seapps.abstraction.core.service.SimpleOperationsService;

import javax.persistence.EntityNotFoundException;

@Service
@RequiredArgsConstructor
public class ComponentRelationsServiceImpl implements ComponentOperationsService, SimpleOperationsService {

    private final ComponentRepository componentRepository;
    private final RelationRepository relationRepository;

    @Override
    public Component getComponent(Long id) {
        return componentRepository.findById(id).orElseThrow(EntityNotFoundException::new);
    }

    @Override
    public Component addComponent(Long innerComponentId, SimpleComponentRequest data) {
        Component component = data.cast(new Component());
        componentRepository.save(component);

        Relation relation = new Relation();
        relation.setInnerComponent(component);
        relation.setOuterComponent(
                componentRepository.findById(innerComponentId)
                        .orElseThrow(EntityNotFoundException::new));
        relation.setType(RelationType.ABSTRACTION);
        relationRepository.save(relation);
        return component;
    }

    @Override
    public Component updateComponent(Long id, ComponentRequest patch) {
        Component component = componentRepository.findById(id).orElseThrow(EntityNotFoundException::new);
        patch.cast(component);
        componentRepository.save(component);
        return component;
    }

    @Override
    public void deleteComponent(Long id) {
        if (componentRepository.existsById(id))
            componentRepository.deleteById(id);
        else
            throw new EntityNotFoundException();
    }

    @Override
    public void deleteRelation(Long id) {

    }
}