package org.zerock.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.zerock.domain.FileUserVO;
import org.zerock.mapper.FileUserMapper;

@Service
public class FileUserService {

    @Autowired
    private FileUserMapper userMapper;
    
    
    
    public void insertUser(FileUserVO user) {
        userMapper.insertUser(user);
    }
    public FileUserVO getUserByUsername(String username) {
        return userMapper.getUserByUsername(username);
    }
   }
