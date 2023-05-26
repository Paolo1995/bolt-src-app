package eu.bolt.chat.chatcore.chatsdk;

import eu.bolt.chat.chatcore.chatsdk.mapper.ChatMapper;
import eu.bolt.chat.chatcore.chatsdk.mapper.MessageMapper;
import eu.bolt.chat.chatcore.chatsdk.mapper.OrderMapper;
import eu.bolt.chat.chatcore.engine.ChatEngineDependencies;
import eu.bolt.chat.chatcore.engine.ChatEngineFactory;
import eu.bolt.chat.chatcore.push.ChatPushHandler;
import eu.bolt.chat.chatcore.push.PushHandlerDependencies;
import eu.bolt.chat.chatcore.repo.InternalChatRepo;
import eu.bolt.chat.tools.logger.Logger;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ChatSdkChatEngineFactory.kt */
/* loaded from: classes5.dex */
public final class ChatSdkChatEngineFactory implements ChatEngineFactory {

    /* renamed from: a  reason: collision with root package name */
    private final ChatSdkInitializer f37893a;

    /* renamed from: b  reason: collision with root package name */
    private final AnonymousChatSdkProvider f37894b;

    /* renamed from: c  reason: collision with root package name */
    private final Logger f37895c;

    /* renamed from: d  reason: collision with root package name */
    private final OrderMapper f37896d;

    /* renamed from: e  reason: collision with root package name */
    private final ChatMapper f37897e;

    /* renamed from: f  reason: collision with root package name */
    private final MessageMapper f37898f;

    public ChatSdkChatEngineFactory(ChatSdkInitializer chatSdkInitializer, AnonymousChatSdkProvider chatSdkProvider, Logger logger) {
        Intrinsics.f(chatSdkInitializer, "chatSdkInitializer");
        Intrinsics.f(chatSdkProvider, "chatSdkProvider");
        Intrinsics.f(logger, "logger");
        this.f37893a = chatSdkInitializer;
        this.f37894b = chatSdkProvider;
        this.f37895c = logger;
        OrderMapper orderMapper = new OrderMapper();
        this.f37896d = orderMapper;
        this.f37897e = new ChatMapper(orderMapper);
        this.f37898f = new MessageMapper();
    }

    @Override // eu.bolt.chat.chatcore.engine.ChatEngineFactory
    public InternalChatRepo a(ChatEngineDependencies dependencies) {
        Intrinsics.f(dependencies, "dependencies");
        this.f37895c.b("Creating a Chat SDK chat engine");
        return new ChatSdkChatRepo(this.f37893a, dependencies.f(), dependencies.l(), dependencies.i(), dependencies.k(), this.f37897e, this.f37896d, this.f37898f, this.f37895c);
    }

    @Override // eu.bolt.chat.chatcore.engine.ChatEngineFactory
    public ChatPushHandler b(PushHandlerDependencies dependencies) {
        Intrinsics.f(dependencies, "dependencies");
        this.f37895c.b("Creating a Chat SDK push handler");
        return new ChatSdkPushHandler(this.f37894b, this.f37897e, this.f37898f, dependencies.b(), this.f37895c);
    }
}
