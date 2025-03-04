package com.cinema.service;

import com.cinema.model.Seat;
import com.cinema.repository.SeatRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SeatService {
    @Autowired
    private SeatRepository seatRepository;

    public List<Seat> getAllSeats() {
        return seatRepository.findAll();
    }

    public Seat bookSeat(Long id) {
        Seat seat = seatRepository.findById(id).orElseThrow(() -> new RuntimeException("Seat not found"));
        if (seat.isBooked()) {
            throw new RuntimeException("Seat already booked");
        }
        seat.setBooked(true);
        return seatRepository.save(seat);
    }
}
