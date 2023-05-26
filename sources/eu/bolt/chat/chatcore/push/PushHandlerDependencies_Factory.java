package eu.bolt.chat.chatcore.push;

import com.google.gson.Gson;
import dagger.Lazy;
import dagger.internal.DaggerGenerated;
import dagger.internal.DoubleCheck;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import eu.bolt.chat.chatcore.network.repo.ChatEventMapper;
import eu.bolt.chat.chatcore.repo.InternalChatRepo;
import eu.bolt.chat.chatcore.user.UserInfoProvider;
import eu.bolt.chat.tools.deps.RxSchedulers;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
/* loaded from: classes5.dex */
public final class PushHandlerDependencies_Factory implements Factory<PushHandlerDependencies> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<InternalChatRepo> f38394a;

    /* renamed from: b  reason: collision with root package name */
    private final Provider<UserInfoProvider> f38395b;

    /* renamed from: c  reason: collision with root package name */
    private final Provider<Gson> f38396c;

    /* renamed from: d  reason: collision with root package name */
    private final Provider<RxSchedulers> f38397d;

    /* renamed from: e  reason: collision with root package name */
    private final Provider<ChatEventMapper> f38398e;

    /* renamed from: f  reason: collision with root package name */
    private final Provider<ChatPushDelegate> f38399f;

    public PushHandlerDependencies_Factory(Provider<InternalChatRepo> provider, Provider<UserInfoProvider> provider2, Provider<Gson> provider3, Provider<RxSchedulers> provider4, Provider<ChatEventMapper> provider5, Provider<ChatPushDelegate> provider6) {
        this.f38394a = provider;
        this.f38395b = provider2;
        this.f38396c = provider3;
        this.f38397d = provider4;
        this.f38398e = provider5;
        this.f38399f = provider6;
    }

    public static PushHandlerDependencies_Factory a(Provider<InternalChatRepo> provider, Provider<UserInfoProvider> provider2, Provider<Gson> provider3, Provider<RxSchedulers> provider4, Provider<ChatEventMapper> provider5, Provider<ChatPushDelegate> provider6) {
        return new PushHandlerDependencies_Factory(provider, provider2, provider3, provider4, provider5, provider6);
    }

    public static PushHandlerDependencies c(Lazy<InternalChatRepo> lazy, UserInfoProvider userInfoProvider, Gson gson, RxSchedulers rxSchedulers, ChatEventMapper chatEventMapper, ChatPushDelegate chatPushDelegate) {
        return new PushHandlerDependencies(lazy, userInfoProvider, gson, rxSchedulers, chatEventMapper, chatPushDelegate);
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public PushHandlerDependencies get() {
        return c(DoubleCheck.lazy(this.f38394a), this.f38395b.get(), this.f38396c.get(), this.f38397d.get(), this.f38398e.get(), this.f38399f.get());
    }
}
