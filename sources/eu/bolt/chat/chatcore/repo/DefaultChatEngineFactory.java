package eu.bolt.chat.chatcore.repo;

import eu.bolt.chat.chatcore.engine.ChatEngineDependencies;
import eu.bolt.chat.chatcore.engine.ChatEngineFactory;
import eu.bolt.chat.chatcore.push.ChatPushHandler;
import eu.bolt.chat.chatcore.push.ChatPushHandlerImpl;
import eu.bolt.chat.chatcore.push.PushHandlerDependencies;
import eu.bolt.chat.tools.logger.Logger;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DefaultChatEngineFactory.kt */
/* loaded from: classes5.dex */
public final class DefaultChatEngineFactory implements ChatEngineFactory {

    /* renamed from: a  reason: collision with root package name */
    private final Logger f38400a;

    public DefaultChatEngineFactory(Logger logger) {
        Intrinsics.f(logger, "logger");
        this.f38400a = logger;
    }

    @Override // eu.bolt.chat.chatcore.engine.ChatEngineFactory
    public InternalChatRepo a(ChatEngineDependencies dependencies) {
        Intrinsics.f(dependencies, "dependencies");
        this.f38400a.b("Creating a default chat engine");
        return new DefaultChatRepo(dependencies.d(), dependencies.b(), dependencies.c(), dependencies.e(), this.f38400a, dependencies.f(), dependencies.h(), dependencies.g(), dependencies.i(), dependencies.k(), dependencies.j(), dependencies.a(), dependencies.m(), dependencies.l());
    }

    @Override // eu.bolt.chat.chatcore.engine.ChatEngineFactory
    public ChatPushHandler b(PushHandlerDependencies dependencies) {
        Intrinsics.f(dependencies, "dependencies");
        this.f38400a.b("Creating a default push handler");
        InternalChatRepo internalChatRepo = dependencies.c().get();
        Intrinsics.e(internalChatRepo, "dependencies.chatRepo.get()");
        return new ChatPushHandlerImpl(internalChatRepo, dependencies.f(), this.f38400a, dependencies.d(), dependencies.e(), dependencies.a());
    }
}
