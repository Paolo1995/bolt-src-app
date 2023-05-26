package ee.mtakso.driver.ui.screens.order.incoming.v2;

import ee.mtakso.driver.R;
import ee.mtakso.driver.uikit.utils.Color;

/* compiled from: IncomingOrderStyle.kt */
/* loaded from: classes3.dex */
public enum IncomingOrderStyle {
    ACTION(new Color.Attr(R.attr.dynamicPurple01), new Color.Attr(R.attr.dynamicNeutral05), new Color.Attr(R.attr.dynamicWhite), new Color.Attr(R.attr.contentTransparent), new Color.Attr(R.attr.contentTransparent), new Color.Attr(R.attr.dynamicYellow)),
    PRIMARY(new Color.Attr(R.attr.dynamicGreen02), new Color.Attr(R.attr.dynamicNeutral05), new Color.Attr(R.attr.dynamicWhite), new Color.Attr(R.attr.contentTransparent), new Color.Attr(R.attr.contentTransparent), new Color.Attr(R.attr.dynamicYellow)),
    NEUTRAL(new Color.Attr(R.attr.dynamicPurple01), new Color.Attr(R.attr.backPrimary), new Color.Attr(R.attr.contentPrimary), new Color.Attr(R.attr.dynamicNeutral03), new Color.Attr(R.attr.dynamicNeutral04), new Color.Attr(R.attr.accentYellow));
    

    /* renamed from: f  reason: collision with root package name */
    private final Color f31401f;

    /* renamed from: g  reason: collision with root package name */
    private final Color f31402g;

    /* renamed from: h  reason: collision with root package name */
    private final Color f31403h;

    /* renamed from: i  reason: collision with root package name */
    private final Color f31404i;

    /* renamed from: j  reason: collision with root package name */
    private final Color f31405j;

    /* renamed from: k  reason: collision with root package name */
    private final Color f31406k;

    IncomingOrderStyle(Color color, Color color2, Color color3, Color color4, Color color5, Color color6) {
        this.f31401f = color;
        this.f31402g = color2;
        this.f31403h = color3;
        this.f31404i = color4;
        this.f31405j = color5;
        this.f31406k = color6;
    }

    public final Color c() {
        return this.f31401f;
    }

    public final Color e() {
        return this.f31402g;
    }

    public final Color f() {
        return this.f31403h;
    }

    public final Color h() {
        return this.f31406k;
    }

    public final Color j() {
        return this.f31404i;
    }

    public final Color k() {
        return this.f31405j;
    }
}
