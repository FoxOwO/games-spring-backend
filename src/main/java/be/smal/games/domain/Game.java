package be.smal.games.domain;

import lombok.*;

import javax.persistence.*;

@Data
@Entity
@Builder(access = AccessLevel.PUBLIC)
@NoArgsConstructor
@AllArgsConstructor
public class Game {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "category_id")
    private Integer category_id;

    @Column(name = "difficulty_id")
    private Integer difficulty_id;

    @Column(nullable = false)
    private String game_name;

    @Column(nullable = false)
    private String editor;

    @Column(nullable = false)
    private String author;

    @Column(nullable = false)
    private int year_edition;

    @Column(nullable = false)
    private String age;

    @Column(nullable = false)
    private int min_players;

    @Column(nullable = false)
    private int max_players;

    private String play_duration;

    @Column(nullable = false)
    private double price;

    private String image;

    @Override
    public String toString() {
        return "Game{" +
                "id=" + id +
                ", category_id=" + category_id +
                ", difficulty_id=" + difficulty_id +
                ", game_name='" + game_name + '\'' +
                ", editor='" + editor + '\'' +
                ", author='" + author + '\'' +
                ", year_edition=" + year_edition +
                ", age='" + age + '\'' +
                ", min_players=" + min_players +
                ", max_players=" + max_players +
                ", play_duration='" + play_duration + '\'' +
                ", price=" + price +
                ", image='" + image + '\'' +
                '}';
    }
}
