package ee.mtakso.driver.ui.common.generictreeviewstate;

import ee.mtakso.driver.R;
import ee.mtakso.driver.uicore.utils.Dimens;
import ee.mtakso.driver.uikit.recyclerview.ListModel;
import ee.mtakso.driver.uikit.utils.Color;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: GenericViewState.kt */
/* loaded from: classes3.dex */
public interface GenericViewState {
    boolean a();

    ListModel b(String str, int i8, int i9);

    void c(boolean z7);

    boolean d();

    /* compiled from: GenericViewState.kt */
    /* loaded from: classes3.dex */
    public enum Divider {
        SECTION(new Color.Attr(R.attr.dynamicNeutral01), Dimens.c(8.0f), true, true),
        ITEM(new Color.Attr(R.attr.dynamicNeutral01), Dimens.c(1.0f), false, false, 8, null);
        

        /* renamed from: f  reason: collision with root package name */
        private final Color f26341f;

        /* renamed from: g  reason: collision with root package name */
        private final float f26342g;

        /* renamed from: h  reason: collision with root package name */
        private final boolean f26343h;

        /* renamed from: i  reason: collision with root package name */
        private final boolean f26344i;

        Divider(Color color, float f8, boolean z7, boolean z8) {
            this.f26341f = color;
            this.f26342g = f8;
            this.f26343h = z7;
            this.f26344i = z8;
        }

        public final Color c() {
            return this.f26341f;
        }

        public final float e() {
            return this.f26342g;
        }

        public final boolean f() {
            return this.f26344i;
        }

        public final boolean h() {
            return this.f26343h;
        }

        /* synthetic */ Divider(Color color, float f8, boolean z7, boolean z8, int i8, DefaultConstructorMarker defaultConstructorMarker) {
            this(color, f8, z7, (i8 & 8) != 0 ? false : z8);
        }
    }
}
