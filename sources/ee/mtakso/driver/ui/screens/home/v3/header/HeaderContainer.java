package ee.mtakso.driver.ui.screens.home.v3.header;

import android.view.View;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: HeaderContainer.kt */
/* loaded from: classes3.dex */
public final class HeaderContainer {

    /* renamed from: a  reason: collision with root package name */
    private final View f30024a;

    /* renamed from: b  reason: collision with root package name */
    private final View f30025b;

    /* renamed from: c  reason: collision with root package name */
    private final View f30026c;

    /* renamed from: d  reason: collision with root package name */
    public Map<Integer, View> f30027d;

    public HeaderContainer(View containerView, View destinationHint, View destinationHintDismissTouchArea) {
        Intrinsics.f(containerView, "containerView");
        Intrinsics.f(destinationHint, "destinationHint");
        Intrinsics.f(destinationHintDismissTouchArea, "destinationHintDismissTouchArea");
        this.f30027d = new LinkedHashMap();
        this.f30024a = containerView;
        this.f30025b = destinationHint;
        this.f30026c = destinationHintDismissTouchArea;
    }

    public View a(int i8) {
        View findViewById;
        Map<Integer, View> map = this.f30027d;
        View view = map.get(Integer.valueOf(i8));
        if (view == null) {
            View b8 = b();
            if (b8 == null || (findViewById = b8.findViewById(i8)) == null) {
                return null;
            }
            map.put(Integer.valueOf(i8), findViewById);
            return findViewById;
        }
        return view;
    }

    public View b() {
        return this.f30024a;
    }

    public final View c() {
        return this.f30025b;
    }

    public final View d() {
        return this.f30026c;
    }
}
