package ee.mtakso.driver.service.chat;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
/* loaded from: classes3.dex */
public final class ChatMessageMapper_Factory implements Factory<ChatMessageMapper> {

    /* loaded from: classes3.dex */
    private static final class InstanceHolder {

        /* renamed from: a  reason: collision with root package name */
        private static final ChatMessageMapper_Factory f23996a = new ChatMessageMapper_Factory();

        private InstanceHolder() {
        }
    }

    public static ChatMessageMapper_Factory a() {
        return InstanceHolder.f23996a;
    }

    public static ChatMessageMapper c() {
        return new ChatMessageMapper();
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public ChatMessageMapper get() {
        return c();
    }
}
