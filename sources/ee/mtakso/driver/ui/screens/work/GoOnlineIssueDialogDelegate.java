package ee.mtakso.driver.ui.screens.work;

import androidx.fragment.app.Fragment;
import ee.mtakso.driver.network.client.driver.PricingData;
import ee.mtakso.driver.network.client.driver.PricingRequiredAction;
import ee.mtakso.driver.service.analytics.event.facade.DriverPricingAnalytics;
import ee.mtakso.driver.service.modules.status.GoOnlineIssue;
import eu.bolt.android.engine.html.HtmlEngine;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: GoOnlineIssueDialogDelegate.kt */
/* loaded from: classes5.dex */
public final class GoOnlineIssueDialogDelegate {

    /* renamed from: a  reason: collision with root package name */
    private final LocationRequiredDialogDelegate f33643a;

    /* renamed from: b  reason: collision with root package name */
    private final PricingRequiredDialogDelegate f33644b;

    public GoOnlineIssueDialogDelegate(DriverPricingAnalytics driverPricingAnalytics, HtmlEngine htmlEngine) {
        Intrinsics.f(driverPricingAnalytics, "driverPricingAnalytics");
        Intrinsics.f(htmlEngine, "htmlEngine");
        this.f33643a = new LocationRequiredDialogDelegate();
        this.f33644b = new PricingRequiredDialogDelegate(driverPricingAnalytics, htmlEngine);
    }

    public final void a(Fragment fragment) {
        Intrinsics.f(fragment, "fragment");
        this.f33643a.c(fragment);
        this.f33644b.g(fragment);
    }

    public final void b(Function0<Unit> function0) {
        Intrinsics.f(function0, "<set-?>");
        this.f33643a.d(function0);
    }

    public final void c(Function2<? super PricingRequiredAction, ? super PricingData, Unit> function2) {
        Intrinsics.f(function2, "<set-?>");
        this.f33644b.h(function2);
    }

    public final void d(Function1<? super PricingRequiredAction, Unit> function1) {
        Intrinsics.f(function1, "<set-?>");
        this.f33644b.i(function1);
    }

    public final void e(Fragment fragment, GoOnlineIssue issue) {
        Intrinsics.f(fragment, "fragment");
        Intrinsics.f(issue, "issue");
        if (issue instanceof GoOnlineIssue.LocationRequired) {
            this.f33643a.f(fragment);
        } else if (issue instanceof GoOnlineIssue.PricingNotChosen) {
            this.f33644b.k(fragment, (GoOnlineIssue.PricingNotChosen) issue);
        } else if (issue instanceof GoOnlineIssue.PricingConfirmation) {
            this.f33644b.j(fragment, (GoOnlineIssue.PricingConfirmation) issue);
        }
    }
}
