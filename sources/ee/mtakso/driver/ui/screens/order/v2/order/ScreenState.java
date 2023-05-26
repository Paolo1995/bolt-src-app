package ee.mtakso.driver.ui.screens.order.v2.order;

import ee.mtakso.driver.navigation.navigators.Navigator;
import ee.mtakso.driver.ui.screens.navigator_chooser.NavigationOption;
import ee.mtakso.driver.ui.screens.order.v2.map.NavigationMode;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ScreenState.kt */
/* loaded from: classes3.dex */
public final class ScreenState {

    /* renamed from: a  reason: collision with root package name */
    private final NavigationMode f32327a;

    /* renamed from: b  reason: collision with root package name */
    private final Navigator f32328b;

    /* renamed from: c  reason: collision with root package name */
    private final NavigationOption f32329c;

    /* renamed from: d  reason: collision with root package name */
    private final boolean f32330d;

    /* renamed from: e  reason: collision with root package name */
    private final ExtraInfo f32331e;

    /* renamed from: f  reason: collision with root package name */
    private final List<ChatButtonInfo> f32332f;

    /* renamed from: g  reason: collision with root package name */
    private final boolean f32333g;

    public ScreenState(NavigationMode currentNavMode, Navigator navigator, NavigationOption navigationOption, boolean z7, ExtraInfo extraInfo, List<ChatButtonInfo> chatInfo, boolean z8) {
        Intrinsics.f(currentNavMode, "currentNavMode");
        Intrinsics.f(navigator, "navigator");
        Intrinsics.f(chatInfo, "chatInfo");
        this.f32327a = currentNavMode;
        this.f32328b = navigator;
        this.f32329c = navigationOption;
        this.f32330d = z7;
        this.f32331e = extraInfo;
        this.f32332f = chatInfo;
        this.f32333g = z8;
    }

    public static /* synthetic */ ScreenState b(ScreenState screenState, NavigationMode navigationMode, Navigator navigator, NavigationOption navigationOption, boolean z7, ExtraInfo extraInfo, List list, boolean z8, int i8, Object obj) {
        if ((i8 & 1) != 0) {
            navigationMode = screenState.f32327a;
        }
        if ((i8 & 2) != 0) {
            navigator = screenState.f32328b;
        }
        Navigator navigator2 = navigator;
        if ((i8 & 4) != 0) {
            navigationOption = screenState.f32329c;
        }
        NavigationOption navigationOption2 = navigationOption;
        if ((i8 & 8) != 0) {
            z7 = screenState.f32330d;
        }
        boolean z9 = z7;
        if ((i8 & 16) != 0) {
            extraInfo = screenState.f32331e;
        }
        ExtraInfo extraInfo2 = extraInfo;
        List<ChatButtonInfo> list2 = list;
        if ((i8 & 32) != 0) {
            list2 = screenState.f32332f;
        }
        List list3 = list2;
        if ((i8 & 64) != 0) {
            z8 = screenState.f32333g;
        }
        return screenState.a(navigationMode, navigator2, navigationOption2, z9, extraInfo2, list3, z8);
    }

    public final ScreenState a(NavigationMode currentNavMode, Navigator navigator, NavigationOption navigationOption, boolean z7, ExtraInfo extraInfo, List<ChatButtonInfo> chatInfo, boolean z8) {
        Intrinsics.f(currentNavMode, "currentNavMode");
        Intrinsics.f(navigator, "navigator");
        Intrinsics.f(chatInfo, "chatInfo");
        return new ScreenState(currentNavMode, navigator, navigationOption, z7, extraInfo, chatInfo, z8);
    }

    public final List<ChatButtonInfo> c() {
        return this.f32332f;
    }

    public final NavigationMode d() {
        return this.f32327a;
    }

    public final ExtraInfo e() {
        return this.f32331e;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof ScreenState) {
            ScreenState screenState = (ScreenState) obj;
            return this.f32327a == screenState.f32327a && Intrinsics.a(this.f32328b, screenState.f32328b) && Intrinsics.a(this.f32329c, screenState.f32329c) && this.f32330d == screenState.f32330d && Intrinsics.a(this.f32331e, screenState.f32331e) && Intrinsics.a(this.f32332f, screenState.f32332f) && this.f32333g == screenState.f32333g;
        }
        return false;
    }

    public final NavigationOption f() {
        return this.f32329c;
    }

    public final Navigator g() {
        return this.f32328b;
    }

    public final boolean h() {
        return this.f32330d;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        int hashCode = ((this.f32327a.hashCode() * 31) + this.f32328b.hashCode()) * 31;
        NavigationOption navigationOption = this.f32329c;
        int hashCode2 = (hashCode + (navigationOption == null ? 0 : navigationOption.hashCode())) * 31;
        boolean z7 = this.f32330d;
        int i8 = z7;
        if (z7 != 0) {
            i8 = 1;
        }
        int i9 = (hashCode2 + i8) * 31;
        ExtraInfo extraInfo = this.f32331e;
        int hashCode3 = (((i9 + (extraInfo != null ? extraInfo.hashCode() : 0)) * 31) + this.f32332f.hashCode()) * 31;
        boolean z8 = this.f32333g;
        return hashCode3 + (z8 ? 1 : z8 ? 1 : 0);
    }

    public final boolean i() {
        return this.f32333g;
    }

    public String toString() {
        NavigationMode navigationMode = this.f32327a;
        Navigator navigator = this.f32328b;
        NavigationOption navigationOption = this.f32329c;
        boolean z7 = this.f32330d;
        ExtraInfo extraInfo = this.f32331e;
        List<ChatButtonInfo> list = this.f32332f;
        boolean z8 = this.f32333g;
        return "ScreenState(currentNavMode=" + navigationMode + ", navigator=" + navigator + ", navigationOption=" + navigationOption + ", sosButtonEnabled=" + z7 + ", extraInfo=" + extraInfo + ", chatInfo=" + list + ", isSafetyToolkitEnabled=" + z8 + ")";
    }
}
