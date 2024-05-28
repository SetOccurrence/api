package br.com.occurrence.api.domain.mapper;

import br.com.occurrence.api.app.api.dto.UserDto;
import br.com.occurrence.api.app.api.dto.UserFormDto;
import br.com.occurrence.api.domain.model.User;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface UserMapper {

    User toUser(UserFormDto userFormDTO);

    void updateUserFromDTO(@MappingTarget User user, UserFormDto userFormDTO);

    UserDto toUserDTO(User user);

}
