package com.espinas.fhir.domain.board.collection;

import com.espinas.fhir.domain.common.BaseEntity;
import com.espinas.fhir.rest.dto.request.board.BoardRequest;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Document(collection = "board")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Board extends BaseEntity {

    @Id
    private String id;

    private String title;

    private String contents;

    private String writer;

    public void setId(String id) {
        this.id = id;
    }

    @Builder
    public Board(String title, String contents, String writer) {
        this.title = title;
        this.contents = contents;
        this.writer = writer;
    }

    public void update(BoardRequest boardRequest) {
        this.id = boardRequest.getId();
        this.title = boardRequest.getTitle();
        this.contents = boardRequest.getContents();
        this.writer = boardRequest.getWriter();
    }
}
