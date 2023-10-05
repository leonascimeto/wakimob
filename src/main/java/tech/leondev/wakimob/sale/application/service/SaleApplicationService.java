package tech.leondev.wakimob.sale.application.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;
import tech.leondev.wakimob.customer.application.repository.CustomerRepository;
import tech.leondev.wakimob.customer.domain.Customer;
import tech.leondev.wakimob.properties.application.repository.ApartmentRepository;
import tech.leondev.wakimob.properties.application.repository.PlotRepository;
import tech.leondev.wakimob.properties.domain.Apartment;
import tech.leondev.wakimob.properties.domain.Plot;
import tech.leondev.wakimob.realtor.application.repository.RealtorRepository;
import tech.leondev.wakimob.realtor.domain.Realtor;
import tech.leondev.wakimob.sale.application.api.SaleRequestDTO;
import tech.leondev.wakimob.sale.application.api.SaleResponseDTO;
import tech.leondev.wakimob.sale.application.api.SimulateSaleResponseDTO;
import tech.leondev.wakimob.sale.application.repository.SaleRepository;
import tech.leondev.wakimob.sale.domain.PaymentCondition;
import tech.leondev.wakimob.sale.domain.SalePlot;
import tech.leondev.wakimob.sale.domain.SaleSimulator;

import java.util.UUID;

@Log4j2
@RequiredArgsConstructor
@Service
public class SaleApplicationService implements SaleService{
    private final PlotRepository plotRepository;
    private final ApartmentRepository apartmentRepository;
    private final RealtorRepository realtorRepository;
    private final CustomerRepository customerRepository;
    private final SaleRepository saleRepository;

    @Override
    public SimulateSaleResponseDTO simulatePlotSale(UUID idPlot, UUID idCustomer, String username, PaymentCondition paymentCondition) {
        log.info("[start] SaleApplicationService - simulatePlotSale");
        Realtor realtor = realtorRepository.getByUsername(username);
        Customer customer = customerRepository.getById(idCustomer);
        Plot plot = plotRepository.getPlotById(idPlot);
        SaleSimulator saleSimulator = new SaleSimulator(plot, realtor, customer, paymentCondition);
        SimulateSaleResponseDTO simulateSalePlotResponseDto = new SimulateSaleResponseDTO(saleSimulator);
        log.info("[end] SaleApplicationService - simulatePlotSale");
        return simulateSalePlotResponseDto;
    }

    @Override
    public SaleResponseDTO executeSalePlot(SaleRequestDTO saleRequestDTO, String username) {
        log.info("[start] SaleApplicationService - executeSalePlot");
        Realtor realtor = realtorRepository.getByUsername(username);
        Plot plot = plotRepository.getPlotById(saleRequestDTO.idProperty());
        plot.validPropertyAvailable();
        plot.soldProperty();
        Customer customer = customerRepository.getById(saleRequestDTO.idCustomer());
        SalePlot sale = saleRepository.savePlot(new SalePlot(plot, customer, realtor, saleRequestDTO.paymentCondition()));
        log.info("[end] SaleApplicationService - executeSalePlot");
        return new SaleResponseDTO(sale);
    }

    @Override
    public SimulateSaleResponseDTO simulateApartmentSale(UUID idApartment, UUID idCustomer, String username, PaymentCondition paymentCondition) {
        log.info("[start] SaleApplicationService - simulateApartmentSale");
        Realtor realtor = realtorRepository.getByUsername(username);
        Customer customer = customerRepository.getById(idCustomer);
        Apartment apartment = apartmentRepository.getById(idApartment);
        SaleSimulator saleSimulator = new SaleSimulator(apartment, realtor, customer, paymentCondition);
        SimulateSaleResponseDTO simulateSalePlotResponseDto = new SimulateSaleResponseDTO(saleSimulator);
        log.info("[end] SaleApplicationService - simulateApartmentSale");
        return simulateSalePlotResponseDto;
    }
}
