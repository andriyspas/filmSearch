package filmsearch.mapper;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class ProjectModelMapper extends ModelMapper {


    public <DTO> List<DTO> mapList(List<?> sourceList, Class<DTO> itemClass) {
        return sourceList.stream()
                .map(e -> map(e, itemClass))
                .collect(Collectors.toList());
    }


}
