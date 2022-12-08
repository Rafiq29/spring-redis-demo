package com.herb.springredisdemo.repo;

import com.herb.springredisdemo.entity.MovieModel;
import org.springframework.data.repository.CrudRepository;

public interface MovieDao extends CrudRepository<MovieModel, String> {
}
