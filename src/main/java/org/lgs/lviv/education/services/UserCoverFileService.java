package org.lgs.lviv.education.services;

import org.lgs.lviv.education.entities.UserCoverFile;
import org.lgs.lviv.education.repositories.UserCoverFileRepository;
import org.lgs.lviv.education.repositories.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Service
public class UserCoverFileService {
    private static final Logger LOG = LoggerFactory.getLogger(UserCoverFileService.class);

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
            LOG.warn("Can`t save file with name {}", fileName, ex);
            return null;
        }
    }

    public UserCoverFile findById(String fileId){
        return userCoverFileRepository.findById(fileId)
                .orElseThrow(() -> {
                    LOG.warn("File with id {} not found", fileId);
                    return new RuntimeException("File not found with id " + fileId);
                });
    }

    public String findCoverIdByUserId(int id){
        String coverId = userRepository.findCoverIdByUserId(id);
        return ((coverId != null) ? coverId : "");
    }
}
