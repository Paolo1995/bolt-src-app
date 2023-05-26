package ee.mtakso.driver.network.client.contact;

import com.google.gson.annotations.SerializedName;

/* compiled from: ContactOptionsDetailsResponse.kt */
/* loaded from: classes3.dex */
public final class VoipContactDetails extends ContactOptionsDetails {
    @SerializedName("provider")

    /* renamed from: a  reason: collision with root package name */
    private final String f21804a;
    @SerializedName("context")

    /* renamed from: b  reason: collision with root package name */
    private final String f21805b;
    @SerializedName("recipient_voip_id")

    /* renamed from: c  reason: collision with root package name */
    private final String f21806c;
    @SerializedName("recipient_name")

    /* renamed from: d  reason: collision with root package name */
    private final String f21807d;
    @SerializedName("recipient_picture_url")

    /* renamed from: e  reason: collision with root package name */
    private final String f21808e;

    public final String a() {
        return this.f21805b;
    }

    public final String b() {
        return this.f21807d;
    }

    public final String c() {
        return this.f21808e;
    }

    public final String d() {
        return this.f21806c;
    }
}
