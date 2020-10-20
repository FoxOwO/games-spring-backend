package be.smal.games.rest;

import be.smal.games.domaindto.GameDTO;
import be.smal.games.services.GameService;
import be.smal.games.domain.Game;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/game")
public class GameController {

    @Autowired
    GameService gameService;

    /*@GetMapping()
    public Iterable<Game> getGames(Principal principal){
        //messing with security
        System.out.println(principal.getName());
        return gameService.findAll();
    }*/

    @GetMapping("/{id}")
    public Game getGame(@PathVariable Integer id){
        return gameService.findById(id);
    }

    @GetMapping
    public List<Game> categories(){
        return gameService.findAll();
    }

    @PostMapping(path = "")
    public Game saveCategory(@RequestBody GameDTO gameDTO) {
        return gameService.save(gameDTO);
    }

    @DeleteMapping("/{id}")
    public void remove(@PathVariable Integer id) {
        System.out.println("trying to delete game with id: "+id);
        gameService.remove(id);
    }
}
