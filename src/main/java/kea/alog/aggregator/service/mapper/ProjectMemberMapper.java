package kea.alog.aggregator.service.mapper;

import kea.alog.aggregator.web.dto.ProjectMemberDto.ProjectMemberResponseDto;
import kea.alog.aggregator.web.dto.UserDto.UserResponseDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface ProjectMemberMapper {
    ProjectMemberMapper INSTANCE = Mappers.getMapper(ProjectMemberMapper.class);

    ProjectMemberResponseDto toProjectMemberResponseDto(UserResponseDto userResponseDto);
}
