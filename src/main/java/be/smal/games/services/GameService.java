package be.smal.games.services;

import be.smal.games.domain.Game;
import be.smal.games.domaindto.GameDTO;
import be.smal.games.repositories.GameJPARepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GameService {

    @Autowired
    GameJPARepository gameRepository;

    public Game findById(Integer id) {
        Optional<Game> game = gameRepository.findById(id);
        if (game.isPresent()) return game.get();

        return null;

    }

    public List<Game> findAll() {
        return gameRepository.findAll();
    }

    public Game save(GameDTO gameDTO) {
        Game game = new ModelMapper().map(gameDTO,Game.class);
        return gameRepository.save(game);
    }

    public void remove(Integer id) {
        gameRepository.delete(this.findById(id));
    }
}
