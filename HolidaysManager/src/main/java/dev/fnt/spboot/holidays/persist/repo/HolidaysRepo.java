package dev.fnt.spboot.holidays.persist.repo;

import org.springframework.data.repository.PagingAndSortingRepository;

import dev.fnt.spboot.holidays.persist.ent.Holidays;

public interface HolidaysRepo extends PagingAndSortingRepository<Holidays, Long> {}
