package eu.bolt.android.chat.recyclerview;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import eu.bolt.chat.chatcore.interactor.ReadMessageInteractor;
import eu.bolt.chat.tools.logger.Logger;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
/* loaded from: classes5.dex */
public final class ChatReadDelegate_Factory implements Factory<ChatReadDelegate> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<ReadMessageInteractor> f36723a;

    /* renamed from: b  reason: collision with root package name */
    private final Provider<Logger> f36724b;

    public ChatReadDelegate_Factory(Provider<ReadMessageInteractor> provider, Provider<Logger> provider2) {
        this.f36723a = provider;
        this.f36724b = provider2;
    }

    public static ChatReadDelegate_Factory a(Provider<ReadMessageInteractor> provider, Provider<Logger> provider2) {
        return new ChatReadDelegate_Factory(provider, provider2);
    }

    public static ChatReadDelegate c(ReadMessageInteractor readMessageInteractor, Logger logger) {
        return new ChatReadDelegate(readMessageInteractor, logger);
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public ChatReadDelegate get() {
        return c(this.f36723a.get(), this.f36724b.get());
    }
}
