package ee.mtakso.driver.ui.common.generictreeviewstate;

import ee.mtakso.driver.R;
import ee.mtakso.driver.ui.common.generictreeviewstate.GenericViewState;
import ee.mtakso.driver.uicore.components.recyclerview.delegates.generic.GenericTitleDelegate;
import ee.mtakso.driver.uikit.recyclerview.ListModel;
import ee.mtakso.driver.uikit.utils.Color;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: GenericViewStateTitle.kt */
/* loaded from: classes3.dex */
public final class GenericViewStateTitle implements GenericViewState {

    /* renamed from: a  reason: collision with root package name */
    private final String f26357a;

    /* renamed from: b  reason: collision with root package name */
    private final GenericViewState.Divider f26358b;

    /* renamed from: c  reason: collision with root package name */
    private final boolean f26359c;

    public GenericViewStateTitle(String text, GenericViewState.Divider divider) {
        Intrinsics.f(text, "text");
        this.f26357a = text;
        this.f26358b = divider;
    }

    @Override // ee.mtakso.driver.ui.common.generictreeviewstate.GenericViewState
    public boolean a() {
        return this.f26359c;
    }

    @Override // ee.mtakso.driver.ui.common.generictreeviewstate.GenericViewState
    public ListModel b(String id, int i8, int i9) {
        boolean z7;
        Color color;
        Float f8;
        Intrinsics.f(id, "id");
        String str = this.f26357a;
        Color.Attr attr = new Color.Attr(R.attr.backTertiary);
        boolean d8 = d();
        GenericViewState.Divider e8 = e();
        if (e8 != null) {
            z7 = e8.h();
        } else {
            z7 = true;
        }
        GenericViewState.Divider e9 = e();
        if (e9 != null) {
            color = e9.c();
        } else {
            color = null;
        }
        GenericViewState.Divider e10 = e();
        if (e10 != null) {
            f8 = Float.valueOf(e10.e());
        } else {
            f8 = null;
        }
        return new GenericTitleDelegate.Model(id, i8, str, attr, d8, z7, false, color, null, f8, 320, null);
    }

    @Override // ee.mtakso.driver.ui.common.generictreeviewstate.GenericViewState
    public void c(boolean z7) {
    }

    @Override // ee.mtakso.driver.ui.common.generictreeviewstate.GenericViewState
    public boolean d() {
        return true;
    }

    public GenericViewState.Divider e() {
        return this.f26358b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof GenericViewStateTitle) {
            GenericViewStateTitle genericViewStateTitle = (GenericViewStateTitle) obj;
            return Intrinsics.a(this.f26357a, genericViewStateTitle.f26357a) && e() == genericViewStateTitle.e();
        }
        return false;
    }

    public int hashCode() {
        return (this.f26357a.hashCode() * 31) + (e() == null ? 0 : e().hashCode());
    }

    public String toString() {
        String str = this.f26357a;
        GenericViewState.Divider e8 = e();
        return "GenericViewStateTitle(text=" + str + ", divider=" + e8 + ")";
    }
}
