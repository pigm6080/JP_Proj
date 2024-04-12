package org.zerock.security.domain;



import org.springframework.security.core.userdetails.User;
import org.zerock.domain.UserVO;

public class UserAdapter extends User {

    private static final long serialVersionUID = 1L;
    
    private UserVO userVO;

    public UserAdapter(UserVO userVO) {
        super(userVO.getUsername(), userVO.getPassword(), userVO.getAuthorities());
        this.userVO = userVO;
    }

    public UserVO getUserVO() {
        return userVO;
    }
}
