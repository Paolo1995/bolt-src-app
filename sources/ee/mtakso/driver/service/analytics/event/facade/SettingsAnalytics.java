package ee.mtakso.driver.service.analytics.event.facade;

import ee.mtakso.driver.network.client.settings.SearchCategory;
import ee.mtakso.driver.service.analytics.event.facade.OrderAnalytics;
import eu.bolt.driver.core.theme.AppThemeMode;
import java.util.List;

/* compiled from: SettingsAnalytics.kt */
/* loaded from: classes3.dex */
public interface SettingsAnalytics {
    void A2();

    void G1(List<String> list, String str);

    void Q1();

    void a(boolean z7, OrderAnalytics.EventSource eventSource);

    void d2(AppThemeMode appThemeMode);

    void e(List<SearchCategory> list);

    void n1(AppThemeMode appThemeMode);

    void n4(boolean z7);

    void u0(boolean z7);
}
