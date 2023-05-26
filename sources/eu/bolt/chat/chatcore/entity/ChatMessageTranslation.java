package eu.bolt.chat.chatcore.entity;

import kotlin.jvm.internal.Intrinsics;

/* compiled from: ChatMessageTranslation.kt */
/* loaded from: classes5.dex */
public final class ChatMessageTranslation {

    /* renamed from: a  reason: collision with root package name */
    private final String f38168a;

    /* renamed from: b  reason: collision with root package name */
    private final TranslationAttribution f38169b;

    public ChatMessageTranslation(String text, TranslationAttribution translationAttribution) {
        Intrinsics.f(text, "text");
        this.f38168a = text;
        this.f38169b = translationAttribution;
    }

    public final TranslationAttribution a() {
        return this.f38169b;
    }

    public final String b() {
        return this.f38168a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof ChatMessageTranslation) {
            ChatMessageTranslation chatMessageTranslation = (ChatMessageTranslation) obj;
            return Intrinsics.a(this.f38168a, chatMessageTranslation.f38168a) && Intrinsics.a(this.f38169b, chatMessageTranslation.f38169b);
        }
        return false;
    }

    public int hashCode() {
        int hashCode = this.f38168a.hashCode() * 31;
        TranslationAttribution translationAttribution = this.f38169b;
        return hashCode + (translationAttribution == null ? 0 : translationAttribution.hashCode());
    }

    public String toString() {
        return "ChatMessageTranslation(text=" + this.f38168a + ", attribution=" + this.f38169b + ')';
    }
}
