package org.zerock.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.zerock.domain.CommentsVO;
import org.zerock.mapper.CommentsMapper;

@Service
public class CommentsService {

    @Autowired
    private CommentsMapper commentsMapper;

    // 모든 댓글 가져오기
    public List<CommentsVO> getAllComments() {
        return commentsMapper.getAllComments();
    }

    // 여행 ID로 댓글 가져오기
    public List<CommentsVO> getCommentsByTravelId(int travel_id) {
        return commentsMapper.getCommentsByTravelId(travel_id);
    }

    // 댓글 추가
    public void insertComments(CommentsVO comments) {
        commentsMapper.insertComments(comments);
    }

    // 댓글 수정
    public void updateComments(CommentsVO comments) {
        commentsMapper.updateComments(comments);
    }

    // 댓글 삭제
    public void deleteComments(int comment_id) {
        commentsMapper.deleteComments(comment_id);
    }
}
