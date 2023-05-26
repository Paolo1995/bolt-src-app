package ee.mtakso.driver.uicore.components.recyclerview.decorations;

import ee.mtakso.driver.uicore.R$color;
import ee.mtakso.driver.uicore.utils.Dimens;
import ee.mtakso.driver.uikit.utils.Color;

/* compiled from: Divider.kt */
/* loaded from: classes5.dex */
public final class NoDivider implements DividerModel {

    /* renamed from: a  reason: collision with root package name */
    public static final NoDivider f34829a = new NoDivider();

    /* renamed from: b  reason: collision with root package name */
    private static final boolean f34830b = false;

    /* renamed from: c  reason: collision with root package name */
    private static final boolean f34831c = false;

    /* renamed from: d  reason: collision with root package name */
    private static final boolean f34832d = false;

    /* renamed from: e  reason: collision with root package name */
    private static final Color f34833e;

    /* renamed from: f  reason: collision with root package name */
    private static final Color f34834f;

    /* renamed from: g  reason: collision with root package name */
    private static final float f34835g;

    static {
        int i8 = R$color.f34586k;
        f34833e = new Color.Res(i8);
        f34834f = new Color.Res(i8);
        f34835g = Dimens.c(0.0f);
    }

    private NoDivider() {
    }

    @Override // ee.mtakso.driver.uicore.components.recyclerview.decorations.DividerModel
    public Color d() {
        return f34833e;
    }

    @Override // ee.mtakso.driver.uicore.components.recyclerview.decorations.DividerModel
    public boolean e() {
        return f34830b;
    }

    @Override // ee.mtakso.driver.uicore.components.recyclerview.decorations.DividerModel
    public Color f() {
        return f34834f;
    }

    @Override // ee.mtakso.driver.uicore.components.recyclerview.decorations.DividerModel
    public Float i() {
        return Float.valueOf(f34835g);
    }

    @Override // ee.mtakso.driver.uicore.components.recyclerview.decorations.DividerModel
    public boolean j() {
        return f34831c;
    }

    @Override // ee.mtakso.driver.uicore.components.recyclerview.decorations.DividerModel
    public boolean k() {
        return f34832d;
    }
}
