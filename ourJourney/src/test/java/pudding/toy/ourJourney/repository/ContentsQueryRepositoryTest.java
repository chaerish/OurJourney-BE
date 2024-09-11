package pudding.toy.ourJourney.repository;

import jakarta.transaction.Transactional;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import pudding.toy.ourJourney.entity.Category;
import pudding.toy.ourJourney.entity.Contents;

import java.util.Optional;


@Transactional
@SpringBootTest
class ContentsQueryRepositoryTest {
    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private ContentRepository contentRepository;

    @Autowired
    private ContentsQueryRepository contentsQueryRepository;

    Category category1;

    @BeforeEach
    public void setUp() {
        category1 = categoryRepository.save(new Category("category1"));
        Category category2 = categoryRepository.save(new Category("category2"));
        contentRepository.save(new Contents("title1", category1, null));
        contentRepository.save(new Contents("title2", category2, null));
    }

    @Test
    public void findAllTest() {
        PageRequest pageRequest = PageRequest.of(0, 10);
        PageImpl<Contents> act = contentsQueryRepository.findAll(pageRequest, Optional.empty(), Optional.empty(), Optional.empty());

        Assertions.assertThat(act).isNotNull();
        Assertions.assertThat(act.getTotalElements()).isEqualTo(2L);
    }

    @Test
    public void findAllByCategoryIdTest() {
        PageRequest pageRequest = PageRequest.of(0, 10);
        PageImpl<Contents> act = contentsQueryRepository.findAll(pageRequest, Optional.ofNullable(category1.getId()), Optional.empty(), Optional.empty());

        Assertions.assertThat(act).isNotNull();
        Assertions.assertThat(act.getTotalElements()).isEqualTo(1L);
    }
}