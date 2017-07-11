package filmsearch.mapper.dto;

import lombok.Data;

import java.util.List;

@Data
public class PageDto<DTO> {
    private List<DTO> content;
    private long totalElements;
    private int number;
    private int size;
}
