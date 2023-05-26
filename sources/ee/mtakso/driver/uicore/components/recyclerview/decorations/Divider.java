package ee.mtakso.driver.uicore.components.recyclerview.decorations;

import ee.mtakso.driver.uicore.R$color;
import ee.mtakso.driver.uicore.utils.Dimens;
import ee.mtakso.driver.uikit.utils.Color;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Divider.kt */
/* loaded from: classes5.dex */
public final class Divider implements DividerModel {

    /* renamed from: a  reason: collision with root package name */
    private final boolean f34820a;

    /* renamed from: b  reason: collision with root package name */
    private final boolean f34821b;

    /* renamed from: c  reason: collision with root package name */
    private final boolean f34822c;

    /* renamed from: d  reason: collision with root package name */
    private final Color f34823d;

    /* renamed from: e  reason: collision with root package name */
    private final Color f34824e;

    /* renamed from: f  reason: collision with root package name */
    private final Float f34825f;

    public Divider() {
        this(false, false, false, null, null, null, 63, null);
    }

    public Divider(boolean z7, boolean z8, boolean z9, Color color, Color color2, Float f8) {
        this.f34820a = z7;
        this.f34821b = z8;
        this.f34822c = z9;
        this.f34823d = color;
        this.f34824e = color2;
        this.f34825f = f8;
    }

    @Override // ee.mtakso.driver.uicore.components.recyclerview.decorations.DividerModel
    public Color d() {
        return this.f34823d;
    }

    @Override // ee.mtakso.driver.uicore.components.recyclerview.decorations.DividerModel
    public boolean e() {
        return this.f34820a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof Divider) {
            Divider divider = (Divider) obj;
            return e() == divider.e() && j() == divider.j() && k() == divider.k() && Intrinsics.a(d(), divider.d()) && Intrinsics.a(f(), divider.f()) && Intrinsics.a(i(), divider.i());
        }
        return false;
    }

    @Override // ee.mtakso.driver.uicore.components.recyclerview.decorations.DividerModel
    public Color f() {
        return this.f34824e;
    }

    public int hashCode() {
        boolean e8 = e();
        int i8 = e8;
        if (e8) {
            i8 = 1;
        }
        int i9 = i8 * 31;
        boolean j8 = j();
        int i10 = j8;
        if (j8) {
            i10 = 1;
        }
        int i11 = (i9 + i10) * 31;
        boolean k8 = k();
        return ((((((i11 + (k8 ? 1 : k8)) * 31) + (d() == null ? 0 : d().hashCode())) * 31) + (f() == null ? 0 : f().hashCode())) * 31) + (i() != null ? i().hashCode() : 0);
    }

    @Override // ee.mtakso.driver.uicore.components.recyclerview.decorations.DividerModel
    public Float i() {
        return this.f34825f;
    }

    @Override // ee.mtakso.driver.uicore.components.recyclerview.decorations.DividerModel
    public boolean j() {
        return this.f34821b;
    }

    @Override // ee.mtakso.driver.uicore.components.recyclerview.decorations.DividerModel
    public boolean k() {
        return this.f34822c;
    }

    public String toString() {
        boolean e8 = e();
        boolean j8 = j();
        boolean k8 = k();
        Color d8 = d();
        Color f8 = f();
        Float i8 = i();
        return "Divider(isDividerEnabled=" + e8 + ", isDividerAtTheTop=" + j8 + ", shouldIgnoreMargins=" + k8 + ", dividerColor=" + d8 + ", dividerBackColor=" + f8 + ", dividerSize=" + i8 + ")";
    }

    public /* synthetic */ Divider(boolean z7, boolean z8, boolean z9, Color color, Color color2, Float f8, int i8, DefaultConstructorMarker defaultConstructorMarker) {
        this((i8 & 1) != 0 ? true : z7, (i8 & 2) != 0 ? false : z8, (i8 & 4) == 0 ? z9 : false, (i8 & 8) != 0 ? new Color.Res(R$color.f34586k) : color, (i8 & 16) != 0 ? null : color2, (i8 & 32) != 0 ? Float.valueOf(Dimens.c(1.0f)) : f8);
    }
}
