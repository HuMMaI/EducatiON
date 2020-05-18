package org.lgs.lviv.education.services;

import org.lgs.lviv.education.entities.UserCoverFile;
import org.lgs.lviv.education.repositories.UserCoverFileRepository;
import org.lgs.lviv.education.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Service
public class UserCoverFileService {
    private final UserCoverFileRepository userCoverFileRepository;
    private final UserRepository userRepository;

    @Autowired
    public UserCoverFileService(UserCoverFileRepository userCoverFileRepository, UserRepository userRepository) {
        this.userCoverFileRepository = userCoverFileRepository;
        this.userRepository = userRepository;
    }

    public UserCoverFile save(MultipartFile file){
        String fileName = StringUtils.cleanPath(file.getOriginalFilename());

        try {
            UserCoverFile userCoverFile =
                    new UserCoverFile(fileName, file.getContentType(), file.getBytes());
            return userCoverFileRepository.save(userCoverFile);
        } catch (IOException ex) {
            throw new RuntimeException("Can't save file " + fileName, ex);
        }
    }

    public UserCoverFile findById(String fileId){
        return userCoverFileRepository.findById(fileId)
                .orElseThrow(() -> new RuntimeException("File not found with id " + fileId));
    }

    public String findCoverIdByUserId(int id){
        String coverId = userRepository.findCoverIdByUserId(id);
        return ((coverId != null) ? coverId : "");
    }
}
