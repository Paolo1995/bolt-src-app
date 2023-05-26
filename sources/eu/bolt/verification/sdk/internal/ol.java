package eu.bolt.verification.sdk.internal;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.Editable;
import android.widget.TextView;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes5.dex */
public final class ol {

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public static final class a extends Lambda implements Function1<Editable, Unit> {

        /* renamed from: f */
        final /* synthetic */ Function1<Editable, Unit> f44477f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        a(Function1<? super Editable, Unit> function1) {
            super(1);
            this.f44477f = function1;
        }

        public final void b(Editable editable) {
            if (editable != null) {
                this.f44477f.invoke(editable);
            }
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Editable editable) {
            b(editable);
            return Unit.f50853a;
        }
    }

    public static final Drawable a(TextView textView) {
        Intrinsics.f(textView, "<this>");
        return f(textView)[3];
    }

    public static final void b(TextView textView, Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4, boolean z7) {
        Intrinsics.f(textView, "<this>");
        if (z7) {
            textView.setCompoundDrawablesRelativeWithIntrinsicBounds(drawable, drawable3, drawable2, drawable4);
        } else {
            textView.setCompoundDrawablesRelative(drawable, drawable3, drawable2, drawable4);
        }
    }

    public static /* synthetic */ void c(TextView textView, Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4, boolean z7, int i8, Object obj) {
        if ((i8 & 1) != 0) {
            drawable = h(textView);
        }
        if ((i8 & 2) != 0) {
            drawable2 = g(textView);
        }
        Drawable drawable5 = drawable2;
        if ((i8 & 4) != 0) {
            drawable3 = j(textView);
        }
        Drawable drawable6 = drawable3;
        if ((i8 & 8) != 0) {
            drawable4 = a(textView);
        }
        b(textView, drawable, drawable5, drawable6, drawable4, (i8 & 16) != 0 ? true : z7);
    }

    public static final void d(TextView textView, CharSequence charSequence) {
        Intrinsics.f(textView, "<this>");
        textView.setText(charSequence);
        textView.setVisibility(qk.a(charSequence) ? 0 : 8);
    }

    public static final void e(TextView textView, Function1<? super Editable, Unit> action) {
        Intrinsics.f(textView, "<this>");
        Intrinsics.f(action, "action");
        textView.addTextChangedListener(new ql(new a(action), null, null, 6, null));
    }

    public static final Drawable[] f(TextView textView) {
        Intrinsics.f(textView, "<this>");
        Drawable[] compoundDrawablesRelative = textView.getCompoundDrawablesRelative();
        Intrinsics.e(compoundDrawablesRelative, "compoundDrawablesRelative");
        return compoundDrawablesRelative;
    }

    public static final Drawable g(TextView textView) {
        Intrinsics.f(textView, "<this>");
        return f(textView)[2];
    }

    public static final Drawable h(TextView textView) {
        Intrinsics.f(textView, "<this>");
        return f(textView)[0];
    }

    public static final float i(TextView textView) {
        Intrinsics.f(textView, "<this>");
        Context context = textView.getContext();
        Intrinsics.e(context, "context");
        return f2.k(context, textView.getTextSize());
    }

    public static final Drawable j(TextView textView) {
        Intrinsics.f(textView, "<this>");
        return f(textView)[1];
    }
}
