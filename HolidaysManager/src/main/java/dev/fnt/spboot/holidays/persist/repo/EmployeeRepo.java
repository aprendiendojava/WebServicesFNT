package dev.fnt.spboot.holidays.persist.repo;

import org.springframework.data.repository.PagingAndSortingRepository;

import dev.fnt.spboot.holidays.persist.ent.Employee;
import dev.fnt.spboot.holidays.persist.repo.ext.CriteriaLike;

public interface EmployeeRepo extends CriteriaLike<Employee,Long>, PagingAndSortingRepository<Employee, Long> {}
