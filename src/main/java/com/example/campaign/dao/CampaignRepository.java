package com.example.campaign.dao;

import com.example.campaign.models.Campaign;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Dao for Campaign entity currently using H2 in-memory database for presentation purposes
 *
 * Additional custom query methods can be build in this file
 */
public interface CampaignRepository extends JpaRepository<Campaign, Long> {
}
