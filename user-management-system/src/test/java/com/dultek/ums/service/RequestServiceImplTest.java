package com.dultek.ums.service;

import com.dultek.ums.model.PaidTimeOff;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

public class RequestServiceImplTest {

    private RequestService requestService = new RequestServiceImpl(); // Assuming you have a concrete implementation

    @Test
    public void testSendPtoRequest() {
        assertDoesNotThrow(() -> requestService.sendPtoRequest(new PaidTimeOff()));
        // Add more assertions based on the behavior of the sendPtoRequest method
    }

    @Test
    public void testApproveRequests() {
        assertDoesNotThrow(() -> requestService.approveRequests());
        // Add more assertions based on the behavior of the approveRequests method
    }

    @Test
    public void testSendRequests() {
        assertDoesNotThrow(() -> requestService.sendRequests());
        // Add more assertions based on the behavior of the sendRequests method
    }
}
