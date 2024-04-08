package org.zerock.mapper;

import org.zerock.domain.FileUserVO;

public interface FileUserMapper {
    void insertUser(FileUserVO user);
    FileUserVO getUserByUsername(String username);
}

