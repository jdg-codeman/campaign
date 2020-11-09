package com.example.campaign.api;

import com.example.campaign.models.Campaign;
import com.example.campaign.services.CampaignService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

/**
 *
 * This controller is in charge of handling Campaign requests
 * Method created here represent standard CRUD calls for Campaign record
 *
 */
@RestController
@RequestMapping("/campaign")
public class CampaignController {

    @Autowired
    private CampaignService campaignService;

    /**
     * This method support GET request to get all Campaign records
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ResponseEntity<List<Campaign>> getAllCampaign(){

        List<Campaign> campaignList = campaignService.getAllCampaigns();

        return new ResponseEntity<>(campaignList, HttpStatus.OK);

    }

    /**
     * This method support GET request to query Campaign record by id
     * @param id
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<Optional<Campaign>> getCampaignById(@PathVariable Long id){

        Optional<Campaign> campaign = campaignService.findCampaign(id);

        return new ResponseEntity<>(campaign, HttpStatus.OK);

    }

    /**
     * This method support POST request to create new campaign
     * Validation is taken care of by the framework using (@Valid) and messages are specified in the Campaign model object
     * @param campaign
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/", method = RequestMethod.POST)
    public ResponseEntity<Campaign> saveNewCampaign(@Valid @RequestBody Campaign campaign){

        Campaign newCampaign = campaignService.createCampaign(campaign);

        return new ResponseEntity<>(newCampaign, HttpStatus.OK);

    }

    /**
     * This method support PUT request to update existing campaign
     * Validation is taken care of by the framework using (@Valid) and messages are specified in the Campaign model object
     * @param id campaign
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Campaign> updateExistingCampaign(@PathVariable Long id, @Valid @RequestBody Campaign campaign){

        Campaign updatedCampaign = campaignService.updateCampaign(id, campaign);

        return new ResponseEntity<>(updatedCampaign, HttpStatus.OK);

    }

    /**
     * This method support DELETE request to delete a campaign record by id
     * @param id
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Campaign> deleteCampaign(@PathVariable Long id){

        campaignService.deleteCampaign(id);

        return new ResponseEntity<>(null, HttpStatus.OK);

    }

    /**
     * creating /campaign/create api according to user story
     * This method support POST request to create new campaign
     * Validation is taken care of by the framework using (@Valid) and messages are specified in the Campaign model object
     * @param campaign
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public ResponseEntity<Campaign> createCampaign(@Valid @RequestBody Campaign campaign){

        Campaign newCampaign = campaignService.createCampaign(campaign);

        return new ResponseEntity<>(newCampaign, HttpStatus.OK);

    }
}
