package eu.bolt.chat.chatcore.push;

import com.google.gson.Gson;
import dagger.Lazy;
import eu.bolt.chat.chatcore.network.repo.ChatEventMapper;
import eu.bolt.chat.chatcore.repo.InternalChatRepo;
import eu.bolt.chat.chatcore.user.UserInfoProvider;
import eu.bolt.chat.tools.deps.RxSchedulers;
import javax.inject.Inject;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: PushHandlerDependencies.kt */
/* loaded from: classes5.dex */
public final class PushHandlerDependencies {

    /* renamed from: a  reason: collision with root package name */
    private final Lazy<InternalChatRepo> f38388a;

    /* renamed from: b  reason: collision with root package name */
    private final UserInfoProvider f38389b;

    /* renamed from: c  reason: collision with root package name */
    private final Gson f38390c;

    /* renamed from: d  reason: collision with root package name */
    private final RxSchedulers f38391d;

    /* renamed from: e  reason: collision with root package name */
    private final ChatEventMapper f38392e;

    /* renamed from: f  reason: collision with root package name */
    private final ChatPushDelegate f38393f;

    @Inject
    public PushHandlerDependencies(Lazy<InternalChatRepo> chatRepo, UserInfoProvider userInfoProvider, Gson parser, RxSchedulers rxSchedulers, ChatEventMapper chatEventMapper, ChatPushDelegate chatPushDelegate) {
        Intrinsics.f(chatRepo, "chatRepo");
        Intrinsics.f(userInfoProvider, "userInfoProvider");
        Intrinsics.f(parser, "parser");
        Intrinsics.f(rxSchedulers, "rxSchedulers");
        Intrinsics.f(chatEventMapper, "chatEventMapper");
        Intrinsics.f(chatPushDelegate, "chatPushDelegate");
        this.f38388a = chatRepo;
        this.f38389b = userInfoProvider;
        this.f38390c = parser;
        this.f38391d = rxSchedulers;
        this.f38392e = chatEventMapper;
        this.f38393f = chatPushDelegate;
    }

    public final ChatEventMapper a() {
        return this.f38392e;
    }

    public final ChatPushDelegate b() {
        return this.f38393f;
    }

    public final Lazy<InternalChatRepo> c() {
        return this.f38388a;
    }

    public final Gson d() {
        return this.f38390c;
    }

    public final RxSchedulers e() {
        return this.f38391d;
    }

    public final UserInfoProvider f() {
        return this.f38389b;
    }
}
