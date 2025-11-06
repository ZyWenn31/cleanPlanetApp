package service;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import tserkovnikov.com.cleanplanetapp.model.Partner;
import tserkovnikov.com.cleanplanetapp.repository.PartnerRepository;
import tserkovnikov.com.cleanplanetapp.service.PartnerService;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

public class PartnerServiceTest {

    @Mock
    private PartnerRepository partnerRepository;

    @InjectMocks
    private PartnerService partnerService;

    public PartnerServiceTest() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testAddPartner() {
        Partner partner = new Partner();
        partner.setName("ООО Чистый Мир");
        partner.setType("Поставщик");

        when(partnerRepository.save(any(Partner.class))).thenReturn(partner);

        Partner saved = partnerService.save(partner);

        assertNotNull(saved);
        assertEquals("ООО Чистый Мир", saved.getName());
        verify(partnerRepository, times(1)).save(partner);
    }
}

