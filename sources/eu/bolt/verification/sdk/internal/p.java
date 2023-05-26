package eu.bolt.verification.sdk.internal;

import android.graphics.drawable.Drawable;
import android.view.View;
import eu.bolt.client.design.image.DesignImageView;
import eu.bolt.client.design.input.DesignTextfieldView;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes5.dex */
public class p implements DesignTextfieldView.g {

    /* renamed from: a  reason: collision with root package name */
    private final Drawable f44492a;

    /* renamed from: b  reason: collision with root package name */
    private final Integer f44493b;

    /* renamed from: c  reason: collision with root package name */
    private final View.OnClickListener f44494c;

    public p(Drawable drawable, Integer num, View.OnClickListener onClickListener) {
        Intrinsics.f(drawable, "drawable");
        this.f44492a = drawable;
        this.f44493b = num;
        this.f44494c = onClickListener;
    }

    public /* synthetic */ p(Drawable drawable, Integer num, View.OnClickListener onClickListener, int i8, DefaultConstructorMarker defaultConstructorMarker) {
        this(drawable, (i8 & 2) != 0 ? null : num, (i8 & 4) != 0 ? null : onClickListener);
    }

    @Override // eu.bolt.client.design.input.DesignTextfieldView.g
    public void a(DesignImageView view, boolean z7, CharSequence text) {
        Intrinsics.f(view, "view");
        Intrinsics.f(text, "text");
        uq.C(view, true);
        view.setImageDrawable(this.f44492a);
        Integer num = this.f44493b;
        if (num != null) {
            view.setId(num.intValue());
        }
        View.OnClickListener onClickListener = this.f44494c;
        if (onClickListener != null) {
            view.setOnClickListener(onClickListener);
            return;
        }
        view.setOnClickListener(null);
        view.setClickable(false);
    }

    @Override // eu.bolt.client.design.input.DesignTextfieldView.g
    public void b(DesignImageView view, boolean z7) {
        Intrinsics.f(view, "view");
    }

    @Override // eu.bolt.client.design.input.DesignTextfieldView.g
    public void c(DesignImageView view, CharSequence text) {
        Intrinsics.f(view, "view");
        Intrinsics.f(text, "text");
    }
}
