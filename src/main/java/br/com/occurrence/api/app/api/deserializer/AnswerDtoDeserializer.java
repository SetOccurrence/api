package br.com.occurrence.api.app.api.deserializer;

import br.com.occurrence.api.app.api.dto.occurrence.commons.form.answer.*;
import br.com.occurrence.api.app.api.dto.occurrence.commons.form.question.QuestionDto;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

import java.io.IOException;

public class AnswerDtoDeserializer extends JsonDeserializer<AnswerDto> {

    @Override
    public AnswerDto deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException {
        ObjectMapper mapper = (ObjectMapper) jsonParser.getCodec();
        ObjectNode root = mapper.readTree(jsonParser);
        JsonNode questionNode = root.get("question");
        QuestionDto.Type type = QuestionDto.Type.valueOf(questionNode.get("type").asText());
        return switch (type) {
            case SHORT_TEXT -> mapper.treeToValue(root, ShortTextAnswerDto.class);
            case LONG_TEXT -> mapper.treeToValue(root, LongTextAnswerDto.class);
            case MULTIPLE_CHOICE -> mapper.treeToValue(root, MultipleChoiceAnswerDto.class);
            case CHECK_BOX -> mapper.treeToValue(root, CheckBoxAnswerDto.class);
            case MULTIPLE_CHECK_BOX -> mapper.treeToValue(root, MultipleCheckBoxAnswerDto.class);
            case LINEAR_SCALE -> mapper.treeToValue(root, LinearScaleAnswerDto.class);
            case MULTIPLE_CHOICE_GRID -> mapper.treeToValue(root, MultipleChoiceGridAnswerDto.class);
            case MULTIPLE_CHECK_BOX_GRID -> mapper.treeToValue(root, MultipleCheckBoxGridAnswerDto.class);
            case DATE -> mapper.treeToValue(root, DateAnswerDto.class);
            case DATE_TIME -> mapper.treeToValue(root, DateTimeAnswerDto.class);
            case TIME -> mapper.treeToValue(root, TimeAnswerDto.class);
        };
    }

}
