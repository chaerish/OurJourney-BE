package pudding.toy.ourJourney.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;
import pudding.toy.ourJourney.dto.comment.*;

import java.time.LocalDateTime;
import java.util.List;

@Tag(name = "Comment API")
@RestController
@RequestMapping("/contents/{contentsId}/comments")
@RequiredArgsConstructor
public class CommentController {

    @Operation(summary = "댓글 생성")
    @PostMapping("")
    public CreateCommentResponse createComment(
            @PathVariable("contentsId") Long contentsId,
            @RequestBody @Valid CreateCommentRequest body
    ) {
        return new CreateCommentResponse(1L);
    }

    @Operation(summary = "대댓글 생성")
    @PostMapping("/{commentId}")
    public CreateReCommentResponse createReComment(
            @PathVariable("contentsId") Long contentsId,
            @PathVariable("commentId") Long commentId,
            @RequestBody @Valid CreateReCommentRequest body
    ) {
        return new CreateReCommentResponse(1L);
    }

    @Operation(summary = "댓글 목록")
    @GetMapping("")
    public GetCommentResponse getComments(
            @PathVariable("contentsId") Long contentsId,
            @PageableDefault() Pageable pageable
    ) {
        CommentProfileDto commentProfileDto = new CommentProfileDto(1L, "url", "nickname");
        GetCommentsDto getCommentsDto = new GetCommentsDto(1L, "content", commentProfileDto, LocalDateTime.now());
        List<GetCommentsDto> list = List.of(getCommentsDto);

        return new GetCommentResponse(new PageImpl<>(list, pageable, 1L));
    }

    // TODO: login_required
    @Operation(summary = "댓글 수정")
    @PatchMapping("/{commentId}")
    public void updateComment(
            @PathVariable("contentsId") Long contentsId,
            @PathVariable("commentId") Long commentId,
            @RequestBody @Valid UpdateCommentRequest body
    ) {

    }

    // TODO: login_required
    @Operation(summary = "댓글 삭제")
    @DeleteMapping("/{commentId}")
    public void deleteComment(
            @PathVariable("contentsId") Long contentsId,
            @PathVariable("commentId") Long commentId
    ) {

    }
}