package ee.mtakso.driver.ui.screens.update;

import ee.mtakso.driver.R;
import ee.mtakso.driver.uikit.utils.Text;

/* compiled from: MandatoryUpdateFragmentParams.kt */
/* loaded from: classes5.dex */
public enum MandatoryUpdateFragmentParams {
    PLAY_STORE_UPDATE_REQUIRED(new Text.Resource(R.string.play_store_needs_update, null, 2, null), new Text.Resource(R.string.mandatory_update_message, null, 2, null), null, "https://support.google.com/googleplay/answer/113412?hl="),
    PLAY_SERVICE_UPDATE_REQUIRED(new Text.Resource(R.string.play_services_needs_update, null, 2, null), new Text.Resource(R.string.mandatory_update_message, null, 2, null), "market://details?id=com.google.android.gms", "https://support.google.com/googleplay/answer/9037938?hl=");
    

    /* renamed from: f  reason: collision with root package name */
    private final Text f33499f;

    /* renamed from: g  reason: collision with root package name */
    private final Text f33500g;

    /* renamed from: h  reason: collision with root package name */
    private final String f33501h;

    /* renamed from: i  reason: collision with root package name */
    private final String f33502i;

    MandatoryUpdateFragmentParams(Text text, Text text2, String str, String str2) {
        this.f33499f = text;
        this.f33500g = text2;
        this.f33501h = str;
        this.f33502i = str2;
    }

    public final String c() {
        return this.f33502i;
    }

    public final String e() {
        return this.f33501h;
    }

    public final Text f() {
        return this.f33500g;
    }

    public final Text h() {
        return this.f33499f;
    }
}
