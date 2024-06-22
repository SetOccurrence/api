package br.com.occurrence.api.app.api.deserializer;

import br.com.occurrence.api.app.api.dto.occurrence.commons.form.question.*;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

import java.io.IOException;

public class QuestionDtoDeserializer extends JsonDeserializer<QuestionDto> {

    @Override
    public QuestionDto deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException {
        ObjectMapper mapper = (ObjectMapper) jsonParser.getCodec();
        ObjectNode root = mapper.readTree(jsonParser);
        QuestionDto.Type type = QuestionDto.Type.valueOf(root.get("type").asText());
        return switch (type) {
            case SHORT_TEXT -> mapper.treeToValue(root, ShortTextQuestionDto.class);
            case LONG_TEXT -> mapper.treeToValue(root, LongTextQuestionDto.class);
            case MULTIPLE_CHOICE -> mapper.treeToValue(root, MultipleChoiceQuestionDto.class);
            case CHECK_BOX -> mapper.treeToValue(root, CheckBoxQuestionDto.class);
            case MULTIPLE_CHECK_BOX -> mapper.treeToValue(root, MultipleCheckBoxQuestionDto.class);
            case LINEAR_SCALE -> mapper.treeToValue(root, LinearScaleQuestionDto.class);
            case MULTIPLE_CHOICE_GRID -> mapper.treeToValue(root, MultipleChoiceGridQuestionDto.class);
            case MULTIPLE_CHECK_BOX_GRID -> mapper.treeToValue(root, MultipleCheckBoxGridQuestionDto.class);
            case DATE -> mapper.treeToValue(root, DateQuestionDto.class);
            case DATE_TIME -> mapper.treeToValue(root, DateTimeQuestionDto.class);
            case TIME -> mapper.treeToValue(root, TimeQuestionDto.class);
        };
    }

}
