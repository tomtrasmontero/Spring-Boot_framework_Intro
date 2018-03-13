package com.example.springbootmonolith.repositories;

import com.example.springbootmonolith.models.Songs;
import org.springframework.data.repository.CrudRepository;

public interface SongRepository extends CrudRepository<Songs, Long> {

}