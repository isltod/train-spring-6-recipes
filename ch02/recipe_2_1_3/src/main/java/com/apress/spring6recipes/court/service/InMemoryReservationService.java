package com.apress.spring6recipes.court.service;

import com.apress.spring6recipes.court.domain.Player;
import com.apress.spring6recipes.court.domain.Reservation;
import com.apress.spring6recipes.court.domain.SportType;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class InMemoryReservationService implements ReservationService {

    private static final SportType TENNIS = new SportType(1, "Tennis");

    // List 상속, 모든 함수에 Synchronized 키워드 적용, 스레드 안전...
    private final List<Reservation> reservations = Collections.synchronizedList(new ArrayList<>());

    public InMemoryReservationService() {

        var roger = new Player("Roger");
        var james = new Player("James");
        var date = LocalDate.of(2026, 1, 25);
        reservations.add(new Reservation("Tennis #1", date, 16, roger, TENNIS));
        reservations.add(new Reservation("Tennis #2", date, 20, james, TENNIS));
    }

    @Override
    public List<Reservation> query(String courtName) {
        return this.reservations.stream()
                .filter(reservation ->
                        StringUtils.startsWithIgnoreCase(reservation.getCourtName(), courtName))
                .collect(Collectors.toList());
    }
}
