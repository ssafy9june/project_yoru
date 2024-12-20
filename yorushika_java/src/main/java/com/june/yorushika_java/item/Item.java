package com.june.yorushika_java.item;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.util.StringUtils;

@Entity
@ToString
@Getter
@Setter
public class Item {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String title;
    private Integer price;

    private String writer;

    public boolean isValid() {
        return StringUtils.hasText(this.title) &&
                this.price != null &&
                this.price > 0 &&
                StringUtils.hasText(this.writer);
    }
}
