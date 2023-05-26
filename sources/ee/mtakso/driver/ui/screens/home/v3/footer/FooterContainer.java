package ee.mtakso.driver.ui.screens.home.v3.footer;

import android.view.View;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: FooterContainer.kt */
/* loaded from: classes3.dex */
public final class FooterContainer {

    /* renamed from: a  reason: collision with root package name */
    private final View f30006a;

    /* renamed from: b  reason: collision with root package name */
    public Map<Integer, View> f30007b;

    public FooterContainer(View containerView) {
        Intrinsics.f(containerView, "containerView");
        this.f30007b = new LinkedHashMap();
        this.f30006a = containerView;
    }

    public View a(int i8) {
        View findViewById;
        Map<Integer, View> map = this.f30007b;
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
        return this.f30006a;
    }
}
