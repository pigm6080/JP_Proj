package org.zerock.mapper;

import java.util.List;

import org.zerock.domain.CommentsVO;

public interface CommentsMapper {

    List<CommentsVO> getAllComments();

    List<CommentsVO> getCommentsByTravelId(int travel_id);

    void insertComments(CommentsVO comments);

    void updateComments(CommentsVO comments);

    void deleteComments(int comment_id);
}
