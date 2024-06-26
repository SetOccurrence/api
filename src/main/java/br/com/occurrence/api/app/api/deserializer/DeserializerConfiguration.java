package br.com.occurrence.api.app.api.deserializer;

import br.com.occurrence.api.app.api.dto.occurrence.commons.flow.FlowRegistryDto;
import br.com.occurrence.api.app.api.dto.occurrence.commons.form.answer.AnswerDto;
import br.com.occurrence.api.app.api.dto.occurrence.commons.form.question.QuestionDto;
import br.com.occurrence.api.app.api.dto.occurrence.commons.step.StepDto;
import org.springframework.boot.autoconfigure.jackson.Jackson2ObjectMapperBuilderCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DeserializerConfiguration {

    @Bean
    public Jackson2ObjectMapperBuilderCustomizer customizer() {
        return jacksonObjectMapperBuilder -> {
            jacksonObjectMapperBuilder.deserializerByType(StepDto.class, new StepDtoDeserializer());
            jacksonObjectMapperBuilder.deserializerByType(QuestionDto.class, new QuestionDtoDeserializer());
            jacksonObjectMapperBuilder.deserializerByType(AnswerDto.class, new AnswerDtoDeserializer());
            jacksonObjectMapperBuilder.deserializerByType(FlowRegistryDto.class, new FlowRegistryDtoDeserializer());
        };
    }

}
