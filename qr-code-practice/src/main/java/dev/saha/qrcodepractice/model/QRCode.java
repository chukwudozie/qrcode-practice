package dev.saha.qrcodepractice.model;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class QRCode {
    private int width;
    private int height;
    private String content;
    private String path;

}
