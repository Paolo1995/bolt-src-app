package ee.mtakso.driver.ui.screens.dialogs.rateme;

import android.content.Context;
import android.content.res.Resources;
import androidx.fragment.app.FragmentActivity;
import ee.mtakso.driver.R;
import ee.mtakso.driver.param.RateMeGenericModel;
import ee.mtakso.driver.param.RateMeModel;
import ee.mtakso.driver.param.RateMePrefsManager;
import ee.mtakso.driver.service.analytics.event.facade.RateMeAnalytics;
import ee.mtakso.driver.ui.screens.dialogs.rateme.RateMeDialog;
import ee.mtakso.driver.uicore.utils.FragmentUtils;
import javax.inject.Inject;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: RateMeDialogDelegate.kt */
/* loaded from: classes3.dex */
public final class RateMeDialogDelegate {

    /* renamed from: a  reason: collision with root package name */
    private final RateMePrefsManager f28372a;

    /* renamed from: b  reason: collision with root package name */
    private final RateMeAnalytics f28373b;

    @Inject
    public RateMeDialogDelegate(RateMePrefsManager rateMePrefsManager, RateMeAnalytics rateMeAnalytics) {
        Intrinsics.f(rateMePrefsManager, "rateMePrefsManager");
        Intrinsics.f(rateMeAnalytics, "rateMeAnalytics");
        this.f28372a = rateMePrefsManager;
        this.f28373b = rateMeAnalytics;
    }

    private final void a(RateMeGenericModel rateMeGenericModel, FragmentActivity fragmentActivity, Boolean bool) {
        String str;
        RateMeDialog.RateAction rateAction;
        this.f28373b.z();
        if (this.f28372a.l()) {
            return;
        }
        RateMeDialog.Companion companion = RateMeDialog.f28351u;
        int a8 = rateMeGenericModel.a();
        String d8 = rateMeGenericModel.d();
        String c8 = rateMeGenericModel.c();
        if (c8 == null) {
            str = "";
        } else {
            str = c8;
        }
        String b8 = rateMeGenericModel.b();
        if (b8 == null) {
            b8 = "";
        }
        if (Intrinsics.a(bool, Boolean.TRUE)) {
            rateAction = RateMeDialog.RateAction.LIKE;
        } else if (Intrinsics.a(bool, Boolean.FALSE)) {
            rateAction = RateMeDialog.RateAction.DISLIKE;
        } else {
            rateAction = RateMeDialog.RateAction.NONE;
        }
        FragmentUtils.c(companion.a(new RateMeDialog.DialogConfig(a8, d8, str, b8, rateAction)), fragmentActivity, "rate_dialog");
    }

    static /* synthetic */ void b(RateMeDialogDelegate rateMeDialogDelegate, RateMeGenericModel rateMeGenericModel, FragmentActivity fragmentActivity, Boolean bool, int i8, Object obj) {
        if ((i8 & 2) != 0) {
            bool = null;
        }
        rateMeDialogDelegate.a(rateMeGenericModel, fragmentActivity, bool);
    }

    private final RateMeGenericModel e(RateMeModel rateMeModel, Resources resources) {
        if (rateMeModel instanceof RateMeGenericModel) {
            return (RateMeGenericModel) rateMeModel;
        }
        if (Intrinsics.a(rateMeModel, RateMeModel.TenRides.f23228f)) {
            String string = resources.getString(R.string.rate_dialog_ten_ride_title);
            Intrinsics.e(string, "resources.getString(R.st…te_dialog_ten_ride_title)");
            return new RateMeGenericModel(string, resources.getString(R.string.rate_dialog_default_title), null, R.drawable.ic_rate_hands, 4, null);
        } else if (Intrinsics.a(rateMeModel, RateMeModel.HundredRides.f23227f)) {
            String string2 = resources.getString(R.string.rate_dialog_hundred_ride_title);
            Intrinsics.e(string2, "resources.getString(R.st…ialog_hundred_ride_title)");
            return new RateMeGenericModel(string2, resources.getString(R.string.rate_dialog_default_title), null, R.drawable.ic_rate_hands, 4, null);
        } else if (Intrinsics.a(rateMeModel, RateMeModel.Tips.f23229f)) {
            String string3 = resources.getString(R.string.rate_dialog_default_title);
            Intrinsics.e(string3, "resources.getString(R.st…ate_dialog_default_title)");
            return new RateMeGenericModel(string3, resources.getString(R.string.rate_dialog_default_message), null, 0, 12, null);
        } else {
            String string4 = resources.getString(R.string.rate_dialog_default_title);
            Intrinsics.e(string4, "resources.getString(R.st…ate_dialog_default_title)");
            return new RateMeGenericModel(string4, resources.getString(R.string.rate_dialog_default_message), null, 0, 12, null);
        }
    }

    public final void c(RateMeModel rateMeModel, Context context, FragmentActivity activity) {
        Intrinsics.f(rateMeModel, "rateMeModel");
        Intrinsics.f(context, "context");
        Intrinsics.f(activity, "activity");
        if (!this.f28372a.q(rateMeModel)) {
            Resources resources = context.getResources();
            Intrinsics.e(resources, "context.resources");
            b(this, e(rateMeModel, resources), activity, null, 2, null);
        }
        this.f28372a.d(rateMeModel);
        this.f28372a.f();
    }

    public final void d(RateMeModel rateMeModel, boolean z7, Context context, FragmentActivity activity) {
        Intrinsics.f(rateMeModel, "rateMeModel");
        Intrinsics.f(context, "context");
        Intrinsics.f(activity, "activity");
        Resources resources = context.getResources();
        Intrinsics.e(resources, "context.resources");
        a(e(rateMeModel, resources), activity, Boolean.valueOf(z7));
        this.f28372a.f();
    }
}
