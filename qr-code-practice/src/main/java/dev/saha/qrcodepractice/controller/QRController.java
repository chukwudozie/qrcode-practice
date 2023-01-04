package dev.saha.qrcodepractice.controller;

import dev.saha.qrcodepractice.model.QRCode;
import dev.saha.qrcodepractice.service.QRCodeService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class QRController {
    private final QRCodeService qrCodeService;

    @PostMapping("/download")
    public void downloadQRCodeImage (@RequestBody QRCode code){
        qrCodeService.downloadQRCodeImage(code);
    }
}
