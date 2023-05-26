package com.google.android.material.resources;

import android.graphics.Typeface;

/* loaded from: classes.dex */
public final class CancelableFontCallback extends TextAppearanceFontCallback {

    /* renamed from: a  reason: collision with root package name */
    private final Typeface f13872a;

    /* renamed from: b  reason: collision with root package name */
    private final ApplyFont f13873b;

    /* renamed from: c  reason: collision with root package name */
    private boolean f13874c;

    /* loaded from: classes.dex */
    public interface ApplyFont {
        void a(Typeface typeface);
    }

    public CancelableFontCallback(ApplyFont applyFont, Typeface typeface) {
        this.f13872a = typeface;
        this.f13873b = applyFont;
    }

    private void d(Typeface typeface) {
        if (!this.f13874c) {
            this.f13873b.a(typeface);
        }
    }

    @Override // com.google.android.material.resources.TextAppearanceFontCallback
    public void a(int i8) {
        d(this.f13872a);
    }

    @Override // com.google.android.material.resources.TextAppearanceFontCallback
    public void b(Typeface typeface, boolean z7) {
        d(typeface);
    }

    public void c() {
        this.f13874c = true;
    }
}
