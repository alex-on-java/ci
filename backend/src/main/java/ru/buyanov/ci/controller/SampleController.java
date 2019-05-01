package ru.buyanov.ci.controller;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import ru.buyanov.ci.model.Sample;

@RepositoryRestResource(collectionResourceRel = "samples", path = "samples")
public interface SampleController extends CrudRepository<Sample, Integer> {

}
