package dev.fnt.spboot.holidays.persist.repo;

import org.springframework.data.repository.PagingAndSortingRepository;

import dev.fnt.spboot.holidays.persist.ent.Employee;
import dev.fnt.spboot.holidays.persist.repo.ext.ReflexSearchCustom;

public interface EmployeeRepo extends ReflexSearchCustom<Employee,Long>, PagingAndSortingRepository<Employee, Long> {}
