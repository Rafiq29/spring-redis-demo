package com.herb.springredisdemo.service;

import com.herb.springredisdemo.entity.MovieModel;
import com.herb.springredisdemo.repo.MovieDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class MovieService {
    @Autowired
    private MovieDao movieDao;

    @PostConstruct
    private void init() {
        this.movieDao.save(new MovieModel("1", "Star Wars", MovieModel.FSK.FSK_12, Arrays.asList("Luke", "Darth Vader")));
        this.movieDao.save(new MovieModel("2", "Back to the Future", MovieModel.FSK.FSK_8, Arrays.asList("Doc", "Marty")));
    }

    public MovieModel getMovie(String key) {
        return movieDao.findById(key).orElse(null);
    }

    public List<MovieModel> getAllMovies() {
        return StreamSupport
                .stream(movieDao.findAll().spliterator(), false)
                .collect(Collectors.toList());
    }
}
