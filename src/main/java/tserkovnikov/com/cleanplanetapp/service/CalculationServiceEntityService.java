package tserkovnikov.com.cleanplanetapp.service;

import org.springframework.stereotype.Service;
import tserkovnikov.com.cleanplanetapp.repository.EmployeeRepository;
import tserkovnikov.com.cleanplanetapp.repository.MaterialRepository;
import tserkovnikov.com.cleanplanetapp.repository.ServiceEntityRepository;
import tserkovnikov.com.cleanplanetapp.repository.ServiceMaterialRepository;
import tserkovnikov.com.cleanplanetapp.util.LoginInfo;

@Service
public class CalculationServiceEntityService {

    private final ServiceEntityRepository serviceEntityRepository;
    private final ServiceMaterialRepository serviceMaterialRepository;
    private final MaterialRepository materialRepository;
    private final EmployeeRepository employeeRepository;

    public CalculationServiceEntityService(ServiceEntityRepository serviceEntityRepository, ServiceMaterialRepository serviceMaterialRepository, MaterialRepository materialRepository, EmployeeRepository employeeRepository) {
        this.serviceEntityRepository = serviceEntityRepository;
        this.serviceMaterialRepository = serviceMaterialRepository;
        this.materialRepository = materialRepository;
        this.employeeRepository = employeeRepository;
    }

    public double calculateServiceCost(long serviceId) {
        // Получаем услугу по идентификатору
        var service = serviceEntityRepository.findById(serviceId).orElse(null);
        if (service == null) {
            System.out.println("Услуга с ID " + serviceId + " не найдена.");
            return -1;
        }

        double materialsCost = 0.0;

        // Получаем список материалов, связанных с услугой
        var serviceMaterials = serviceMaterialRepository.findByServiceId(serviceId);

        if (serviceMaterials == null || serviceMaterials.isEmpty()) {
            System.out.println("Для услуги ID " + serviceId + " не указаны материалы.");
        } else {
            // Рассчитываем стоимость материалов
            for (var sm : serviceMaterials) {
                var material = materialRepository.findById(sm.getId()).orElse(null);
                if (material != null) {
                    double cost = sm.getNorma() * sm.getPrice();
                    materialsCost += cost;
                } else {
                    System.out.println("Материал ID " + sm.getMaterial().getId() + " не найден.");
                }
            }
        }

        // Получаем категорию сотрудника, выполняющего услугу
        var category = employeeRepository.findById(LoginInfo.getLoginUserId()).orElse(null);
        if (category == null) {
            System.out.println("Категория сотрудника не найдена для услуги ID " + serviceId);
            return -1;
        }

        // Расчёт трудозатрат
        double laborCost = service.getMinPrice() * category.getId();

        // Итоговая себестоимость
        double totalCost = materialsCost + laborCost;

        System.out.println("Себестоимость услуги ID " + serviceId + " = " + totalCost);
        return Math.round(totalCost * 100.0) / 100.0; // округляем до 2 знаков
    }

}
