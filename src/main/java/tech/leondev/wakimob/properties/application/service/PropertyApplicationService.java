package tech.leondev.wakimob.properties.application.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;
import tech.leondev.wakimob.properties.application.api.ApartmentRequestDTO;
import tech.leondev.wakimob.properties.application.api.ApartmentResponseDTO;
import tech.leondev.wakimob.properties.application.api.PlotRequestDTO;
import tech.leondev.wakimob.properties.application.api.PlotResponseDTO;
import tech.leondev.wakimob.properties.application.repository.ApartmentRepository;
import tech.leondev.wakimob.properties.application.repository.PlotRepository;
import tech.leondev.wakimob.properties.domain.Apartment;
import tech.leondev.wakimob.properties.domain.Plot;

import java.util.List;
import java.util.UUID;

@Log4j2
@RequiredArgsConstructor
@Service
public class PropertyApplicationService implements PropertyService{
    private final PlotRepository plotRepository;
    private final ApartmentRepository apartmentRepository;
    @Override
    public PlotResponseDTO savePlot(PlotRequestDTO plotRequestDTO) {
        log.info("[start] PropertyApplicationService - savePlot");
        Plot plot = plotRepository.savePlot(new Plot(plotRequestDTO));
        log.info("[end] PropertyApplicationService - savePlot");
        return new PlotResponseDTO(plot);
    }

    @Override
    public List<PlotResponseDTO> listPlots() {
        log.info("[start] PropertyApplicationService - listPlots");
        List<Plot> plots = plotRepository.listPlots();
        log.info("[end] PropertyApplicationService - listPlots");
        return PlotResponseDTO.convertPlotsToList(plots);
    }

    @Override
    public PlotResponseDTO getPLotById(UUID idPlot) {
        log.info("[start] PropertyApplicationService - getPLotById");
        Plot plot = plotRepository.getPlotById(idPlot);
        log.info("[end] PropertyApplicationService - getPLotById");
        return new PlotResponseDTO(plot);
    }

    @Override
    public void updatePlot(PlotRequestDTO plotRequestDTO, UUID idPlot) {
        log.info("[start] PropertyApplicationService - updatePlot");
        Plot plot = plotRepository.getPlotById(idPlot);
        plot.update(plotRequestDTO);
        plotRepository.savePlot(plot);
        log.info("[end] PropertyApplicationService - updatePlot");
    }

    @Override
    public void deletePlot(UUID idPlot) {
        log.info("[start] PropertyApplicationService - deletePlot");
        Plot plot = plotRepository.getPlotById(idPlot);
        plotRepository.deletePlot(plot);
        log.info("[end] PropertyApplicationService - deletePlot");
    }

    @Override
    public ApartmentResponseDTO saveApartment(ApartmentRequestDTO apartmentRequestDTO) {
        log.info("[start] PropertyApplicationService - saveApartment");
        Apartment apartment = apartmentRepository.save(new Apartment(apartmentRequestDTO));
        log.info("[end] PropertyApplicationService - saveApartment");
        return new ApartmentResponseDTO(apartment);
    }

    @Override
    public List<ApartmentResponseDTO> listApartments() {
        log.info("[start] PropertyApplicationService - listApartments");
        List<Apartment> apartments = apartmentRepository.list();
        log.info("[end] PropertyApplicationService - listApartments");
        return ApartmentResponseDTO.convertApartmentsToList(apartments);
    }

    @Override
    public ApartmentResponseDTO getApartmentById(UUID apartmentId) {
        log.info("[start] PropertyApplicationService - getApartmentById");
        Apartment apartment = apartmentRepository.getById(apartmentId);
        log.info("[end] PropertyApplicationService - getApartmentById");
        return new ApartmentResponseDTO(apartment);
    }
}
