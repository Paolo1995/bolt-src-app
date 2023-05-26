package eu.bolt.chat.client;

import eu.bolt.chat.data.message.MessageEvent;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.datetime.LocalDateTime;

/* compiled from: MessageRouter.kt */
/* loaded from: classes5.dex */
public final class MessageBox {

    /* renamed from: a  reason: collision with root package name */
    private final String f38917a;

    /* renamed from: b  reason: collision with root package name */
    private final MessageEvent f38918b;

    /* renamed from: c  reason: collision with root package name */
    private final LocalDateTime f38919c;

    public MessageBox(String chatId, MessageEvent event, LocalDateTime eventDate) {
        Intrinsics.f(chatId, "chatId");
        Intrinsics.f(event, "event");
        Intrinsics.f(eventDate, "eventDate");
        this.f38917a = chatId;
        this.f38918b = event;
        this.f38919c = eventDate;
    }

    public final String a() {
        return this.f38917a;
    }

    public final MessageEvent b() {
        return this.f38918b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof MessageBox) {
            MessageBox messageBox = (MessageBox) obj;
            return Intrinsics.a(this.f38917a, messageBox.f38917a) && Intrinsics.a(this.f38918b, messageBox.f38918b) && Intrinsics.a(this.f38919c, messageBox.f38919c);
        }
        return false;
    }

    public int hashCode() {
        return (((this.f38917a.hashCode() * 31) + this.f38918b.hashCode()) * 31) + this.f38919c.hashCode();
    }

    public String toString() {
        return "MessageBox(chatId=" + this.f38917a + ", event=" + this.f38918b + ", eventDate=" + this.f38919c + ')';
    }
}
