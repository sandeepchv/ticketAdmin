package com.example.pts;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class ticketServiceImplementation implements ticketService{

    @Autowired
    ticketRepository temp;

    public List<RevenueData> getRevenueByStationAndMonth(){
        return (List<RevenueData>)temp.getRevenueByStationAndMonth();
    }
}