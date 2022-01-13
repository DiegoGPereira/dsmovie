package dev.diegopereira.dsmovie.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import dev.diegopereira.dsmovie.domain.Movie;
import dev.diegopereira.dsmovie.dto.MovieDTO;
import dev.diegopereira.dsmovie.repository.MovieRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class MovieService {
	
	private final MovieRepository movieRepository;
	
	@Transactional(readOnly = true)
	public Page<MovieDTO> findAll(Pageable pageable) {
		 Page<Movie> result = this.movieRepository.findAll(pageable);
		 Page<MovieDTO> page = result.map(movies -> new MovieDTO(movies));
		 return page;
	}
	
	@Transactional(readOnly = true)
	public MovieDTO findById(Long id) {
		 Movie movie = this.movieRepository.findById(id).get();
		 return new MovieDTO(movie);
	}

}
