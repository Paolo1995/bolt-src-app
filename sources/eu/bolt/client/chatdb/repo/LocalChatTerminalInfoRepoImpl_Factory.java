package eu.bolt.client.chatdb.repo;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import eu.bolt.client.chatdb.room.terminalmessage.TerminalMessagesDao;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
/* loaded from: classes5.dex */
public final class LocalChatTerminalInfoRepoImpl_Factory implements Factory<LocalChatTerminalInfoRepoImpl> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<TerminalMessagesDao> f39761a;

    public LocalChatTerminalInfoRepoImpl_Factory(Provider<TerminalMessagesDao> provider) {
        this.f39761a = provider;
    }

    public static LocalChatTerminalInfoRepoImpl_Factory a(Provider<TerminalMessagesDao> provider) {
        return new LocalChatTerminalInfoRepoImpl_Factory(provider);
    }

    public static LocalChatTerminalInfoRepoImpl c(TerminalMessagesDao terminalMessagesDao) {
        return new LocalChatTerminalInfoRepoImpl(terminalMessagesDao);
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public LocalChatTerminalInfoRepoImpl get() {
        return c(this.f39761a.get());
    }
}
