package eu.bolt.chat.chatcore.connection;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;

@ScopeMetadata("javax.inject.Singleton")
@DaggerGenerated
@QualifierMetadata
/* loaded from: classes5.dex */
public final class ChatConnectionControllerImpl_Factory implements Factory<ChatConnectionControllerImpl> {

    /* loaded from: classes5.dex */
    private static final class InstanceHolder {

        /* renamed from: a  reason: collision with root package name */
        private static final ChatConnectionControllerImpl_Factory f38069a = new ChatConnectionControllerImpl_Factory();

        private InstanceHolder() {
        }
    }

    public static ChatConnectionControllerImpl_Factory a() {
        return InstanceHolder.f38069a;
    }

    public static ChatConnectionControllerImpl c() {
        return new ChatConnectionControllerImpl();
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public ChatConnectionControllerImpl get() {
        return c();
    }
}
