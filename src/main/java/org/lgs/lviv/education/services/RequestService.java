package org.lgs.lviv.education.services;

import org.lgs.lviv.education.entities.Request;
import org.lgs.lviv.education.repositories.RequestsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RequestService {
    private final RequestsRepository requestsRepository;

    @Autowired
    public RequestService(RequestsRepository requestsRepository) {
        this.requestsRepository = requestsRepository;
    }


    public void create(Request request) {
        requestsRepository.save(request);
    }
}
