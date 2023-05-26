package eu.bolt.client.chatdb.room.message.mapper;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
/* loaded from: classes5.dex */
public final class MessageStatusMapper_Factory implements Factory<MessageStatusMapper> {

    /* loaded from: classes5.dex */
    private static final class InstanceHolder {

        /* renamed from: a  reason: collision with root package name */
        private static final MessageStatusMapper_Factory f39891a = new MessageStatusMapper_Factory();

        private InstanceHolder() {
        }
    }

    public static MessageStatusMapper_Factory a() {
        return InstanceHolder.f39891a;
    }

    public static MessageStatusMapper c() {
        return new MessageStatusMapper();
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public MessageStatusMapper get() {
        return c();
    }
}
