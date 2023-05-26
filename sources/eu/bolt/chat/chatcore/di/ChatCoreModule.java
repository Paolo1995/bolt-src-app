package eu.bolt.chat.chatcore.di;

import android.content.Context;
import android.os.Build;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import dagger.Module;
import dagger.Provides;
import eu.bolt.chat.chatcore.ChatKit;
import eu.bolt.chat.chatcore.chatsdk.AnonymousChatSdkProvider;
import eu.bolt.chat.chatcore.chatsdk.AnonymousChatSdkProviderKt;
import eu.bolt.chat.chatcore.chatsdk.ChatCredentialsProvider;
import eu.bolt.chat.chatcore.chatsdk.ChatSdkInitializer;
import eu.bolt.chat.chatcore.chatsdk.ChatSdkInitializerKt;
import eu.bolt.chat.chatcore.engine.ChatEngineDependencies;
import eu.bolt.chat.chatcore.engine.ChatEngineFactory;
import eu.bolt.chat.chatcore.engine.ChatEngineFactoryKt;
import eu.bolt.chat.chatcore.engine.ChatEngineTypeProvider;
import eu.bolt.chat.chatcore.network.external.ChatExternalNetworkRepo;
import eu.bolt.chat.chatcore.network.external.ChatExternalTerminationMessageProvider;
import eu.bolt.chat.chatcore.network.model.ChatEventResponse;
import eu.bolt.chat.chatcore.network.model.ChatPushDomain;
import eu.bolt.chat.chatcore.network.model.MqttEventResponse;
import eu.bolt.chat.chatcore.network.repo.ChatNetworkRepoImpl;
import eu.bolt.chat.chatcore.network.security.SecurityProviderInstaller;
import eu.bolt.chat.chatcore.network.security.SecurityProviderInstallerApi19;
import eu.bolt.chat.chatcore.network.security.SecurityProviderInstallerApi23;
import eu.bolt.chat.chatcore.network.typeadapters.ChatMessageResponseDeserializer;
import eu.bolt.chat.chatcore.network.typeadapters.ChatPushDomainDeserializer;
import eu.bolt.chat.chatcore.network.typeadapters.MqttEventResponseDeserializer;
import eu.bolt.chat.chatcore.push.ChatPushDelegate;
import eu.bolt.chat.chatcore.push.ChatPushHandler;
import eu.bolt.chat.chatcore.push.PushHandlerDependencies;
import eu.bolt.chat.chatcore.repo.ChatNetworkRepo;
import eu.bolt.chat.chatcore.repo.InternalChatRepo;
import eu.bolt.chat.chatcore.repo.quickreply.QuickRepliesDelegate;
import eu.bolt.chat.chatcore.repo.quickreply.QuickRepliesDelegateImpl;
import eu.bolt.chat.chatcore.user.MqttInfoProvider;
import eu.bolt.chat.chatcore.user.MqttMessageExtrasProvider;
import eu.bolt.chat.chatcore.user.UserInfoProvider;
import eu.bolt.chat.tools.deps.RxSchedulers;
import eu.bolt.chat.tools.logger.Logger;
import eu.bolt.chat.tools.uniqueid.IdGenerator;
import javax.inject.Singleton;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ChatCoreModule.kt */
@Module(includes = {ChatCoreBindingModule.class})
/* loaded from: classes5.dex */
public final class ChatCoreModule {
    @Provides
    @Singleton
    public final ChatExternalNetworkRepo a() {
        return ChatKit.f37877a.b();
    }

    @Provides
    @Singleton
    public final IdGenerator b() {
        return ChatKit.f37877a.f();
    }

    @Provides
    @Singleton
    public final ChatEngineFactory c(ChatEngineTypeProvider engineTypeProvider, final Logger logger) {
        Lazy b8;
        Lazy b9;
        Intrinsics.f(engineTypeProvider, "engineTypeProvider");
        Intrinsics.f(logger, "logger");
        b8 = LazyKt__LazyJVMKt.b(new Function0<AnonymousChatSdkProvider>() { // from class: eu.bolt.chat.chatcore.di.ChatCoreModule$provideChatEngineFactory$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            /* renamed from: b */
            public final AnonymousChatSdkProvider invoke() {
                return AnonymousChatSdkProviderKt.a(Logger.this);
            }
        });
        b9 = LazyKt__LazyJVMKt.b(new Function0<ChatSdkInitializer>() { // from class: eu.bolt.chat.chatcore.di.ChatCoreModule$provideChatEngineFactory$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            /* renamed from: b */
            public final ChatSdkInitializer invoke() {
                UserInfoProvider j8 = ChatKit.f37877a.j();
                return ChatSdkInitializerKt.a(j8, new ChatCredentialsProvider(j8), Logger.this);
            }
        });
        return ChatEngineFactoryKt.a(b8, b9, engineTypeProvider, logger);
    }

    @Provides
    @Singleton
    public final Logger d() {
        return ChatKit.f37877a.g();
    }

    @Provides
    @Singleton
    public final ChatNetworkRepo e(ChatNetworkRepoImpl chatNetworkRepo) {
        Intrinsics.f(chatNetworkRepo, "chatNetworkRepo");
        return chatNetworkRepo;
    }

    @Provides
    @Singleton
    public final ChatPushHandler f(ChatEngineFactory engineFactory, PushHandlerDependencies dependencies) {
        Intrinsics.f(engineFactory, "engineFactory");
        Intrinsics.f(dependencies, "dependencies");
        return engineFactory.b(dependencies);
    }

    @Provides
    @Singleton
    public final RxSchedulers g() {
        return ChatKit.f37877a.d();
    }

    @Provides
    @Singleton
    public final Gson h() {
        Gson create = new GsonBuilder().registerTypeAdapter(ChatEventResponse.class, new ChatMessageResponseDeserializer()).registerTypeAdapter(MqttEventResponse.class, new MqttEventResponseDeserializer()).registerTypeAdapter(ChatPushDomain.Event.class, new ChatPushDomainDeserializer()).create();
        Intrinsics.e(create, "GsonBuilder()\n        .r…izer())\n        .create()");
        return create;
    }

    @Provides
    @Singleton
    public final InternalChatRepo i(ChatEngineFactory engineFactory, ChatEngineDependencies dependencies) {
        Intrinsics.f(engineFactory, "engineFactory");
        Intrinsics.f(dependencies, "dependencies");
        return engineFactory.a(dependencies);
    }

    @Provides
    @Singleton
    public final MqttInfoProvider j() {
        return ChatKit.f37877a.j();
    }

    @Provides
    @Singleton
    public final MqttMessageExtrasProvider k() {
        return ChatKit.f37877a.j();
    }

    @Provides
    @Singleton
    public final ChatPushDelegate l() {
        return ChatKit.f37877a.i();
    }

    @Provides
    @Singleton
    public final QuickRepliesDelegate m(QuickRepliesDelegateImpl quickRepliesDelegate) {
        Intrinsics.f(quickRepliesDelegate, "quickRepliesDelegate");
        return quickRepliesDelegate;
    }

    @Provides
    @Singleton
    public final SecurityProviderInstaller n(Context context, Logger logger) {
        Intrinsics.f(context, "context");
        Intrinsics.f(logger, "logger");
        if (Build.VERSION.SDK_INT >= 23) {
            return new SecurityProviderInstallerApi23();
        }
        return new SecurityProviderInstallerApi19(context, logger);
    }

    @Provides
    @Singleton
    public final ChatExternalTerminationMessageProvider o() {
        return ChatKit.f37877a.c();
    }

    @Provides
    @Singleton
    public final UserInfoProvider p() {
        return ChatKit.f37877a.j();
    }
}
