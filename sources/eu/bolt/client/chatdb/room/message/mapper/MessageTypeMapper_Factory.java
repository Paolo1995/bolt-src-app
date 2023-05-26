package eu.bolt.client.chatdb.room.message.mapper;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
/* loaded from: classes5.dex */
public final class MessageTypeMapper_Factory implements Factory<MessageTypeMapper> {

    /* loaded from: classes5.dex */
    private static final class InstanceHolder {

        /* renamed from: a  reason: collision with root package name */
        private static final MessageTypeMapper_Factory f39893a = new MessageTypeMapper_Factory();

        private InstanceHolder() {
        }
    }

    public static MessageTypeMapper_Factory a() {
        return InstanceHolder.f39893a;
    }

    public static MessageTypeMapper c() {
        return new MessageTypeMapper();
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public MessageTypeMapper get() {
        return c();
    }
}
