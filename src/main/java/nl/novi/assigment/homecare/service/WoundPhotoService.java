package nl.novi.assigment.homecare.service;


import nl.novi.assigment.homecare.domain.dto.CreateWoundPhotoDto;
import nl.novi.assigment.homecare.domain.dto.WoundPhotoDto;
import nl.novi.assigment.homecare.domain.entity.WoundPhoto;
import nl.novi.assigment.homecare.repository.WoundPhotoRepository;
import org.springframework.stereotype.Service;

@Service
public class WoundPhotoService {
    private final WoundPhotoRepository woundPhotoRepository;
    private final WoundService woundService;

    public WoundPhotoService(WoundPhotoRepository woundPhotoRepository, WoundService woundService) {
        this.woundPhotoRepository = woundPhotoRepository;
        this.woundService = woundService;
    }


    public WoundPhotoDto addWoundPhoto(CreateWoundPhotoDto createWoundPhotoDto) {
        WoundPhoto woundPhoto = new WoundPhoto();
        woundPhoto.setPhotoDate(createWoundPhotoDto.getPhotoDate());
        woundPhoto.setPatientComment(createWoundPhotoDto.getPatientComment());
        woundPhoto.setWound(woundService.getWoundById(createWoundPhotoDto.getWoundId()));
        woundPhotoRepository.save(woundPhoto);
        return toWoundPhotoDto(woundPhoto);
    }

    private WoundPhotoDto toWoundPhotoDto(WoundPhoto woundPhoto) {
        WoundPhotoDto woundPhotoDto = new WoundPhotoDto();
        woundPhotoDto.setId(woundPhoto.getId());
        woundPhotoDto.setNurseAssessment(woundPhoto.getNurseAssessment());
        woundPhotoDto.setAssessmentDate(woundPhoto.getAssessmentDate());
        woundPhotoDto.setPatientComment(woundPhoto.getPatientComment());
        woundPhotoDto.setPhotoDate(woundPhoto.getPhotoDate());
        woundPhotoDto.setWound(woundPhoto.getWound());
        return woundPhotoDto;
    }
}
