package com.huntercodexs.storageservice.dto;

import lombok.*;

@Data
@Setter
@Getter
@Builder
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class StorageRequestDto {
    byte[] data;
    String filename;
}
