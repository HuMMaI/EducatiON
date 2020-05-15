package org.lgs.lviv.education.controllers;

import org.lgs.lviv.education.entities.UserCoverFile;
import org.lgs.lviv.education.services.UserCoverFileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/user-cover-files")
public class UserCoverFileController {
    @Autowired
    private UserCoverFileService userCoverFileService;

    @PostMapping("/upload")
    public String uploadFile(@RequestParam("coverFile") MultipartFile file){
        UserCoverFile userCoverFile = userCoverFileService.save(file);
        return userCoverFile.getId();
    }

    @GetMapping("/download/{fileId}")
    public ResponseEntity<Resource> downloadFile(@PathVariable String fileId){
        UserCoverFile userCoverFile = userCoverFileService.findById(fileId);
        return ResponseEntity.ok()
                .contentType(MediaType.parseMediaType(userCoverFile.getFileType()))
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=" + userCoverFile.getFileName())
                .body(new ByteArrayResource(userCoverFile.getData()));
    }

    @GetMapping("/user-cover-id")
    public String getCoverId(HttpServletRequest req){
        int userId = (int) req.getSession().getAttribute("userId");

        return userCoverFileService.findCoverIdByUserId(userId);
    }
}
