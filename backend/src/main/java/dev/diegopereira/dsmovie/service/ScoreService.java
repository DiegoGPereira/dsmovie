package dev.diegopereira.dsmovie.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import dev.diegopereira.dsmovie.domain.Movie;
import dev.diegopereira.dsmovie.domain.Score;
import dev.diegopereira.dsmovie.domain.User;
import dev.diegopereira.dsmovie.dto.ScoreDTO;
import dev.diegopereira.dsmovie.repository.MovieRepository;
import dev.diegopereira.dsmovie.repository.ScoreRepository;
import dev.diegopereira.dsmovie.repository.UserRepository;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class ScoreService {

	private final MovieRepository movieRepository;
	private final UserRepository userRepository;
	private final ScoreRepository scoreRepository;

	@Transactional
	public Movie saveScore(ScoreDTO dto) {
		User user = this.userRepository.findByEmail(dto.getEmail());

		if (user == null) {
			user = User.builder().email(dto.getEmail()).build();
			user = this.userRepository.saveAndFlush(user);
		}

		Movie movie = this.movieRepository.findById(dto.getMovieId()).get();

		Score score = Score.builder().movie(movie).user(user).value(dto.getScore()).build();

		score = this.scoreRepository.saveAndFlush(score);

		double movieScoreSum = 0.0;

		for (Score s : movie.getScores()) {
			movieScoreSum = movieScoreSum + s.getValue();
		}

		double movieScoreAvg = movieScoreSum / movie.getScores().size();
		movie.setScore(movieScoreAvg);
		movie.setCount(movie.getScores().size());

		return this.movieRepository.save(movie);
	}

}
