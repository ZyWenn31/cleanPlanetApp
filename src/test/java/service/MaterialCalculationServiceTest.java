package service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.MockitoAnnotations;
import tserkovnikov.com.cleanplanetapp.model.MaterialType;
import tserkovnikov.com.cleanplanetapp.model.ServiceType;
import tserkovnikov.com.cleanplanetapp.service.MaterialCalculationService;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

public class MaterialCalculationServiceTest {

    private MaterialCalculationService service;

    @BeforeEach
    void setup() {
        MockitoAnnotations.openMocks(this);
        service = new MaterialCalculationService();
    }

    @Test
    void testCalculateMaterialAmount() {
        ServiceType serviceType = new ServiceType();
        serviceType.setCoefficient(BigDecimal.valueOf(  1.2));

        MaterialType materialType = new MaterialType();
        materialType.setWastePercent(BigDecimal.valueOf(10.0));

        int result = service.calculateMaterialAmount(serviceType, materialType, 5, 10.5, 2.5);

        assertTrue(result > 0);
    }

    @Test
    void testInvalidDataReturnsMinusOne() {
        int result = service.calculateMaterialAmount(null, null, -5, -1.0, -2.0);
        assertEquals(-1, result);
    }
}
