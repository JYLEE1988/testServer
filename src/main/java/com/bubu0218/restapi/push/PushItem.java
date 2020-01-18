package com.bubu0218.restapi.push;

import lombok.*;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Document
public class PushItem {
    private String id;
    @Field(name = "device_id")
    private String deviceId;
    private String token;
}
