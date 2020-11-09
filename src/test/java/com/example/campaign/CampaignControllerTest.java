package com.example.campaign;

import com.example.campaign.models.Campaign;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.junit.jupiter.api.Assertions.*;

public class CampaignControllerTest extends CampaignApplicationTests {

    @Override
    @BeforeEach
    public void setUp() {
        super.setUp();
    }

    @Test
    public void getCampaignList() throws Exception {
        String uri = "/campaign/";

        //sending request
        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get(uri)
                .accept(MediaType.APPLICATION_JSON_VALUE)).andReturn();

        //getting response status back and testing status code
        int status = mvcResult.getResponse().getStatus();
        assertEquals(200, status);

        //getting response content and converting it to Campaign object
        String content = mvcResult.getResponse().getContentAsString();
        Campaign[] campaignList = super.mapFromJson(content, Campaign[].class);

        //Testing campaigns where returned
        assertTrue(campaignList.length > 0);
    }

    @Test
    public void saveNewCampaign() throws Exception {
        String uri = "/campaign/";

        //new Campaign object
        Campaign campaign = new Campaign();
        campaign.setName("First Campaign");
        campaign.setDescription("First Campaign Description");
        campaign.setIsActive(true);

        //converting Campaign object to JSON string
        String inputJson = super.mapToJson(campaign);

        //sending request
        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.post(uri)
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .content(inputJson)).andReturn();

        //getting response status back and testing status code
        int status = mvcResult.getResponse().getStatus();
        assertEquals(200, status);

        //getting response content and converting it to Campaign object
        String content = mvcResult.getResponse().getContentAsString();
        Campaign returnedCampaign = super.mapFromJson(content, Campaign.class);

        //Testing new id was set and returned
        assertNotNull(returnedCampaign.getId());
    }

    @Test
    public void updateExistingCampaign() throws Exception {
        String uri = "/campaign/2";

        //new Campaign object
        Campaign campaign = new Campaign();
        campaign.setName("Second Campaign");
        campaign.setDescription("Second Campaign Description");
        campaign.setIsActive(false);

        //converting Campaign object to JSON string
        String inputJson = super.mapToJson(campaign);

        //sending request
        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.put(uri)
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .content(inputJson)).andReturn();

        //getting response status back and testing status code
        int status = mvcResult.getResponse().getStatus();
        assertEquals(200, status);

        //getting response content and converting it to Campaign object
        String content = mvcResult.getResponse().getContentAsString();
        Campaign returnedCampaign = super.mapFromJson(content, Campaign.class);

        //Testing new id was set and returned
        assertNotNull(returnedCampaign.getId());
    }

    @Test
    public void createCampaign() throws Exception {
        String uri = "/campaign/create";

        //new Campaign object
        Campaign campaign = new Campaign();
        campaign.setName("First Campaign");
        campaign.setDescription("First Campaign Description");
        campaign.setIsActive(true);

        //converting Campaign object to JSON string
        String inputJson = super.mapToJson(campaign);
        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.post(uri)
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .content(inputJson)).andReturn();

        //getting response status back and testing status code
        int status = mvcResult.getResponse().getStatus();
        assertEquals(200, status);

        //getting response content and converting it to Campaign object
        String content = mvcResult.getResponse().getContentAsString();
        Campaign returnedCampaign = super.mapFromJson(content, Campaign.class);

        //Testing new id was set and returned
        assertNotNull(returnedCampaign.getId());
    }
}
