package eu.bolt.chat.chatcore.network.model;

import com.google.gson.annotations.SerializedName;

/* compiled from: TranslationNetworkModel.kt */
/* loaded from: classes5.dex */
public final class TranslationNetworkModel {
    @SerializedName("text")

    /* renamed from: a  reason: collision with root package name */
    private final String f38354a;
    @SerializedName("attribution")

    /* renamed from: b  reason: collision with root package name */
    private final AttributionNetworkModel f38355b;

    public final AttributionNetworkModel a() {
        return this.f38355b;
    }

    public final String b() {
        return this.f38354a;
    }
}
