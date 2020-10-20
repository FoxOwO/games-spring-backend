package be.smal.games.repositories;

import be.smal.games.domain.Game;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface GameJPARepository extends JpaRepository<Game, Integer> {
    List<Game> findAll();
    Game save(Game game);
}
