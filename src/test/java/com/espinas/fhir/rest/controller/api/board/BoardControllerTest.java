//package com.espinas.fhir.rest.controller.api.board;
//
//import com.espinas.fhir.domain.board.collection.Board;
//import com.espinas.fhir.rest.dto.request.board.BoardRequest;
//import com.espinas.fhir.service.board.BoardService;
//import com.fasterxml.jackson.databind.ObjectMapper;
//import org.junit.jupiter.api.DisplayName;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
//import org.springframework.boot.test.mock.mockito.MockBean;
//import org.springframework.http.MediaType;
//import org.springframework.test.web.servlet.MockMvc;
//import org.springframework.test.web.servlet.ResultActions;
//
//import java.util.List;
//
//import static java.util.Arrays.asList;
//import static org.hamcrest.Matchers.hasSize;
//import static org.mockito.ArgumentMatchers.any;
//import static org.mockito.Mockito.when;
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
//
//@WebMvcTest(BoardController.class)
//public class BoardControllerTest {
//    @Autowired
//    MockMvc mockMvc;
//
//    @Autowired
//    ObjectMapper objectMapper;
//    @MockBean
//    private BoardService boardService;
//
//    private BoardRequest createOneUpdateBoardRequest() {
//        return BoardRequest.builder()
//                .id("4")
//                .title("ddd")
//                .contents("ddddd")
//                .writer("ddddd")
//                .build();
//    }
//
//    private Board createOneUpdateBoard() {
//        return Board.builder()
//                .title("aaa")
//                .contents("aaaa")
//                .writer("aaaa")
//                .build();
//    }
//
//    private Board createOneBoard() {
//        return Board.builder()
//                .title("aaaa")
//                .contents("aaaa")
//                .writer("aaaa")
//                .build();
//    }
//
//    private List<Board> creatSeveralBoard() {
//        Board board1 = Board.builder()
//                .title("aaa")
//                .contents("aaaa")
//                .writer("aaaa")
//                .build();
//
//        Board board2 = Board.builder()
//                .title("bbb")
//                .contents("bbbb")
//                .writer("bbbb")
//                .build();
//
//        Board board3 = Board.builder()
//                .title("ccc")
//                .contents("cccc")
//                .writer("cccc")
//                .build();
//        return asList(board1, board2, board3);
//    }
//
//    @Test
//    @DisplayName("Given : board ????????? ???(?????????)??? ???????????? ??? " +
//            "When : getMapping??? board url??? ???????????? " +
//            "Then : boardId??? 1??? board ????????? ????????? ?????? ??????")
//    void getBoardTest() throws Exception {
//        Board board = createOneBoard();
//
//        when(boardService.getBoard(any())).thenReturn(board);
//
//        mockMvc.perform(get("/board/1"))
//                .andExpect(status().isOk())
//                .andExpect(jsonPath("data.boardId").value(board.getBoardId()))
//                .andExpect(jsonPath("data.title").value(board.getTitle()))
//                .andExpect(jsonPath("data.contents").value(board.getContents()))
//                .andExpect(jsonPath("data.writer").value(board.getWriter()));
//    }
//
//    @Test
//    @DisplayName("Given : boardList??? ???(?????????)?????? ???????????? ???" +
//            "When : " +
//            "Then : ")
//    void getBoardListTest() throws Exception {
//        List<Board> boardList = creatSeveralBoard();
//
//        when(boardService.getBoardList()).thenReturn(boardList);
//
//        mockMvc.perform(get("/board"))
//                .andExpect(status().isOk())
//                .andExpect(jsonPath("$.*", hasSize(3)));
//    }
//
//    @Test
//    @DisplayName("Given : boardRequest ????????? ???(?????????) ???????????? ??? " +
//            "When : postMapping??? board url ????????????, ???????????? json ???????????? ????????? " +
//            "Then : ????????? ????????? ?????? ????????? ?????? ??????")
//    void addBoardTest() throws Exception {
//        Board board = createOneBoard();
//
//        when(boardService.addBoard(any())).thenReturn(board);
//
//        ResultActions resultActions =
//                mockMvc.perform(post("/board")
//                        .contentType(MediaType.APPLICATION_JSON)
//                        .content(objectMapper.writeValueAsString(board))
//                );
//        resultActions.andExpect(status().isOk())
//                .andExpect(jsonPath("data.boardId").value(board.getBoardId()))
//                .andExpect(jsonPath("data.title").value(board.getTitle()))
//                .andExpect(jsonPath("data.contents").value(board.getContents()))
//                .andExpect(jsonPath("data.writer").value(board.getWriter()));
//    }
//
//    @Test
//    @DisplayName("Given : boardRequest ????????? ???(?????????)??? ???????????? ??? " +
//            "When : putMapping??? board url ????????????, ???????????? json ???????????? ????????? " +
//            "Then : board ???????????? ????????? ???(?????????)??? ?????? ????????? ?????? ??????")
//    void updateBoardTest() throws Exception {
//        BoardRequest boardRequest = createOneUpdateBoardRequest();
//        Board board = createOneUpdateBoard();
//
//        when(boardService.updateBoard(any())).thenReturn(board);
//
//        ResultActions resultActions =
//                mockMvc.perform(put("/board")
//                        .contentType(MediaType.APPLICATION_JSON)
//                        .content(objectMapper.writeValueAsString(boardRequest))
//                );
//        resultActions.andExpect(status().isOk())
//                .andExpect(jsonPath("data.boardId").value(board.getBoardId()))
//                .andExpect(jsonPath("data.title").value(board.getTitle()))
//                .andExpect(jsonPath("data.contents").value(board.getContents()))
//                .andExpect(jsonPath("data.writer").value(board.getWriter()));
//    }
//}
