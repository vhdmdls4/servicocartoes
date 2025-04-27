package com.victorduarte.servicocartoes.application.service;

import com.victorduarte.servicocartoes.domain.ClientCard;
import com.victorduarte.servicocartoes.infra.repository.ClientCardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ClientCardService {
    private final ClientCardRepository repository;

    public List<ClientCard> findByCpf(String cpf){
        return repository.findByCpf(cpf);
    }
}
