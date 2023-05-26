package ee.mtakso.driver.ui.screens.splash;

import android.app.Activity;
import android.view.View;
import ee.mtakso.driver.R;
import ee.mtakso.driver.ui.screens.splash.DisabledBannerDelegate;
import ee.mtakso.driver.uicore.utils.ViewExtKt;
import ee.mtakso.driver.uikit.widgets.RoundButton;
import ee.mtakso.driver.utils.AppResolver;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DisabledBannerDelegate.kt */
/* loaded from: classes5.dex */
public final class DisabledBannerDelegate {

    /* renamed from: a  reason: collision with root package name */
    private final Activity f33436a;

    /* renamed from: b  reason: collision with root package name */
    private final View f33437b;

    /* renamed from: c  reason: collision with root package name */
    private final AppResolver f33438c;

    /* renamed from: d  reason: collision with root package name */
    public Map<Integer, View> f33439d;

    public DisabledBannerDelegate(Activity activity, View containerView, AppResolver appResolver) {
        Intrinsics.f(activity, "activity");
        Intrinsics.f(containerView, "containerView");
        Intrinsics.f(appResolver, "appResolver");
        this.f33439d = new LinkedHashMap();
        this.f33436a = activity;
        this.f33437b = containerView;
        this.f33438c = appResolver;
        ((RoundButton) b(R.id.updateButton)).setOnClickListener(new View.OnClickListener() { // from class: f5.a
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                DisabledBannerDelegate.c(DisabledBannerDelegate.this, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void c(DisabledBannerDelegate this$0, View view) {
        Intrinsics.f(this$0, "this$0");
        this$0.f33438c.a();
        this$0.f33436a.finish();
    }

    public View b(int i8) {
        View findViewById;
        Map<Integer, View> map = this.f33439d;
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

    public View d() {
        return this.f33437b;
    }

    public final void e() {
        ViewExtKt.e(d(), true, 0, 2, null);
    }
}
