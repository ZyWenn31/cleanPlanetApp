package tserkovnikov.com.cleanplanetapp.util;

import tserkovnikov.com.cleanplanetapp.model.PartnerServiceHistory;

import java.util.List;

public interface IServiceHistoryService {
    List<PartnerServiceHistory> getAll();
    List<PartnerServiceHistory> getByPartner(Long partnerId);
    PartnerServiceHistory save(PartnerServiceHistory history);
    void delete(Long id);
}

