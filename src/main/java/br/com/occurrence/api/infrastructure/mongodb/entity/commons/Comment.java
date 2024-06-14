package br.com.occurrence.api.infrastructure.mongodb.entity.commons;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.UUID;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Comment {

    private String value;
    private LocalDateTime date;
    private UUID userId;

}
