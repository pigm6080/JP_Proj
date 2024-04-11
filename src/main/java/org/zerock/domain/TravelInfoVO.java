package org.zerock.domain;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TravelInfoVO {
    private int travel_id;
    private String destination;
    private String description;
    private int category_id;
}