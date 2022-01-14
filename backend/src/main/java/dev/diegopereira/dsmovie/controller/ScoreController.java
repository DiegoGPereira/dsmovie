package dev.diegopereira.dsmovie.controller;

import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dev.diegopereira.dsmovie.dto.MovieDTO;
import dev.diegopereira.dsmovie.dto.ScoreDTO;
import dev.diegopereira.dsmovie.service.ScoreService;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping(value = "/scores")
@RequiredArgsConstructor
public class ScoreController {
	
	private final ScoreService scoreService;
	
	@PutMapping
	public MovieDTO saveScore(@RequestBody ScoreDTO scoreDTO) {
		return new MovieDTO(scoreService.saveScore(scoreDTO));
	}
	
}
