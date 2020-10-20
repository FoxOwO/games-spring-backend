package be.smal.games.domain;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Builder(access = AccessLevel.PUBLIC)
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Category implements Serializable {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String category_name;


    @Override
    public String toString() {
        return "Category{" +
                "id=" + id +
                ", category_name='" + category_name + '\'' +
                '}';
    }
}
