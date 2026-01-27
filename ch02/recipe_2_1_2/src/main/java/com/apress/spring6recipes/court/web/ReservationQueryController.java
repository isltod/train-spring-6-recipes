package com.apress.spring6recipes.court.web;

import com.apress.spring6recipes.court.domain.Reservation;
import com.apress.spring6recipes.court.service.ReservationService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Collections;

@Controller
@RequestMapping("/reservationQuery")
public class ReservationQueryController {

    private final ReservationService reservationService;

    public ReservationQueryController(ReservationService reservationService) {
        this.reservationService = reservationService;
    }

    // 이건 그냥 기본으로 둔 거라고...
    // 매개변수와 로직이 없는 것은 템플릿에 하드코딩 된 걸 뷰에서 보여주겠다..
    // 반환값이 없는 것은 들어온 URL 그대로 뷰 이름이 된다라...
    // 폼을 초기에 로드할 때 호출된다? 그러니까 일단 reservationQuery.jsp를 그대로 보여준다...
    @GetMapping
    public void setupForm() {
    }

    @PostMapping
    public String submitForm(@RequestParam("courtName") String courtName, Model model) {
        var reservations = Collections.<Reservation>emptyList();
        if (courtName != null) {
            reservations = reservationService.query(courtName);
        }
        model.addAttribute("reservations", reservations);
        return "reservationQuery";
    }
}
