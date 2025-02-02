package org.xcolab.client.contest.pojo.team;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import org.springframework.core.ParameterizedTypeReference;

import org.xcolab.util.http.client.enums.ServiceNamespace;
import org.xcolab.util.http.client.types.TypeProvider;
import org.xcolab.util.http.dto.DataTransferObject;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(Include.NON_NULL)
public class ContestTeamMemberRoleDto extends AbstractContestTeamMemberRole
        implements DataTransferObject<ContestTeamMemberRole> {

    public static final TypeProvider<ContestTeamMemberRoleDto> TYPES =
            new TypeProvider<>(ContestTeamMemberRoleDto.class,
                    new ParameterizedTypeReference<List<ContestTeamMemberRoleDto>>() {
                    });

    public ContestTeamMemberRoleDto() {}

    public ContestTeamMemberRoleDto(AbstractContestTeamMemberRole value) {
        super(value);
    }

    @Override
    public ContestTeamMemberRole toPojo(ServiceNamespace serviceNamespace) {
        return new ContestTeamMemberRole(this, serviceNamespace);
    }
}
