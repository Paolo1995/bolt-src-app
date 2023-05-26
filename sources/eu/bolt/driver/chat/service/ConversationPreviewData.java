package eu.bolt.driver.chat.service;

import eu.bolt.chat.chatcore.entity.ChatEntity;
import eu.bolt.chat.chatcore.entity.ChatMessageEntity;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ConversationPreviewData.kt */
/* loaded from: classes5.dex */
public final class ConversationPreviewData {

    /* renamed from: a  reason: collision with root package name */
    private final ChatEntity f40465a;

    /* renamed from: b  reason: collision with root package name */
    private final int f40466b;

    /* renamed from: c  reason: collision with root package name */
    private final ChatMessageEntity f40467c;

    /* renamed from: d  reason: collision with root package name */
    private final String f40468d;

    /* renamed from: e  reason: collision with root package name */
    private final String f40469e;

    /* renamed from: f  reason: collision with root package name */
    private final String f40470f;

    public ConversationPreviewData(ChatEntity data, int i8, ChatMessageEntity chatMessageEntity) {
        Intrinsics.f(data, "data");
        this.f40465a = data;
        this.f40466b = i8;
        this.f40467c = chatMessageEntity;
        this.f40468d = data.b();
        this.f40469e = data.f();
        this.f40470f = data.a();
    }

    public final ChatEntity a() {
        return this.f40465a;
    }

    public final String b() {
        return this.f40470f;
    }

    public final String c() {
        return this.f40468d;
    }

    public final ChatMessageEntity d() {
        return this.f40467c;
    }

    public final String e() {
        return this.f40469e;
    }

    public final int f() {
        return this.f40466b;
    }
}
