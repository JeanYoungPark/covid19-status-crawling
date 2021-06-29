package com.jeanyoung.covid19status.models;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Getter
@Builder
@ToString
public class KoreaStatus {
    private String country; //도시명
    private int diffFromPrevDay; //전일대비확진환자증감
    private int domesticPrevDay; //국내발생
    private int overseasPrevDay; //해외유입
    private int total; //확진환자수
    private int death; //사망자수
    private double incidence; //발병률
}
