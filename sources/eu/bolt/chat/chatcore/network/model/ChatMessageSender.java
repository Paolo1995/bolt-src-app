package eu.bolt.chat.chatcore.network.model;

import com.google.gson.annotations.SerializedName;
import org.simpleframework.xml.strategy.Name;

/* compiled from: ChatMessageSender.kt */
/* loaded from: classes5.dex */
public final class ChatMessageSender {
    @SerializedName(Name.MARK)

    /* renamed from: a  reason: collision with root package name */
    private final String f38322a;
    @SerializedName("name")

    /* renamed from: b  reason: collision with root package name */
    private final String f38323b;

    public final String a() {
        return this.f38322a;
    }

    public final String b() {
        return this.f38323b;
    }
}
