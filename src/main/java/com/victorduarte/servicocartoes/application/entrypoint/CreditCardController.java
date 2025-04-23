package com.victorduarte.servicocartoes.application.entrypoint;

import com.victorduarte.servicocartoes.application.representation.CreditCardSaveRequest;
import com.victorduarte.servicocartoes.application.service.CreditCardService;
import com.victorduarte.servicocartoes.domain.CreditCard;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("api/credit_card")
@RestController
@RequiredArgsConstructor
public class CreditCardController {
    private final CreditCardService service;
    @GetMapping("/test")
    public String getTest(){
        return "Test";
    }

    @PostMapping
    public ResponseEntity<CreditCard> register(@RequestBody CreditCardSaveRequest request){
        CreditCard card = request.toModel();

        return ResponseEntity.ok(service.save(card));
    }

    @GetMapping
    public ResponseEntity<List<CreditCard>> getByMinimumIncomeLessThanEqual(@RequestParam("income") Long income){
        return ResponseEntity.ok(service.findByMinimumIncomeLessThanEqual(income));
    }
}
