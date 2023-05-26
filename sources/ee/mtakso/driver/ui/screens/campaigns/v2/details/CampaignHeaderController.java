package ee.mtakso.driver.ui.screens.campaigns.v2.details;

import android.view.View;
import android.widget.TextView;
import ee.mtakso.driver.network.client.campaign.Badge;
import ee.mtakso.driver.ui.screens.campaigns.v2.CampaignV2ExtKt;
import ee.mtakso.driver.ui.utils.ThemedImageKt;
import ee.mtakso.driver.uikit.utils.Dimens;
import ee.mtakso.driver.uikit.utils.ImageKt;
import ee.mtakso.driver.uikit.utils.ViewExtKt;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: CampaignHeaderController.kt */
/* loaded from: classes3.dex */
public final class CampaignHeaderController {

    /* renamed from: a  reason: collision with root package name */
    private final View f27472a;

    /* renamed from: b  reason: collision with root package name */
    private CampaignPeriodItemController f27473b;

    /* renamed from: c  reason: collision with root package name */
    public Map<Integer, View> f27474c;

    public CampaignHeaderController(View containerView) {
        Intrinsics.f(containerView, "containerView");
        this.f27474c = new LinkedHashMap();
        this.f27472a = containerView;
    }

    private final void c(TextView textView, Badge badge) {
        if (badge == null) {
            ViewExtKt.d(textView, false, 0, 2, null);
            return;
        }
        ViewExtKt.d(textView, false, 0, 3, null);
        textView.setText(badge.b());
        ViewExtKt.b(textView, CampaignV2ExtKt.a(badge.c()));
        if (badge.a() == null) {
            textView.setPaddingRelative(Dimens.c(6), textView.getPaddingTop(), Dimens.c(6), textView.getPaddingBottom());
            return;
        }
        ImageKt.d(ThemedImageKt.a(badge.a()), textView, Dimens.c(16), Dimens.c(16));
        textView.setPaddingRelative(Dimens.c(8), textView.getPaddingTop(), Dimens.c(8), textView.getPaddingBottom());
    }

    public View a(int i8) {
        View findViewById;
        Map<Integer, View> map = this.f27474c;
        View view = map.get(Integer.valueOf(i8));
        if (view == null) {
            View d8 = d();
            if (d8 == null || (findViewById = d8.findViewById(i8)) == null) {
                return null;
            }
            map.put(Integer.valueOf(i8), findViewById);
            return findViewById;
        }
        return view;
    }

    /* JADX WARN: Removed duplicated region for block: B:42:0x0144  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void b(ee.mtakso.driver.ui.screens.campaigns.v2.details.CampaignDetailsState r10) {
        /*
            Method dump skipped, instructions count: 329
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: ee.mtakso.driver.ui.screens.campaigns.v2.details.CampaignHeaderController.b(ee.mtakso.driver.ui.screens.campaigns.v2.details.CampaignDetailsState):void");
    }

    public View d() {
        return this.f27472a;
    }
}
