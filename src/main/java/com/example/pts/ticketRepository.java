package com.example.pts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ticketRepository extends JpaRepository<ticketModel, Long> {
    @Query("SELECT new com.example.pts.RevenueData(t.fromStation, MONTH(t.date), SUM(t.fare)) FROM ticketModel t GROUP BY t.fromStation, MONTH(t.date) ORDER BY t.fromStation, MONTH(t.date)")
    List<RevenueData> getRevenueByStationAndMonth();
}