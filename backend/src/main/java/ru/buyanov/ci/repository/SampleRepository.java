package ru.buyanov.ci.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.buyanov.ci.model.Sample;

public interface SampleRepository extends JpaRepository<Sample, Integer> {
}
