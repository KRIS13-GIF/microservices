package com.example.fraud;


import com.example.clients.fraud.FraudCheckResponse;
import org.springframework.web.bind.annotation.*;

@RestController()
@RequestMapping("api/v1/fraud/fraud-check")
public class FraudCheckHistoryController {

    private final FraudCheckHistoryService fraudCheckHistoryService;

    public FraudCheckHistoryController(FraudCheckHistoryService fraudCheckHistoryService) {
        this.fraudCheckHistoryService = fraudCheckHistoryService;
    }

    @GetMapping(path = "{customerId}")
    public FraudCheckResponse isFraudster(@PathVariable("customerId") Integer customerId){
            boolean isFraudelantCustomer=fraudCheckHistoryService.isFraudelant(customerId);

            return new FraudCheckResponse(isFraudelantCustomer);
    }
}
