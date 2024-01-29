package com.dultek.ums.service;

import com.dultek.ums.model.PaidTimeOff;

public interface RequestService {
    void sendPtoRequest(PaidTimeOff request);
    void approveRequests();
    void sendRequests();
}
