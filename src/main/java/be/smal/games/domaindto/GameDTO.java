package be.smal.games.domaindto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Builder
@AllArgsConstructor
public class GameDTO {

    private int id;
    private Integer category_id;
    private Integer difficulty_id;
    private String game_name;
    private String editor;
    private String author;
    private int year_edition;
    private String age;
    private int min_players;
    private int max_players;
    private String play_duration;
    private double price;
    private String image;

    public GameDTO(Integer category_id, Integer difficulty_id, String game_name, String editor, String author, int year_edition, String age, int min_players, int max_players, String play_duration, double price, String image) {
        this.category_id = category_id;
        this.difficulty_id = difficulty_id;
        this.game_name = game_name;
        this.editor = editor;
        this.author = author;
        this.year_edition = year_edition;
        this.age = age;
        this.min_players = min_players;
        this.max_players = max_players;
        this.play_duration = play_duration;
        this.price = price;
        this.image = image;
    }
}
