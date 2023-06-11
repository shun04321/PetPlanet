package com.example.pet.service;

import com.example.pet.domain.board.Board;
import com.example.pet.domain.member.Member;
import com.example.pet.dto.board.*;
import com.example.pet.repository.BoardRepository;
import com.example.pet.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class BoardService {

    private final BoardRepository boardRepository;
    private final MemberRepository memberRepository;

    // 전체 게시글 조회하기
    public List<BoardListResponseDto> findAllBoard() {
        try {
            List<Board> boardList = boardRepository.findAll();
            List<BoardListResponseDto> responseDtoList = new ArrayList<>();
            for (Board board : boardList) {
                responseDtoList.add(
                        new BoardListResponseDto(board)
                );
            }
            return responseDtoList;
        } catch (Exception e) {
        }
        return null;
    }

    // 글 하나 조회하기
    public BoardResponseDto findOneBoard(int id) {
        Board board = boardRepository.findById(id).orElseThrow(
                ()->new IllegalArgumentException("해당 게시글이 존재하지 않습니다.")
        );
        return new BoardResponseDto(board);
    }

    // 게시판에 글 등록하기
    public Board boardSave(int memberId, BoardDto requestDto) {
        Member member = memberRepository.findByMemberId(memberId);

        requestDto.setMemberId(memberId);
        requestDto.setWriter(member.getKakaoNickname());
        Board board = boardRepository.save(requestDto.toEntity());
        board.setMember(member);

        System.out.println("memberId : " + board.getMember().getMemberId());

        return board;
    }

    // 글 수정하기
    public Board boardUpdate(int id, BoardUpdateRequestDto requestDto) {
        Board board = boardRepository.findById(id).orElseThrow
                (() -> new IllegalArgumentException("해당 게시글이 존재하지 앟습니다. id = "+id));
        board.update(requestDto);

        return boardRepository.save(board);
    }
    // 글 삭제하기
    public void boardDelete(int id) {
        Board board = boardRepository.findById(id)
                .orElseThrow(()->new IllegalArgumentException("해당 게시글이 존재하지 앟습니다. id = " + id));
        //존재하는 글인지 확인 후 삭제
        boardRepository.delete(board);
    }

    // 제목으로 검색하기
    public List<BoardListResponseDto> getBoardByTitle(String title) {
        List<Board> boardList = boardRepository.findByTitle(title);
        List<BoardListResponseDto> boardListResponseDtos = new ArrayList<>();
        for(Board board : boardList) {
            boardListResponseDtos.add(
                    new BoardListResponseDto(board)
            );
        }
        return boardListResponseDtos;
    }


}
