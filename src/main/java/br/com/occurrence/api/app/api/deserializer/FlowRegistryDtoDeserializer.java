package br.com.occurrence.api.app.api.deserializer;

import br.com.occurrence.api.app.api.dto.occurrence.commons.flow.AuthorizationRegistryDto;
import br.com.occurrence.api.app.api.dto.occurrence.commons.flow.FlowRegistryDto;
import br.com.occurrence.api.app.api.dto.occurrence.commons.flow.FormRegistryDto;
import br.com.occurrence.api.app.api.dto.occurrence.commons.form.answer.ShortTextAnswerDto;
import br.com.occurrence.api.app.api.dto.occurrence.commons.form.question.QuestionDto;
import br.com.occurrence.api.app.api.dto.occurrence.commons.step.StepDto;
import br.com.occurrence.api.domain.model.occurrence.commons.step.Step;
import com.fasterxml.jackson.core.JacksonException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

import java.io.IOException;

public class FlowRegistryDtoDeserializer extends JsonDeserializer<FlowRegistryDto> {

    @Override
    public FlowRegistryDto deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException, JacksonException {
        ObjectMapper mapper = (ObjectMapper) jsonParser.getCodec();
        ObjectNode root = mapper.readTree(jsonParser);
        JsonNode stepNode = root.get("step");
        Step.Type type = Step.Type.valueOf(stepNode.get("type").asText());
        return switch (type) {
            case AUTHORIZATION -> mapper.treeToValue(root, AuthorizationRegistryDto.class);
            case FORM -> mapper.treeToValue(root, FormRegistryDto.class);
        };
    }

}
