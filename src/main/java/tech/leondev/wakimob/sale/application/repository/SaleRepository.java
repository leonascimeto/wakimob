package tech.leondev.wakimob.sale.application.repository;

import tech.leondev.wakimob.sale.domain.Sale;
import tech.leondev.wakimob.sale.domain.SaleApartment;
import tech.leondev.wakimob.sale.domain.SalePlot;

public interface SaleRepository {
    SalePlot savePlot(SalePlot salePlot);

    SaleApartment saveApartment(SaleApartment saleApartment);
}
