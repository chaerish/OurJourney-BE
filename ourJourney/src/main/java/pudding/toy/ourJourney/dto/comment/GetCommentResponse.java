package pudding.toy.ourJourney.dto.comment;

import lombok.Data;
import org.springframework.data.domain.PageImpl;

@Data
public class GetCommentResponse {
    private PageImpl<GetCommentsDto> list;
    
    public GetCommentResponse(PageImpl<GetCommentsDto> list) {
        this.list = list;
    }
}