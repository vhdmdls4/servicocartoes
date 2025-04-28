package com.victorduarte.servicocartoes.application.entrypoint;

import com.victorduarte.servicocartoes.application.representation.CardsByClientResponse;
import com.victorduarte.servicocartoes.application.representation.CreditCardSaveRequest;
import com.victorduarte.servicocartoes.application.service.ClientCardService;
import com.victorduarte.servicocartoes.application.service.CreditCardService;
import com.victorduarte.servicocartoes.domain.ClientCard;
import com.victorduarte.servicocartoes.domain.CreditCard;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("api/credit_card")
@RestController
@RequiredArgsConstructor
public class CreditCardController {
    private final CreditCardService cardService;
    private final ClientCardService clientCardService;
    @GetMapping("/test")
    public String getTest(){
        return "Test";
    }

    @PostMapping
    public ResponseEntity<CreditCard> register(@RequestBody CreditCardSaveRequest request){
        CreditCard card = request.toModel();

        return ResponseEntity.ok(cardService.save(card));
    }

    @GetMapping(params = "income")
    public ResponseEntity<List<CreditCard>> getByMinimumIncomeLessThanEqual(@RequestParam("income") Long income){
        return ResponseEntity.ok(cardService.findByMinimumIncomeLessThanEqual(income));
    }

    @GetMapping(params = "cpf")
    public ResponseEntity<List<CardsByClientResponse>> getCardsByCpf(@RequestParam("cpf") String cpf){
        return ResponseEntity.ok(clientCardService.getCardsByClientCpf(cpf));
    }
}
