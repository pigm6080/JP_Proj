package org.zerock.domain;

import java.time.LocalDateTime;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class FileUserVO {
    private Long id;
    private String username;
    private LocalDateTime createdAt;

    // Getters and setters
}
