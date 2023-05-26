package eu.bolt.driver.core.ui.common.snackbar;

import android.view.View;
import com.google.android.material.snackbar.Snackbar;
import ee.mtakso.driver.uikit.utils.Text;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: SnackBarModel.kt */
/* loaded from: classes5.dex */
public final class SnackBarModel {

    /* renamed from: a  reason: collision with root package name */
    private final int f41129a;

    /* renamed from: b  reason: collision with root package name */
    private final Text f41130b;

    /* renamed from: c  reason: collision with root package name */
    private final Text f41131c;

    /* renamed from: d  reason: collision with root package name */
    private final Function1<View, Unit> f41132d;

    /* renamed from: e  reason: collision with root package name */
    private final Function1<Snackbar, Unit> f41133e;

    /* renamed from: f  reason: collision with root package name */
    private final Function1<Snackbar, Unit> f41134f;

    /* JADX WARN: Multi-variable type inference failed */
    public SnackBarModel(int i8, Text text, Text text2, Function1<? super View, Unit> function1, Function1<? super Snackbar, Unit> function12, Function1<? super Snackbar, Unit> function13) {
        Intrinsics.f(text, "text");
        this.f41129a = i8;
        this.f41130b = text;
        this.f41131c = text2;
        this.f41132d = function1;
        this.f41133e = function12;
        this.f41134f = function13;
    }

    public final Function1<View, Unit> a() {
        return this.f41132d;
    }

    public final Text b() {
        return this.f41131c;
    }

    public final int c() {
        return this.f41129a;
    }

    public final Function1<Snackbar, Unit> d() {
        return this.f41134f;
    }

    public final Function1<Snackbar, Unit> e() {
        return this.f41133e;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof SnackBarModel) {
            SnackBarModel snackBarModel = (SnackBarModel) obj;
            return this.f41129a == snackBarModel.f41129a && Intrinsics.a(this.f41130b, snackBarModel.f41130b) && Intrinsics.a(this.f41131c, snackBarModel.f41131c) && Intrinsics.a(this.f41132d, snackBarModel.f41132d) && Intrinsics.a(this.f41133e, snackBarModel.f41133e) && Intrinsics.a(this.f41134f, snackBarModel.f41134f);
        }
        return false;
    }

    public final Text f() {
        return this.f41130b;
    }

    public int hashCode() {
        int hashCode = ((this.f41129a * 31) + this.f41130b.hashCode()) * 31;
        Text text = this.f41131c;
        int hashCode2 = (hashCode + (text == null ? 0 : text.hashCode())) * 31;
        Function1<View, Unit> function1 = this.f41132d;
        int hashCode3 = (hashCode2 + (function1 == null ? 0 : function1.hashCode())) * 31;
        Function1<Snackbar, Unit> function12 = this.f41133e;
        int hashCode4 = (hashCode3 + (function12 == null ? 0 : function12.hashCode())) * 31;
        Function1<Snackbar, Unit> function13 = this.f41134f;
        return hashCode4 + (function13 != null ? function13.hashCode() : 0);
    }

    public String toString() {
        int i8 = this.f41129a;
        Text text = this.f41130b;
        Text text2 = this.f41131c;
        Function1<View, Unit> function1 = this.f41132d;
        Function1<Snackbar, Unit> function12 = this.f41133e;
        Function1<Snackbar, Unit> function13 = this.f41134f;
        return "SnackBarModel(duration=" + i8 + ", text=" + text + ", actionText=" + text2 + ", actionListener=" + function1 + ", onShown=" + function12 + ", onDismissed=" + function13 + ")";
    }

    public /* synthetic */ SnackBarModel(int i8, Text text, Text text2, Function1 function1, Function1 function12, Function1 function13, int i9, DefaultConstructorMarker defaultConstructorMarker) {
        this(i8, text, (i9 & 4) != 0 ? null : text2, (i9 & 8) != 0 ? null : function1, (i9 & 16) != 0 ? null : function12, (i9 & 32) != 0 ? null : function13);
    }
}
