package eu.bolt.driver.chat.ui.screen.conversation.pager;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
/* loaded from: classes5.dex */
public final class ConversationMapper_Factory implements Factory<ConversationMapper> {

    /* loaded from: classes5.dex */
    private static final class InstanceHolder {

        /* renamed from: a  reason: collision with root package name */
        private static final ConversationMapper_Factory f40590a = new ConversationMapper_Factory();

        private InstanceHolder() {
        }
    }

    public static ConversationMapper_Factory a() {
        return InstanceHolder.f40590a;
    }

    public static ConversationMapper c() {
        return new ConversationMapper();
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public ConversationMapper get() {
        return c();
    }
}
