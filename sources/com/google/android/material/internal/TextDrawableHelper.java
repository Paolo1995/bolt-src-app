package com.google.android.material.internal;

import android.content.Context;
import android.graphics.Typeface;
import android.text.TextPaint;
import androidx.annotation.NonNull;
import com.google.android.material.resources.TextAppearance;
import com.google.android.material.resources.TextAppearanceFontCallback;
import java.lang.ref.WeakReference;

/* loaded from: classes.dex */
public class TextDrawableHelper {

    /* renamed from: c  reason: collision with root package name */
    private float f13674c;

    /* renamed from: f  reason: collision with root package name */
    private TextAppearance f13677f;

    /* renamed from: a  reason: collision with root package name */
    private final TextPaint f13672a = new TextPaint(1);

    /* renamed from: b  reason: collision with root package name */
    private final TextAppearanceFontCallback f13673b = new TextAppearanceFontCallback() { // from class: com.google.android.material.internal.TextDrawableHelper.1
        @Override // com.google.android.material.resources.TextAppearanceFontCallback
        public void a(int i8) {
            TextDrawableHelper.this.f13675d = true;
            TextDrawableDelegate textDrawableDelegate = (TextDrawableDelegate) TextDrawableHelper.this.f13676e.get();
            if (textDrawableDelegate != null) {
                textDrawableDelegate.a();
            }
        }

        @Override // com.google.android.material.resources.TextAppearanceFontCallback
        public void b(@NonNull Typeface typeface, boolean z7) {
            if (!z7) {
                TextDrawableHelper.this.f13675d = true;
                TextDrawableDelegate textDrawableDelegate = (TextDrawableDelegate) TextDrawableHelper.this.f13676e.get();
                if (textDrawableDelegate != null) {
                    textDrawableDelegate.a();
                }
            }
        }
    };

    /* renamed from: d  reason: collision with root package name */
    private boolean f13675d = true;

    /* renamed from: e  reason: collision with root package name */
    private WeakReference<TextDrawableDelegate> f13676e = new WeakReference<>(null);

    /* loaded from: classes.dex */
    public interface TextDrawableDelegate {
        void a();

        @NonNull
        int[] getState();

        boolean onStateChange(int[] iArr);
    }

    public TextDrawableHelper(TextDrawableDelegate textDrawableDelegate) {
        g(textDrawableDelegate);
    }

    private float c(CharSequence charSequence) {
        if (charSequence == null) {
            return 0.0f;
        }
        return this.f13672a.measureText(charSequence, 0, charSequence.length());
    }

    public TextAppearance d() {
        return this.f13677f;
    }

    @NonNull
    public TextPaint e() {
        return this.f13672a;
    }

    public float f(String str) {
        if (!this.f13675d) {
            return this.f13674c;
        }
        float c8 = c(str);
        this.f13674c = c8;
        this.f13675d = false;
        return c8;
    }

    public void g(TextDrawableDelegate textDrawableDelegate) {
        this.f13676e = new WeakReference<>(textDrawableDelegate);
    }

    public void h(TextAppearance textAppearance, Context context) {
        if (this.f13677f != textAppearance) {
            this.f13677f = textAppearance;
            if (textAppearance != null) {
                textAppearance.o(context, this.f13672a, this.f13673b);
                TextDrawableDelegate textDrawableDelegate = this.f13676e.get();
                if (textDrawableDelegate != null) {
                    this.f13672a.drawableState = textDrawableDelegate.getState();
                }
                textAppearance.n(context, this.f13672a, this.f13673b);
                this.f13675d = true;
            }
            TextDrawableDelegate textDrawableDelegate2 = this.f13676e.get();
            if (textDrawableDelegate2 != null) {
                textDrawableDelegate2.a();
                textDrawableDelegate2.onStateChange(textDrawableDelegate2.getState());
            }
        }
    }

    public void i(boolean z7) {
        this.f13675d = z7;
    }

    public void j(Context context) {
        this.f13677f.n(context, this.f13672a, this.f13673b);
    }
}
