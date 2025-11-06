package validation;

import org.junit.jupiter.api.Test;
import tserkovnikov.com.cleanplanetapp.model.Partner;

import static org.junit.jupiter.api.Assertions.*;

public class PartnerValidationTest {

    @Test
    void testInvalidRating() {
        Partner partner = new Partner();
        partner.setName("ООО ЭкоПартнёр");
        partner.setRating(-5);

        assertTrue(partner.getRating() < 0, "Рейтинг не может быть отрицательным");
    }

    @Test
    void testValidRating() {
        Partner partner = new Partner();
        partner.setName("ООО ЭкоПартнёр");
        partner.setRating(5);

        assertTrue(partner.getRating() >= 0 && partner.getRating() <= 10);
    }
}

