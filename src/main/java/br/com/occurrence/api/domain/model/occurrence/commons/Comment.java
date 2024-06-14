package br.com.occurrence.api.domain.model.occurrence.commons;

import br.com.occurrence.api.domain.model.organization.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Comment {

    private String text;
    private LocalDateTime date;
    private User user;

}
