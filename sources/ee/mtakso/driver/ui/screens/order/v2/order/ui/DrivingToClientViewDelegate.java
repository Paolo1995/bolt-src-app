package ee.mtakso.driver.ui.screens.order.v2.order.ui;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import ee.mtakso.driver.R;
import ee.mtakso.driver.uicore.utils.ViewExtKt;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DrivingToClientViewDelegate.kt */
/* loaded from: classes3.dex */
public final class DrivingToClientViewDelegate {

    /* renamed from: a  reason: collision with root package name */
    private final View f32377a;

    /* renamed from: b  reason: collision with root package name */
    public Map<Integer, View> f32378b;

    public DrivingToClientViewDelegate(View containerView) {
        Intrinsics.f(containerView, "containerView");
        this.f32378b = new LinkedHashMap();
        this.f32377a = containerView;
    }

    private final void b(String str) {
        boolean z7;
        int i8 = R.id.clientRating;
        ((TextView) a(i8)).setText(str);
        TextView clientRating = (TextView) a(i8);
        Intrinsics.e(clientRating, "clientRating");
        boolean z8 = true;
        if (str != null) {
            z7 = true;
        } else {
            z7 = false;
        }
        ViewExtKt.e(clientRating, z7, 0, 2, null);
        ImageView clientRatingAsterisk = (ImageView) a(R.id.clientRatingAsterisk);
        Intrinsics.e(clientRatingAsterisk, "clientRatingAsterisk");
        if (str == null) {
            z8 = false;
        }
        ViewExtKt.e(clientRatingAsterisk, z8, 0, 2, null);
    }

    private final void c(String str, String str2) {
        boolean z7;
        boolean z8;
        boolean z9 = true;
        if (str != null && str2 != null) {
            z7 = true;
        } else {
            z7 = false;
        }
        if (str == null && str2 != null) {
            z8 = true;
        } else {
            z8 = false;
        }
        if (!z7 && !z8) {
            z9 = false;
        }
        TextView clientRatingSeparator = (TextView) a(R.id.clientRatingSeparator);
        Intrinsics.e(clientRatingSeparator, "clientRatingSeparator");
        ViewExtKt.e(clientRatingSeparator, z9, 0, 2, null);
    }

    private final void d(String str) {
        boolean z7;
        int i8 = R.id.clientRidesCount;
        ((TextView) a(i8)).setText(str);
        TextView clientRidesCount = (TextView) a(i8);
        Intrinsics.e(clientRidesCount, "clientRidesCount");
        if (str != null) {
            z7 = true;
        } else {
            z7 = false;
        }
        ViewExtKt.e(clientRidesCount, z7, 0, 2, null);
    }

    public View a(int i8) {
        View findViewById;
        Map<Integer, View> map = this.f32378b;
        View view = map.get(Integer.valueOf(i8));
        if (view == null) {
            View e8 = e();
            if (e8 == null || (findViewById = e8.findViewById(i8)) == null) {
                return null;
            }
            map.put(Integer.valueOf(i8), findViewById);
            return findViewById;
        }
        return view;
    }

    public View e() {
        return this.f32377a;
    }

    public final void f(String str, String str2) {
        b(str);
        c(str, str2);
        d(str2);
    }
}
