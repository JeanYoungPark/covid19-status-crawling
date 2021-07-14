package com.jeanyoung.covid19status.services;

import com.jeanyoung.covid19status.models.KoreaStatus;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;

@Service
public class CovidDataService {
    private static String url = "http://ncov.mohw.go.kr/bdBoardList_Real.do?brdId=1&brdGubun=13";

    //@PostConstruct //실행하자마자 메소드를 실행하게 해준다.
    public List<KoreaStatus> getDatas() throws IOException {

        List<KoreaStatus> koreaStatsList = new ArrayList<>();
        Document doc = Jsoup.connect(url).get();
        Elements contents = doc.select(".data_table tbody tr");

        for (Element content : contents) {
            Elements td = content.select("td");

            KoreaStatus koreaStatus = KoreaStatus.builder()
                    .country(content.select("th").text())
                    .diffFromPrevDay(Integer.parseInt(td.get(0).text().replaceAll(",", "")))
                    .domesticPrevDay(Integer.parseInt(td.get(1).text().replaceAll(",", "")))
                    .overseasPrevDay(Integer.parseInt(td.get(2).text()))
                    .total(Integer.parseInt(td.get(3).text().replaceAll(",", "")))
                    .death(Integer.parseInt(td.get(6).text().replaceAll(",", "")))
                    .incidence(Double.parseDouble(td.get(7).text().replaceAll("-", "0")))
                    .build();

            koreaStatsList.add(koreaStatus);
        }
        return koreaStatsList;
    }
}
