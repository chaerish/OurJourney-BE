package pudding.toy.ourJourney.service;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestParam;
import pudding.toy.ourJourney.dto.content.*;
import pudding.toy.ourJourney.entity.Category;
import pudding.toy.ourJourney.entity.Contents;
import pudding.toy.ourJourney.repository.CategoryRepository;
import pudding.toy.ourJourney.repository.ContentRepository;

import java.awt.print.Pageable;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional
public class ContentService {
    private final ContentRepository contentRepository;
    private final CategoryRepository categoryRepository;
    public PageImpl<ListContentDto> getAllContents(Pageable pageable,Optional<Long> categoryId, Optional<String> content, Optional<List<Long>> tagIds) {
        List<ListContentDto> list = List.of(new ListContentDto());
        return new PageImpl<>(list);
    }

    public Long createContent(CreateContentRequest createContentRequest) {
        Category category = categoryRepository.findById(createContentRequest.getCategoryId()).orElseThrow(
                ()-> new IllegalArgumentException("category 없음")
        );
        Contents content = Contents.builder()
                .title(createContentRequest.getTitle())
                .category(category)
                .build();
        contentRepository.save(content);
        return content.getId();
    }

    public DetailContentResponse getOneContent(Long contentId) {
        return new DetailContentResponse();
    }

    public ListContentDto editOneContent(Long contentId, EditContentRequest contentEditRequestDto) {
        return new ListContentDto();
    }

    public void deleteOneContent(Long contentId) {

    }
}
