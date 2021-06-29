package com.jeanyoung.covid19status.service;

import com.jeanyoung.covid19status.models.KoreaStatus;
import com.jeanyoung.covid19status.services.CovidDataService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.imageio.IIOException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CovidDataServiceTest {
    @Autowired
    CovidDataService covidDataService;

    @Test
    public void getKoreaStatus_test() throws IOException {
        List<KoreaStatus> covidList = new ArrayList<>();

        covidList = covidDataService.getDatas();

        assertThat(covidList.get(0).getCountry()).isEqualTo("합계");
    }
}
