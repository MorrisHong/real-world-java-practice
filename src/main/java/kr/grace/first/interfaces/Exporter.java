package kr.grace.first.interfaces;

import kr.grace.first.SummaryStatistics;

/**
 * @author : Eunmo Hong
 * @since : 2020/06/24
 */

public interface Exporter {
    String export(SummaryStatistics summaryStatistics);
}
