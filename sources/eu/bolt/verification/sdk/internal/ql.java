package eu.bolt.verification.sdk.internal;

import android.text.Editable;
import android.text.TextWatcher;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* loaded from: classes5.dex */
public final class ql implements TextWatcher {

    /* renamed from: f  reason: collision with root package name */
    private final Function1<Editable, Unit> f44669f;

    /* renamed from: g  reason: collision with root package name */
    private final Function4<CharSequence, Integer, Integer, Integer, Unit> f44670g;

    /* renamed from: h  reason: collision with root package name */
    private final Function4<CharSequence, Integer, Integer, Integer, Unit> f44671h;

    /* JADX WARN: Multi-variable type inference failed */
    public ql(Function1<? super Editable, Unit> function1, Function4<? super CharSequence, ? super Integer, ? super Integer, ? super Integer, Unit> function4, Function4<? super CharSequence, ? super Integer, ? super Integer, ? super Integer, Unit> function42) {
        this.f44669f = function1;
        this.f44670g = function4;
        this.f44671h = function42;
    }

    public /* synthetic */ ql(Function1 function1, Function4 function4, Function4 function42, int i8, DefaultConstructorMarker defaultConstructorMarker) {
        this((i8 & 1) != 0 ? null : function1, (i8 & 2) != 0 ? null : function4, (i8 & 4) != 0 ? null : function42);
    }

    @Override // android.text.TextWatcher
    public void afterTextChanged(Editable editable) {
        Function1<Editable, Unit> function1 = this.f44669f;
        if (function1 != null) {
            function1.invoke(editable);
        }
    }

    @Override // android.text.TextWatcher
    public void beforeTextChanged(CharSequence charSequence, int i8, int i9, int i10) {
        Function4<CharSequence, Integer, Integer, Integer, Unit> function4 = this.f44670g;
        if (function4 != null) {
            function4.f(charSequence, Integer.valueOf(i8), Integer.valueOf(i9), Integer.valueOf(i10));
        }
    }

    @Override // android.text.TextWatcher
    public void onTextChanged(CharSequence charSequence, int i8, int i9, int i10) {
        Function4<CharSequence, Integer, Integer, Integer, Unit> function4 = this.f44671h;
        if (function4 != null) {
            function4.f(charSequence, Integer.valueOf(i8), Integer.valueOf(i9), Integer.valueOf(i10));
        }
    }
}
