package com.example.campaign.services;

import com.example.campaign.dao.CampaignRepository;
import com.example.campaign.models.Campaign;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Campaign Service layer
 * Business logic for Campaigns should be placed here.
 */
@Service
public class CampaignService {

    @Autowired
    private CampaignRepository campaignRepository;

    public List<Campaign> getAllCampaigns(){

        //query all campaign records
        List<Campaign> campaignList = campaignRepository.findAll();

        return campaignList;

    }

    public Optional<Campaign> findCampaign(Long id) {

        //find Campaign by id
        Optional<Campaign> campaign = campaignRepository.findById(id);

        return campaign;
    }

    public Campaign createCampaign(Campaign campaign) {

        //saving Campaign as given
        Campaign newCampaign = campaignRepository.save(campaign);

        return newCampaign;
    }

    /**
     * This method can allow to only update certain values of the Campaign entity object
     * @param id
     * @param campaign
     * @return
     */
    public Campaign updateCampaign(Long id, Campaign campaign) {

        //Querying record by id
        Campaign updatedCampaign = campaignRepository.findById(id).map(existingCampaign -> {

            //updating variables only if they were submitted to be updated
            if(StringUtils.isNotBlank(campaign.getName())){
                existingCampaign.setName(campaign.getName());
            }
            if(StringUtils.isNotBlank(campaign.getDescription())){
                existingCampaign.setDescription(campaign.getDescription());
            }
            if(campaign.getIsActive() != null){
                existingCampaign.setIsActive(campaign.getIsActive());
            }

            return campaignRepository.save(existingCampaign);
        }).orElseGet(() -> {

            //if record doesn't exists then create new record with that id
            campaign.setId(id);
            return campaignRepository.save(campaign);
        });

        return updatedCampaign;
    }

    public void deleteCampaign(Long id) {
        //querying record by id
        campaignRepository.findById(id).map(existingCampaign -> {

            //if record is found then delete record
            campaignRepository.deleteById(existingCampaign.getId());

            return null;
        });
    }
}
