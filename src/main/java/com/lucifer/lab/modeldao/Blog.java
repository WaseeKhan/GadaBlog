package com.lucifer.lab.modeldao;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Blog {

    private Long id;
    private String title;
    private String content;
    private Date createOn;
    private Date updatedOn;

}
