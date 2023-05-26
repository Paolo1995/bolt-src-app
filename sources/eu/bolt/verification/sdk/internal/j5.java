package eu.bolt.verification.sdk.internal;

import android.view.View;
import android.view.inputmethod.InputMethodManager;
import androidx.core.content.ContextCompat;
import eu.bolt.client.design.input.DesignEditText;
import eu.bolt.client.design.input.DesignTextfieldView;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes5.dex */
public final class j5 {

    /* renamed from: a  reason: collision with root package name */
    private final DesignTextfieldView f43658a;

    /* renamed from: b  reason: collision with root package name */
    private final Lazy f43659b;

    /* loaded from: classes5.dex */
    static final class a extends Lambda implements Function0<InputMethodManager> {
        a() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        /* renamed from: b */
        public final InputMethodManager invoke() {
            return (InputMethodManager) ContextCompat.getSystemService(j5.this.f43658a.getContext(), InputMethodManager.class);
        }
    }

    public j5(DesignTextfieldView textfield) {
        Lazy a8;
        Intrinsics.f(textfield, "textfield");
        this.f43658a = textfield;
        a8 = LazyKt__LazyJVMKt.a(LazyThreadSafetyMode.NONE, new a());
        this.f43659b = a8;
    }

    private final InputMethodManager d() {
        return (InputMethodManager) this.f43659b.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void f(j5 this$0, View view) {
        Intrinsics.f(this$0, "this$0");
        this$0.i();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void g(j5 this$0, View view, boolean z7) {
        Intrinsics.f(this$0, "this$0");
        this$0.h(z7);
    }

    private final void h(boolean z7) {
        DesignEditText inputView = this.f43658a.getInputView();
        View.OnFocusChangeListener onFocusChangeListener = this.f43658a.getOnFocusChangeListener();
        if (onFocusChangeListener != null) {
            onFocusChangeListener.onFocusChange(inputView, z7);
        }
        this.f43658a.s(z7);
    }

    private final void i() {
        DesignEditText inputView = this.f43658a.getInputView();
        if (!inputView.isFocused()) {
            inputView.setSelection(this.f43658a.getText().length());
            inputView.requestFocus();
        }
        InputMethodManager d8 = d();
        if (d8 != null) {
            d8.showSoftInput(inputView, 1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void j(j5 this$0, View view) {
        Intrinsics.f(this$0, "this$0");
        this$0.f43658a.performClick();
    }

    public final void k(boolean z7) {
        DesignEditText inputView = this.f43658a.getInputView();
        inputView.setFocusable(z7);
        inputView.setLongClickable(z7);
        inputView.setFocusableInTouchMode(z7);
        if (z7) {
            inputView.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: eu.bolt.verification.sdk.internal.st
                @Override // android.view.View.OnFocusChangeListener
                public final void onFocusChange(View view, boolean z8) {
                    j5.g(j5.this, view, z8);
                }
            });
            this.f43658a.setOnClickListener(new View.OnClickListener() { // from class: eu.bolt.verification.sdk.internal.tt
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    j5.f(j5.this, view);
                }
            });
            return;
        }
        inputView.setOnClickListener(new View.OnClickListener() { // from class: eu.bolt.verification.sdk.internal.ut
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                j5.j(j5.this, view);
            }
        });
        this.f43658a.setOnClickListener(null);
        inputView.setInputType(inputView.getInputType() | 524288);
    }
}
