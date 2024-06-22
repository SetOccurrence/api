package br.com.occurrence.api.app.api.deserializer;

import br.com.occurrence.api.app.api.dto.occurrence.commons.step.AuthorizationStepDto;
import br.com.occurrence.api.app.api.dto.occurrence.commons.step.FormStepDto;
import br.com.occurrence.api.app.api.dto.occurrence.commons.step.StepDto;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

import java.io.IOException;

public class StepDtoDeserializer extends JsonDeserializer<StepDto> {

    @Override
    public StepDto deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException {
        ObjectMapper mapper = (ObjectMapper) jsonParser.getCodec();
        ObjectNode root = mapper.readTree(jsonParser);
        StepDto.Type type = StepDto.Type.valueOf(root.get("type").asText());
        return switch (type) {
            case FORM -> mapper.treeToValue(root, FormStepDto.class);
            case AUTHORIZATION -> mapper.treeToValue(root, AuthorizationStepDto.class);
        };
    }

}
