package kr.grace.banktracnsaction.interfaces;

import kr.grace.banktracnsaction.SummaryStatistics;

/**
 * @author : Eunmo Hong
 * @since : 2020/06/24
 */

public interface Exporter {
    String export(SummaryStatistics summaryStatistics);
}
