package tserkovnikov.com.cleanplanetapp.service;

import org.springframework.stereotype.Service;
import tserkovnikov.com.cleanplanetapp.model.MaterialType;
import tserkovnikov.com.cleanplanetapp.model.ServiceType;
import tserkovnikov.com.cleanplanetapp.repository.MaterialTypeRepository;
import tserkovnikov.com.cleanplanetapp.repository.ServiceTypeRepository;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Optional;

@Service
public class MaterialCalculationService {

    private final ServiceTypeRepository serviceTypeRepository;
    private final MaterialTypeRepository materialTypeRepository;

    public MaterialCalculationService(ServiceTypeRepository serviceTypeRepository,
                                      MaterialTypeRepository materialTypeRepository) {
        this.serviceTypeRepository = serviceTypeRepository;
        this.materialTypeRepository = materialTypeRepository;
    }

    /**
     * Пустой конструктор — удобен для unit-тестов, когда используются перегрузки с передачей объектов.
     * Репозитории останутся null; это нормально, если вы используете перегрузку с объектами.
     */
    public MaterialCalculationService() {
        this.serviceTypeRepository = null;
        this.materialTypeRepository = null;
    }

    /**
     * Вариант: вход — идентификаторы типов (используется в приложении).
     */
    public int calculateMaterialAmount(long serviceTypeId,
                                       long materialTypeId,
                                       int quantity,
                                       double param1,
                                       double param2) {
        Optional<ServiceType> sOpt = serviceTypeRepository.findById(serviceTypeId);
        Optional<MaterialType> mOpt = materialTypeRepository.findById(materialTypeId);

        if (sOpt.isEmpty() || mOpt.isEmpty()) {
            return -1;
        }
        return calculateMaterialAmount(sOpt.get(), mOpt.get(), quantity, param1, param2);
    }

    /**
     * Перегрузка: вход — объекты ServiceType и MaterialType (удобно для unit-тестов).
     */
    public int calculateMaterialAmount(ServiceType serviceType,
                                       MaterialType materialType,
                                       int quantity,
                                       double param1,
                                       double param2) {
        // Валидация входных аргументов
        if (serviceType == null || materialType == null) return -1;
        if (quantity <= 0 || param1 <= 0.0 || param2 <= 0.0) return -1;

        // Получаем коэффициенты из сущностей (BigDecimal)
        BigDecimal coefficient = serviceType.getCoefficient();
        BigDecimal wastePercent = materialType.getWastePercent(); // ожидается дробь: 0.05 = 5%

        if (coefficient == null || wastePercent == null) return -1;

        // Переводим double->BigDecimal корректно
        BigDecimal p1 = BigDecimal.valueOf(param1);
        BigDecimal p2 = BigDecimal.valueOf(param2);
        BigDecimal qty = BigDecimal.valueOf(quantity);

        // baseAmount = param1 * param2 * coefficient * quantity
        BigDecimal baseAmount = p1.multiply(p2)
                .multiply(coefficient)
                .multiply(qty);

        // totalWithWaste = baseAmount * (1 + wastePercent)
        BigDecimal multiplier = BigDecimal.ONE.add(wastePercent);
        BigDecimal totalWithWaste = baseAmount.multiply(multiplier);

        // Округление вверх до целого (перерасход => всегда брать больше)
        BigDecimal rounded = totalWithWaste.setScale(0, RoundingMode.CEILING);

        // Приведение к int безопасно (на практике лучше long, но требование — int)
        try {
            return rounded.intValueExact();
        } catch (ArithmeticException ex) {
            // например, число слишком велико или дробная часть не нулевая (должно быть нулевая после setScale)
            return -1;
        }
    }
}

