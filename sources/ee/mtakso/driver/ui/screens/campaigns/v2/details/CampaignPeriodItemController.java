package ee.mtakso.driver.ui.screens.campaigns.v2.details;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import ee.mtakso.driver.R;
import ee.mtakso.driver.network.client.campaign.Periods;
import ee.mtakso.driver.uicore.components.views.ExpandableTextView;
import ee.mtakso.driver.uikit.utils.ViewExtKt;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: CampaignPeriodItemController.kt */
/* loaded from: classes3.dex */
public final class CampaignPeriodItemController {

    /* renamed from: a  reason: collision with root package name */
    private final View f27484a;

    /* renamed from: b  reason: collision with root package name */
    public Map<Integer, View> f27485b = new LinkedHashMap();

    public CampaignPeriodItemController(View view) {
        this.f27484a = view;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void e(CampaignPeriodItemController this$0, View view) {
        Intrinsics.f(this$0, "this$0");
        ((ExpandableTextView) this$0.c(R.id.periodExpandableText)).g();
        TextView expandPeriodText = (TextView) this$0.c(R.id.expandPeriodText);
        Intrinsics.e(expandPeriodText, "expandPeriodText");
        ViewExtKt.d(expandPeriodText, false, 0, 2, null);
        ImageView collapsePeriodImage = (ImageView) this$0.c(R.id.collapsePeriodImage);
        Intrinsics.e(collapsePeriodImage, "collapsePeriodImage");
        ViewExtKt.d(collapsePeriodImage, false, 0, 3, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void f(CampaignPeriodItemController this$0, View view) {
        Intrinsics.f(this$0, "this$0");
        ((ExpandableTextView) this$0.c(R.id.periodExpandableText)).f();
        TextView expandPeriodText = (TextView) this$0.c(R.id.expandPeriodText);
        Intrinsics.e(expandPeriodText, "expandPeriodText");
        ViewExtKt.d(expandPeriodText, false, 0, 3, null);
        ImageView collapsePeriodImage = (ImageView) this$0.c(R.id.collapsePeriodImage);
        Intrinsics.e(collapsePeriodImage, "collapsePeriodImage");
        ViewExtKt.d(collapsePeriodImage, false, 0, 2, null);
    }

    public View c(int i8) {
        View findViewById;
        Map<Integer, View> map = this.f27485b;
        View view = map.get(Integer.valueOf(i8));
        if (view == null) {
            View g8 = g();
            if (g8 == null || (findViewById = g8.findViewById(i8)) == null) {
                return null;
            }
            map.put(Integer.valueOf(i8), findViewById);
            return findViewById;
        }
        return view;
    }

    public final void d(Periods periods, String str) {
        boolean z7 = true;
        if (periods != null && periods.b().size() == 1) {
            int i8 = R.id.periodExpandableText;
            ExpandableTextView periodExpandableText = (ExpandableTextView) c(i8);
            Intrinsics.e(periodExpandableText, "periodExpandableText");
            ViewExtKt.d(periodExpandableText, false, 0, 3, null);
            ((ExpandableTextView) c(i8)).setCollapsedText(periods.b().get(0));
            ((ExpandableTextView) c(i8)).f();
            TextView expandPeriodText = (TextView) c(R.id.expandPeriodText);
            Intrinsics.e(expandPeriodText, "expandPeriodText");
            ViewExtKt.d(expandPeriodText, false, 0, 2, null);
            ImageView collapsePeriodImage = (ImageView) c(R.id.collapsePeriodImage);
            Intrinsics.e(collapsePeriodImage, "collapsePeriodImage");
            ViewExtKt.d(collapsePeriodImage, false, 0, 2, null);
        } else if (periods != null && periods.b().size() == 2) {
            int i9 = R.id.periodExpandableText;
            ExpandableTextView periodExpandableText2 = (ExpandableTextView) c(i9);
            Intrinsics.e(periodExpandableText2, "periodExpandableText");
            ViewExtKt.d(periodExpandableText2, false, 0, 3, null);
            String str2 = periods.b().get(0);
            String str3 = periods.b().get(1);
            ((ExpandableTextView) c(i9)).setCollapsedText(((Object) str2) + "\n" + ((Object) str3));
            ((ExpandableTextView) c(i9)).f();
            TextView expandPeriodText2 = (TextView) c(R.id.expandPeriodText);
            Intrinsics.e(expandPeriodText2, "expandPeriodText");
            ViewExtKt.d(expandPeriodText2, false, 0, 2, null);
            ImageView collapsePeriodImage2 = (ImageView) c(R.id.collapsePeriodImage);
            Intrinsics.e(collapsePeriodImage2, "collapsePeriodImage");
            ViewExtKt.d(collapsePeriodImage2, false, 0, 2, null);
        } else if (periods != null && periods.b().size() > 2) {
            int i10 = R.id.periodExpandableText;
            ExpandableTextView periodExpandableText3 = (ExpandableTextView) c(i10);
            Intrinsics.e(periodExpandableText3, "periodExpandableText");
            ViewExtKt.d(periodExpandableText3, false, 0, 3, null);
            ((ExpandableTextView) c(i10)).setCollapsedText(periods.b().get(0));
            ((ExpandableTextView) c(i10)).f();
            ExpandableTextView expandableTextView = (ExpandableTextView) c(i10);
            Iterator<T> it = periods.b().iterator();
            if (it.hasNext()) {
                Object next = it.next();
                while (it.hasNext()) {
                    next = ((String) next) + "\n" + ((String) it.next());
                }
                expandableTextView.setExpandedText((CharSequence) next);
                int i11 = R.id.expandPeriodText;
                TextView expandPeriodText3 = (TextView) c(i11);
                Intrinsics.e(expandPeriodText3, "expandPeriodText");
                ViewExtKt.d(expandPeriodText3, false, 0, 3, null);
                ((TextView) c(i11)).setText(periods.a());
                ImageView collapsePeriodImage3 = (ImageView) c(R.id.collapsePeriodImage);
                Intrinsics.e(collapsePeriodImage3, "collapsePeriodImage");
                ViewExtKt.d(collapsePeriodImage3, false, 0, 2, null);
            } else {
                throw new UnsupportedOperationException("Empty collection can't be reduced.");
            }
        } else {
            int i12 = R.id.periodExpandableText;
            ExpandableTextView periodExpandableText4 = (ExpandableTextView) c(i12);
            Intrinsics.e(periodExpandableText4, "periodExpandableText");
            if (str == null) {
                z7 = false;
            }
            ViewExtKt.d(periodExpandableText4, z7, 0, 2, null);
            ((ExpandableTextView) c(i12)).setCollapsedText(str);
            ((ExpandableTextView) c(i12)).f();
            TextView expandPeriodText4 = (TextView) c(R.id.expandPeriodText);
            Intrinsics.e(expandPeriodText4, "expandPeriodText");
            ViewExtKt.d(expandPeriodText4, false, 0, 2, null);
            ImageView collapsePeriodImage4 = (ImageView) c(R.id.collapsePeriodImage);
            Intrinsics.e(collapsePeriodImage4, "collapsePeriodImage");
            ViewExtKt.d(collapsePeriodImage4, false, 0, 2, null);
        }
        ((TextView) c(R.id.expandPeriodText)).setOnClickListener(new View.OnClickListener() { // from class: ee.mtakso.driver.ui.screens.campaigns.v2.details.g
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                CampaignPeriodItemController.e(CampaignPeriodItemController.this, view);
            }
        });
        ((ImageView) c(R.id.collapsePeriodImage)).setOnClickListener(new View.OnClickListener() { // from class: ee.mtakso.driver.ui.screens.campaigns.v2.details.h
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                CampaignPeriodItemController.f(CampaignPeriodItemController.this, view);
            }
        });
    }

    public View g() {
        return this.f27484a;
    }
}
