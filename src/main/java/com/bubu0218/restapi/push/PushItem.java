package com.bubu0218.restapi.push;

import lombok.*;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PushItem {
    private String id;
    private String token;

}
