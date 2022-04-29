package com.bithumb.msacommunity.service;

import com.bithumb.msacommunity.domain.Board;
import com.bithumb.msacommunity.repository.BoardRepository;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.util.Date;
import java.util.Objects;

@Service
public class BoardServiceImpl implements BoardService {

    private final BoardRepository boardRepository;
    private final KafkaProducerService kafkaProducerService;

    public BoardServiceImpl(BoardRepository boardRepository, KafkaProducerService kafkaProducerService) {
        this.boardRepository = boardRepository;
        this.kafkaProducerService = kafkaProducerService;
    }

    //게시글 저장
    @Override
    public Mono<Board> saveBoard(Board board) {
        // producer 역할 수행
        kafkaProducerService.sendMessage("Kafka Message: save BoardId = " + board.getId());
        return this.boardRepository.save(board);
    }

    //게시글 숨김
    @Override
    public Mono<Board> hideBoard(Integer articleId) {
        return boardRepository.findById(articleId)
                .filter(Objects::nonNull) //있는 댓번일때
                .filter(item -> item.getVisibleyn()==0) //show상태일떄
                .doOnNext(item -> item.setVisibleyn(1))
                .flatMap(item -> boardRepository.save(item))
                .log();
    }

}
