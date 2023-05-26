package ee.mtakso.driver.ui.views.infoblock;

import ee.mtakso.driver.R;
import ee.mtakso.driver.uikit.utils.Color;
import ee.mtakso.driver.uikit.utils.Image;

/* compiled from: InfoBlockType.kt */
/* loaded from: classes5.dex */
public enum InfoBlockType {
    SUCCESS(new Color.Attr(R.attr.infoBlockTextSuccess), new Color.Attr(R.attr.contentPrimary), new Color.Attr(R.attr.infoBlockBackgroundTintSuccess), new Image.Res(R.drawable.ic_chat_terminal_check), new Color.Attr(R.attr.infoBlockIconTintSuccess)),
    ALERT(new Color.Attr(R.attr.infoBlockTextAlert), new Color.Attr(R.attr.contentPrimary), new Color.Attr(R.attr.infoBlockBackgroundTintAlert), new Image.Res(R.drawable.ic_common_alert), new Color.Attr(R.attr.infoBlockIconTintAlert)),
    WARNING(new Color.Attr(R.attr.infoBlockTextWarning), new Color.Attr(R.attr.contentPrimary), new Color.Attr(R.attr.infoBlockBackgroundTintWarning), new Image.Res(R.drawable.ic_yellow800_info_sign), new Color.Attr(R.attr.infoBlockIconTintWarning)),
    INFO(new Color.Attr(R.attr.infoBlockTextInfo), new Color.Attr(R.attr.contentPrimary), new Color.Attr(R.attr.infoBlockBackgroundTintInfo), new Image.Res(R.drawable.ic_info_circle_fill), new Color.Attr(R.attr.infoBlockIconTintInfo));
    

    /* renamed from: f  reason: collision with root package name */
    private final Color f34369f;

    /* renamed from: g  reason: collision with root package name */
    private final Color f34370g;

    /* renamed from: h  reason: collision with root package name */
    private final Color f34371h;

    /* renamed from: i  reason: collision with root package name */
    private final Image f34372i;

    /* renamed from: j  reason: collision with root package name */
    private final Color f34373j;

    InfoBlockType(Color color, Color color2, Color color3, Image image, Color color4) {
        this.f34369f = color;
        this.f34370g = color2;
        this.f34371h = color3;
        this.f34372i = image;
        this.f34373j = color4;
    }

    public final Color c() {
        return this.f34371h;
    }

    public final Image e() {
        return this.f34372i;
    }

    public final Color f() {
        return this.f34373j;
    }

    public final Color h() {
        return this.f34370g;
    }

    public final Color j() {
        return this.f34369f;
    }
}
