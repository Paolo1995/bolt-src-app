package eu.bolt.verification.sdk.internal;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.view.ViewGroup;
import eu.bolt.client.design.input.DesignEditText;
import java.util.Arrays;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes5.dex */
public final class ka {

    /* renamed from: a  reason: collision with root package name */
    private final ViewGroup f43840a;

    /* renamed from: b  reason: collision with root package name */
    private final DesignEditText f43841b;

    /* renamed from: c  reason: collision with root package name */
    private boolean f43842c;

    /* renamed from: d  reason: collision with root package name */
    private final Lazy f43843d;

    /* loaded from: classes5.dex */
    static final class a extends Lambda implements Function0<Drawable> {
        a() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        /* renamed from: b */
        public final Drawable invoke() {
            ka kaVar = ka.this;
            Context context = kaVar.f43840a.getContext();
            Intrinsics.e(context, "inputContainer.context");
            return kaVar.b(context);
        }
    }

    public ka(ViewGroup inputContainer, DesignEditText inputView) {
        Lazy a8;
        String[] autofillHints;
        String[] autofillHints2;
        int importantForAutofill;
        Intrinsics.f(inputContainer, "inputContainer");
        Intrinsics.f(inputView, "inputView");
        this.f43840a = inputContainer;
        this.f43841b = inputView;
        a8 = LazyKt__LazyJVMKt.a(LazyThreadSafetyMode.NONE, new a());
        this.f43843d = a8;
        if (Build.VERSION.SDK_INT >= 26) {
            if (inputView.getImportantForAutofill() == 0) {
                importantForAutofill = inputContainer.getImportantForAutofill();
                inputView.setImportantForAutofill(importantForAutofill);
            }
            if (inputView.getAutofillHints() == null) {
                autofillHints = inputContainer.getAutofillHints();
                if (autofillHints != null) {
                    autofillHints2 = inputContainer.getAutofillHints();
                    inputView.setAutofillHints((String[]) Arrays.copyOf(autofillHints2, autofillHints2.length));
                }
            }
            inputContainer.setAutofillHints(null);
            inputContainer.setImportantForAutofill(2);
        }
    }

    private final Drawable a() {
        return (Drawable) this.f43843d.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Drawable b(Context context) {
        if (Build.VERSION.SDK_INT >= 26) {
            TypedArray obtainStyledAttributes = this.f43840a.getContext().getTheme().obtainStyledAttributes(new int[]{16844136});
            Intrinsics.e(obtainStyledAttributes, "theme.obtainStyledAttrib…ttr.autofilledHighlight))");
            Drawable drawable = obtainStyledAttributes.getDrawable(0);
            obtainStyledAttributes.recycle();
            return drawable;
        }
        return null;
    }

    public final void e(Canvas canvas) {
        Intrinsics.f(canvas, "canvas");
        if (this.f43842c) {
            Drawable a8 = a();
            if (a8 != null) {
                a8.setBounds(0, 0, this.f43840a.getWidth(), this.f43840a.getHeight());
            }
            Drawable a9 = a();
            if (a9 != null) {
                a9.draw(canvas);
            }
        }
    }

    public final void f() {
        if (this.f43842c) {
            this.f43842c = false;
            this.f43840a.invalidate();
        }
    }
}
