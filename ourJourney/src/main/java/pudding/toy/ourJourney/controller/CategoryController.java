package pudding.toy.ourJourney.controller;


import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;
import pudding.toy.ourJourney.dto.category.GetCategoriesResponse;
import pudding.toy.ourJourney.dto.content.*;
import pudding.toy.ourJourney.service.AuthService;
import pudding.toy.ourJourney.service.ContentService;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@Tag(name = "Content API", description = "Category API 입니다.")
@RequestMapping("/api/categories")
public class CategoryController {
    @GetMapping()
    @Operation(summary = "category 목록 보기", description = "category의 모든 목록을 본다.")
    public GetCategoriesResponse getAllCategories(){
        //todo: 더 공부하고 고치기,,일단 틀만 잡음!
        return new GetCategoriesResponse();
    }


}