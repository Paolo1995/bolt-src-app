package ee.mtakso.driver.ui.screens.order.arrived;

import android.graphics.Typeface;
import android.text.TextPaint;
import ee.mtakso.driver.uicore.utils.CustomTypefaceSpan;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ForegroundColorClickSpan.kt */
/* loaded from: classes3.dex */
public abstract class ForegroundColorClickSpan extends TouchableSpan {

    /* renamed from: g  reason: collision with root package name */
    private final int f31059g;

    /* renamed from: h  reason: collision with root package name */
    private final int f31060h;

    /* renamed from: i  reason: collision with root package name */
    private final boolean f31061i;

    /* renamed from: j  reason: collision with root package name */
    private final Typeface f31062j;

    public /* synthetic */ ForegroundColorClickSpan(int i8, int i9, boolean z7, Typeface typeface, int i10, DefaultConstructorMarker defaultConstructorMarker) {
        this(i8, i9, (i10 & 4) != 0 ? false : z7, (i10 & 8) != 0 ? null : typeface);
    }

    @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
    public void updateDrawState(TextPaint ds) {
        Intrinsics.f(ds, "ds");
        super.updateDrawState(ds);
        if (a()) {
            ds.setColor(this.f31060h);
        } else {
            ds.setColor(this.f31059g);
        }
        ds.setUnderlineText(this.f31061i);
        Typeface typeface = this.f31062j;
        if (typeface != null) {
            CustomTypefaceSpan.f35725g.a(ds, typeface);
        }
    }

    public ForegroundColorClickSpan(int i8, int i9, boolean z7, Typeface typeface) {
        this.f31059g = i8;
        this.f31060h = i9;
        this.f31061i = z7;
        this.f31062j = typeface;
    }
}
