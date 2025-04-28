package com.victorduarte.servicocartoes.application.service;

import com.victorduarte.servicocartoes.application.representation.CardsByClientResponse;
import com.victorduarte.servicocartoes.domain.ClientCard;
import com.victorduarte.servicocartoes.infra.repository.ClientCardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ClientCardService {
    private final ClientCardRepository repository;

    public List<ClientCard> findByCpf(String cpf){
        return repository.findByCpf(cpf);
    }

    public List<CardsByClientResponse> getCardsByClientCpf(String cpf){
        return findByCpf(cpf).stream().map(CardsByClientResponse::fromModel).toList();
    }
}
