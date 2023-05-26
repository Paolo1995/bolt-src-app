package eu.bolt.verification.sdk.internal;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.View;
import eu.bolt.client.design.image.DesignImageView;
import eu.bolt.client.design.input.DesignTextfieldView;
import eu.bolt.verification.R$color;
import eu.bolt.verification.R$drawable;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes5.dex */
public final class u1 implements DesignTextfieldView.g {

    /* renamed from: h  reason: collision with root package name */
    private static final a f45243h = new a(null);

    /* renamed from: a  reason: collision with root package name */
    private final DesignTextfieldView f45244a;

    /* renamed from: b  reason: collision with root package name */
    private final Drawable f45245b;

    /* renamed from: c  reason: collision with root package name */
    private final View.OnClickListener f45246c;

    /* renamed from: d  reason: collision with root package name */
    private final Drawable f45247d;

    /* renamed from: e  reason: collision with root package name */
    private boolean f45248e;

    /* renamed from: f  reason: collision with root package name */
    private boolean f45249f;

    /* renamed from: g  reason: collision with root package name */
    private final View.OnClickListener f45250g;

    /* loaded from: classes5.dex */
    private static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public u1(DesignTextfieldView textfield, Drawable drawable, View.OnClickListener onClickListener) {
        Intrinsics.f(textfield, "textfield");
        this.f45244a = textfield;
        this.f45245b = drawable;
        this.f45246c = onClickListener;
        this.f45247d = e();
        this.f45250g = new View.OnClickListener() { // from class: eu.bolt.verification.sdk.internal.vw
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                u1.g(u1.this, view);
            }
        };
    }

    public /* synthetic */ u1(DesignTextfieldView designTextfieldView, Drawable drawable, View.OnClickListener onClickListener, int i8, DefaultConstructorMarker defaultConstructorMarker) {
        this(designTextfieldView, (i8 & 2) != 0 ? null : drawable, (i8 & 4) != 0 ? null : onClickListener);
    }

    private final Drawable e() {
        Context context = this.f45244a.getContext();
        Intrinsics.e(context, "context");
        return a6.a(f2.o(context, R$drawable.ic_clear), f2.b(context, R$color.content_tertiary));
    }

    private final void f(DesignImageView designImageView, boolean z7, boolean z8) {
        View.OnClickListener onClickListener;
        boolean z9 = z7 && z8;
        Drawable drawable = this.f45245b;
        if (drawable == null) {
            h(designImageView, z9);
            return;
        }
        if (z9) {
            designImageView.setImageDrawable(this.f45247d);
            onClickListener = this.f45250g;
        } else {
            designImageView.setImageDrawable(drawable);
            onClickListener = this.f45246c;
            if (onClickListener == null) {
                designImageView.setOnClickListener(null);
                designImageView.setClickable(false);
                return;
            }
        }
        designImageView.setOnClickListener(onClickListener);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void g(u1 this$0, View view) {
        Intrinsics.f(this$0, "this$0");
        this$0.f45244a.setText("");
    }

    private final void h(DesignImageView designImageView, boolean z7) {
        designImageView.setImageDrawable(this.f45247d);
        designImageView.setOnClickListener(this.f45250g);
        designImageView.setEnabled(z7);
        float f8 = z7 ? 1.0f : 0.0f;
        designImageView.animate().cancel();
        designImageView.animate().alpha(f8).setDuration(150L).start();
    }

    @Override // eu.bolt.client.design.input.DesignTextfieldView.g
    public void a(DesignImageView view, boolean z7, CharSequence text) {
        Intrinsics.f(view, "view");
        Intrinsics.f(text, "text");
        this.f45249f = z7;
        boolean z8 = text.length() > 0;
        this.f45248e = z8;
        f(view, this.f45249f, z8);
    }

    @Override // eu.bolt.client.design.input.DesignTextfieldView.g
    public void b(DesignImageView view, boolean z7) {
        Intrinsics.f(view, "view");
        if (this.f45249f != z7) {
            f(view, z7, this.f45248e);
            this.f45249f = z7;
        }
    }

    @Override // eu.bolt.client.design.input.DesignTextfieldView.g
    public void c(DesignImageView view, CharSequence text) {
        Intrinsics.f(view, "view");
        Intrinsics.f(text, "text");
        if (this.f45248e != (text.length() > 0)) {
            f(view, this.f45249f, text.length() > 0);
            this.f45248e = text.length() > 0;
        }
    }
}
