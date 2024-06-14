package br.com.occurrence.api.infrastructure.mongodb.entity.commons;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class FormStep extends Step {

    //private Form form;

    @Override
    public Type getType() {
        return Type.FORM;
    }

}
