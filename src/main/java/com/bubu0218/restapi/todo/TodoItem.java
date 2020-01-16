package com.bubu0218.restapi.todo;


import lombok.*;

@Data
@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TodoItem {
    private String id;
    private String title;
    private boolean done;
}