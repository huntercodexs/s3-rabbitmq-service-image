package com.huntercodexs.serviceimage.dto;

import lombok.*;

@Data
@Setter
@Getter
@Builder
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class ServiceImageRequestDto {
    byte[] data;
    String filename;
}
