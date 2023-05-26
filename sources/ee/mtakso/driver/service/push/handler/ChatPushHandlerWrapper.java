package ee.mtakso.driver.service.push.handler;

import dagger.Lazy;
import ee.mtakso.driver.platform.push.Push;
import ee.mtakso.driver.service.push.PushHandler;
import eu.bolt.chat.chatcore.push.ChatPushHandler;
import javax.inject.Inject;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ChatPushHandlerWrapper.kt */
/* loaded from: classes3.dex */
public final class ChatPushHandlerWrapper implements PushHandler {

    /* renamed from: a  reason: collision with root package name */
    private final Lazy<ChatPushHandler> f25671a;

    @Inject
    public ChatPushHandlerWrapper(Lazy<ChatPushHandler> impl) {
        Intrinsics.f(impl, "impl");
        this.f25671a = impl;
    }

    @Override // ee.mtakso.driver.service.push.PushHandler
    public int a() {
        return PushHandler.DefaultImpls.a(this);
    }

    @Override // ee.mtakso.driver.service.push.PushHandler
    public boolean b(Push push) {
        Intrinsics.f(push, "push");
        return this.f25671a.get().a(push.b());
    }
}
