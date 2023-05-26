package eu.bolt.android.chat;

import android.content.Context;
import com.google.gson.Gson;
import dagger.internal.DaggerGenerated;
import dagger.internal.DoubleCheck;
import dagger.internal.Factory;
import dagger.internal.InstanceFactory;
import dagger.internal.Preconditions;
import eu.bolt.android.chat.ChatComponent;
import eu.bolt.chat.chatcore.connection.ChatConnectionControllerImpl;
import eu.bolt.chat.chatcore.connection.ChatConnectionControllerImpl_Factory;
import eu.bolt.chat.chatcore.connection.ChatConnectionProvider;
import eu.bolt.chat.chatcore.di.ChatCoreModule;
import eu.bolt.chat.chatcore.di.ChatCoreModule_ChatExternalNetworkRepoFactory;
import eu.bolt.chat.chatcore.di.ChatCoreModule_IdGeneratorFactory;
import eu.bolt.chat.chatcore.di.ChatCoreModule_ProvideChatEngineFactory$chat_core_releaseFactory;
import eu.bolt.chat.chatcore.di.ChatCoreModule_ProvideChatLoggerFactory;
import eu.bolt.chat.chatcore.di.ChatCoreModule_ProvideChatNetworkRepo$chat_core_releaseFactory;
import eu.bolt.chat.chatcore.di.ChatCoreModule_ProvideChatPushHandler$chat_core_releaseFactory;
import eu.bolt.chat.chatcore.di.ChatCoreModule_ProvideDepsFactory;
import eu.bolt.chat.chatcore.di.ChatCoreModule_ProvideGsonFactory;
import eu.bolt.chat.chatcore.di.ChatCoreModule_ProvideInternalChatRepo$chat_core_releaseFactory;
import eu.bolt.chat.chatcore.di.ChatCoreModule_ProvideMqttInfoProviderFactory;
import eu.bolt.chat.chatcore.di.ChatCoreModule_ProvideMqttMessageExtrasProviderFactory;
import eu.bolt.chat.chatcore.di.ChatCoreModule_ProvidePushDelegateFactory;
import eu.bolt.chat.chatcore.di.ChatCoreModule_ProvideQuickReplyDelegate$chat_core_releaseFactory;
import eu.bolt.chat.chatcore.di.ChatCoreModule_ProvideSecurityProviderInstaller$chat_core_releaseFactory;
import eu.bolt.chat.chatcore.di.ChatCoreModule_ProvideTerminationMessageProviderFactory;
import eu.bolt.chat.chatcore.di.ChatCoreModule_ProvideUserInfoProviderFactory;
import eu.bolt.chat.chatcore.di.ChatEngineModule;
import eu.bolt.chat.chatcore.di.ChatEngineModule_ProvideEngineTypeProvider$chat_core_releaseFactory;
import eu.bolt.chat.chatcore.di.MqttControllerModule;
import eu.bolt.chat.chatcore.di.MqttControllerModule_ProvideMqttController$chat_core_releaseFactory;
import eu.bolt.chat.chatcore.engine.ChatEngineDependencies;
import eu.bolt.chat.chatcore.engine.ChatEngineDependencies_Factory;
import eu.bolt.chat.chatcore.engine.ChatEngineFactory;
import eu.bolt.chat.chatcore.engine.ChatEngineTypeProvider;
import eu.bolt.chat.chatcore.hivemq.HiveMqttController;
import eu.bolt.chat.chatcore.hivemq.HiveMqttController_Factory;
import eu.bolt.chat.chatcore.hivemq.client.MqttClientProvider;
import eu.bolt.chat.chatcore.hivemq.client.MqttClientProvider_Factory;
import eu.bolt.chat.chatcore.interactor.CreateChatInteractor;
import eu.bolt.chat.chatcore.interactor.ReadMessageInteractor;
import eu.bolt.chat.chatcore.interactor.RequestReplySuggestionsInteractor;
import eu.bolt.chat.chatcore.interactor.SendChatMessageInteractor;
import eu.bolt.chat.chatcore.mqtt.MqttController;
import eu.bolt.chat.chatcore.network.external.ChatExternalNetworkRepo;
import eu.bolt.chat.chatcore.network.external.ChatExternalTerminationMessageProvider;
import eu.bolt.chat.chatcore.network.repo.ChatEventMapper;
import eu.bolt.chat.chatcore.network.repo.ChatEventMapper_Factory;
import eu.bolt.chat.chatcore.network.repo.ChatNetworkRepoImpl;
import eu.bolt.chat.chatcore.network.repo.ChatNetworkRepoImpl_Factory;
import eu.bolt.chat.chatcore.network.repo.MqttChatEventMapper;
import eu.bolt.chat.chatcore.network.repo.MqttChatEventMapper_Factory;
import eu.bolt.chat.chatcore.network.repo.MqttEventMapper;
import eu.bolt.chat.chatcore.network.repo.MqttEventMapper_Factory;
import eu.bolt.chat.chatcore.network.security.SecurityProviderInstaller;
import eu.bolt.chat.chatcore.push.ChatPushDelegate;
import eu.bolt.chat.chatcore.push.ChatPushHandler;
import eu.bolt.chat.chatcore.push.PushHandlerDependencies;
import eu.bolt.chat.chatcore.push.PushHandlerDependencies_Factory;
import eu.bolt.chat.chatcore.repo.ChatLocalHistoryRepo;
import eu.bolt.chat.chatcore.repo.ChatLocalMessagesRepo;
import eu.bolt.chat.chatcore.repo.ChatLocalRepo;
import eu.bolt.chat.chatcore.repo.ChatLocalTerminalInfoRepo;
import eu.bolt.chat.chatcore.repo.ChatNetworkRepo;
import eu.bolt.chat.chatcore.repo.ChatRepo;
import eu.bolt.chat.chatcore.repo.InternalChatRepo;
import eu.bolt.chat.chatcore.repo.LocalRepoCleaner;
import eu.bolt.chat.chatcore.repo.quickreply.QuickRepliesDelegate;
import eu.bolt.chat.chatcore.repo.quickreply.QuickRepliesDelegateImpl;
import eu.bolt.chat.chatcore.repo.quickreply.QuickRepliesDelegateImpl_Factory;
import eu.bolt.chat.chatcore.user.MqttInfoProvider;
import eu.bolt.chat.chatcore.user.MqttMessageExtrasProvider;
import eu.bolt.chat.chatcore.user.UserInfoProvider;
import eu.bolt.chat.tools.deps.RxSchedulers;
import eu.bolt.chat.tools.logger.Logger;
import eu.bolt.chat.tools.uniqueid.IdGenerator;
import eu.bolt.client.chatdb.di.ChatDbModule;
import eu.bolt.client.chatdb.di.ChatDbModule_ChatDao$chat_db_releaseFactory;
import eu.bolt.client.chatdb.di.ChatDbModule_ChatHistoryRepository$chat_db_releaseFactory;
import eu.bolt.client.chatdb.di.ChatDbModule_ChatMessagesDao$chat_db_releaseFactory;
import eu.bolt.client.chatdb.di.ChatDbModule_ChatMessagesRepository$chat_db_releaseFactory;
import eu.bolt.client.chatdb.di.ChatDbModule_ChatRepository$chat_db_releaseFactory;
import eu.bolt.client.chatdb.di.ChatDbModule_ChatTerminalInfoRepository$chat_db_releaseFactory;
import eu.bolt.client.chatdb.di.ChatDbModule_CleanerRepository$chat_db_releaseFactory;
import eu.bolt.client.chatdb.di.ChatDbModule_DataBase$chat_db_releaseFactory;
import eu.bolt.client.chatdb.di.ChatDbModule_TerminalMessagesDao$chat_db_releaseFactory;
import eu.bolt.client.chatdb.repo.ChatLocalHistoryRepoImpl;
import eu.bolt.client.chatdb.repo.ChatLocalHistoryRepoImpl_Factory;
import eu.bolt.client.chatdb.repo.LocalChatMessagesRepoImpl;
import eu.bolt.client.chatdb.repo.LocalChatMessagesRepoImpl_Factory;
import eu.bolt.client.chatdb.repo.LocalChatRepoImpl;
import eu.bolt.client.chatdb.repo.LocalChatRepoImpl_Factory;
import eu.bolt.client.chatdb.repo.LocalChatTerminalInfoRepoImpl;
import eu.bolt.client.chatdb.repo.LocalChatTerminalInfoRepoImpl_Factory;
import eu.bolt.client.chatdb.repo.LocalRepoCleanerImpl;
import eu.bolt.client.chatdb.repo.LocalRepoCleanerImpl_Factory;
import eu.bolt.client.chatdb.room.ChatDatabase;
import eu.bolt.client.chatdb.room.ChatDatabaseHelper;
import eu.bolt.client.chatdb.room.ChatDatabaseHelper_Factory;
import eu.bolt.client.chatdb.room.chat.ChatDao;
import eu.bolt.client.chatdb.room.message.MessagesDao;
import eu.bolt.client.chatdb.room.message.mapper.MessageMapper;
import eu.bolt.client.chatdb.room.message.mapper.MessageMapper_Factory;
import eu.bolt.client.chatdb.room.message.mapper.MessageStatusMapper_Factory;
import eu.bolt.client.chatdb.room.message.mapper.MessageTypeMapper_Factory;
import eu.bolt.client.chatdb.room.message.mapper.TranslationAttributionMapper_Factory;
import eu.bolt.client.chatdb.room.message.mapper.TranslationMapper;
import eu.bolt.client.chatdb.room.message.mapper.TranslationMapper_Factory;
import eu.bolt.client.chatdb.room.terminalmessage.TerminalMessagesDao;
import javax.inject.Provider;

@DaggerGenerated
/* loaded from: classes5.dex */
public final class DaggerChatComponent {

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public static final class Builder implements ChatComponent.Builder {

        /* renamed from: a  reason: collision with root package name */
        private Context f36687a;

        private Builder() {
        }

        @Override // eu.bolt.android.chat.ChatComponent.Builder
        /* renamed from: a */
        public Builder context(Context context) {
            this.f36687a = (Context) Preconditions.checkNotNull(context);
            return this;
        }

        @Override // eu.bolt.android.chat.ChatComponent.Builder
        public ChatComponent build() {
            Preconditions.checkBuilderRequirement(this.f36687a, Context.class);
            return new ChatComponentImpl(new ChatCoreModule(), new ChatEngineModule(), new ChatDbModule(), new MqttControllerModule(), this.f36687a);
        }
    }

    /* loaded from: classes5.dex */
    private static final class ChatComponentImpl implements ChatComponent {
        private Provider<MqttEventMapper> A;
        private Provider<MqttChatEventMapper> B;
        private Provider<HiveMqttController> C;
        private Provider<MqttController> D;
        private Provider<ChatExternalNetworkRepo> E;
        private Provider<ChatNetworkRepoImpl> F;
        private Provider<ChatNetworkRepo> G;
        private Provider<LocalRepoCleanerImpl> H;
        private Provider<LocalRepoCleaner> I;
        private Provider<ChatPushDelegate> J;
        private Provider<RxSchedulers> K;
        private Provider<QuickRepliesDelegateImpl> L;
        private Provider<QuickRepliesDelegate> M;
        private Provider<ChatLocalHistoryRepoImpl> N;
        private Provider<ChatLocalHistoryRepo> O;
        private Provider<ChatExternalTerminationMessageProvider> P;
        private Provider<SecurityProviderInstaller> Q;
        private Provider<ChatEngineDependencies> R;
        private Provider<InternalChatRepo> S;
        private Provider<PushHandlerDependencies> T;
        private Provider<ChatPushHandler> U;

        /* renamed from: a  reason: collision with root package name */
        private final ChatComponentImpl f36688a;

        /* renamed from: b  reason: collision with root package name */
        private Provider<ChatEngineTypeProvider> f36689b;

        /* renamed from: c  reason: collision with root package name */
        private Provider<Logger> f36690c;

        /* renamed from: d  reason: collision with root package name */
        private Provider<ChatEngineFactory> f36691d;

        /* renamed from: e  reason: collision with root package name */
        private Provider<Context> f36692e;

        /* renamed from: f  reason: collision with root package name */
        private Provider<ChatDatabase> f36693f;

        /* renamed from: g  reason: collision with root package name */
        private Provider<MessagesDao> f36694g;

        /* renamed from: h  reason: collision with root package name */
        private Provider<UserInfoProvider> f36695h;

        /* renamed from: i  reason: collision with root package name */
        private Provider<TranslationMapper> f36696i;

        /* renamed from: j  reason: collision with root package name */
        private Provider<MessageMapper> f36697j;

        /* renamed from: k  reason: collision with root package name */
        private Provider<LocalChatMessagesRepoImpl> f36698k;

        /* renamed from: l  reason: collision with root package name */
        private Provider<ChatLocalMessagesRepo> f36699l;

        /* renamed from: m  reason: collision with root package name */
        private Provider<ChatDao> f36700m;

        /* renamed from: n  reason: collision with root package name */
        private Provider<ChatDatabaseHelper> f36701n;

        /* renamed from: o  reason: collision with root package name */
        private Provider<LocalChatRepoImpl> f36702o;

        /* renamed from: p  reason: collision with root package name */
        private Provider<ChatLocalRepo> f36703p;

        /* renamed from: q  reason: collision with root package name */
        private Provider<TerminalMessagesDao> f36704q;

        /* renamed from: r  reason: collision with root package name */
        private Provider<LocalChatTerminalInfoRepoImpl> f36705r;

        /* renamed from: s  reason: collision with root package name */
        private Provider<ChatLocalTerminalInfoRepo> f36706s;

        /* renamed from: t  reason: collision with root package name */
        private Provider<ChatConnectionControllerImpl> f36707t;

        /* renamed from: u  reason: collision with root package name */
        private Provider<MqttClientProvider> f36708u;

        /* renamed from: v  reason: collision with root package name */
        private Provider<Gson> f36709v;

        /* renamed from: w  reason: collision with root package name */
        private Provider<MqttInfoProvider> f36710w;

        /* renamed from: x  reason: collision with root package name */
        private Provider<ChatEventMapper> f36711x;

        /* renamed from: y  reason: collision with root package name */
        private Provider<MqttMessageExtrasProvider> f36712y;

        /* renamed from: z  reason: collision with root package name */
        private Provider<IdGenerator> f36713z;

        private void h(ChatCoreModule chatCoreModule, ChatEngineModule chatEngineModule, ChatDbModule chatDbModule, MqttControllerModule mqttControllerModule, Context context) {
            this.f36689b = ChatEngineModule_ProvideEngineTypeProvider$chat_core_releaseFactory.a(chatEngineModule);
            Provider<Logger> provider = DoubleCheck.provider(ChatCoreModule_ProvideChatLoggerFactory.a(chatCoreModule));
            this.f36690c = provider;
            this.f36691d = DoubleCheck.provider(ChatCoreModule_ProvideChatEngineFactory$chat_core_releaseFactory.a(chatCoreModule, this.f36689b, provider));
            Factory create = InstanceFactory.create(context);
            this.f36692e = create;
            Provider<ChatDatabase> provider2 = DoubleCheck.provider(ChatDbModule_DataBase$chat_db_releaseFactory.a(chatDbModule, create));
            this.f36693f = provider2;
            this.f36694g = DoubleCheck.provider(ChatDbModule_ChatMessagesDao$chat_db_releaseFactory.b(chatDbModule, provider2));
            this.f36695h = DoubleCheck.provider(ChatCoreModule_ProvideUserInfoProviderFactory.a(chatCoreModule));
            TranslationMapper_Factory a8 = TranslationMapper_Factory.a(TranslationAttributionMapper_Factory.a());
            this.f36696i = a8;
            MessageMapper_Factory a9 = MessageMapper_Factory.a(a8, MessageStatusMapper_Factory.a(), MessageTypeMapper_Factory.a(), this.f36695h);
            this.f36697j = a9;
            LocalChatMessagesRepoImpl_Factory a10 = LocalChatMessagesRepoImpl_Factory.a(this.f36694g, this.f36695h, a9, MessageStatusMapper_Factory.a());
            this.f36698k = a10;
            this.f36699l = DoubleCheck.provider(ChatDbModule_ChatMessagesRepository$chat_db_releaseFactory.b(chatDbModule, a10));
            this.f36700m = DoubleCheck.provider(ChatDbModule_ChatDao$chat_db_releaseFactory.b(chatDbModule, this.f36693f));
            ChatDatabaseHelper_Factory a11 = ChatDatabaseHelper_Factory.a(this.f36693f);
            this.f36701n = a11;
            LocalChatRepoImpl_Factory a12 = LocalChatRepoImpl_Factory.a(this.f36700m, a11);
            this.f36702o = a12;
            this.f36703p = DoubleCheck.provider(ChatDbModule_ChatRepository$chat_db_releaseFactory.b(chatDbModule, a12));
            Provider<TerminalMessagesDao> provider3 = DoubleCheck.provider(ChatDbModule_TerminalMessagesDao$chat_db_releaseFactory.a(chatDbModule, this.f36693f));
            this.f36704q = provider3;
            LocalChatTerminalInfoRepoImpl_Factory a13 = LocalChatTerminalInfoRepoImpl_Factory.a(provider3);
            this.f36705r = a13;
            this.f36706s = DoubleCheck.provider(ChatDbModule_ChatTerminalInfoRepository$chat_db_releaseFactory.b(chatDbModule, a13));
            Provider<ChatConnectionControllerImpl> provider4 = DoubleCheck.provider(ChatConnectionControllerImpl_Factory.a());
            this.f36707t = provider4;
            this.f36708u = MqttClientProvider_Factory.a(provider4, this.f36690c);
            this.f36709v = DoubleCheck.provider(ChatCoreModule_ProvideGsonFactory.a(chatCoreModule));
            this.f36710w = DoubleCheck.provider(ChatCoreModule_ProvideMqttInfoProviderFactory.a(chatCoreModule));
            this.f36711x = ChatEventMapper_Factory.a(this.f36695h);
            this.f36712y = DoubleCheck.provider(ChatCoreModule_ProvideMqttMessageExtrasProviderFactory.a(chatCoreModule));
            Provider<IdGenerator> provider5 = DoubleCheck.provider(ChatCoreModule_IdGeneratorFactory.a(chatCoreModule));
            this.f36713z = provider5;
            MqttEventMapper_Factory a14 = MqttEventMapper_Factory.a(this.f36712y, provider5);
            this.A = a14;
            MqttChatEventMapper_Factory a15 = MqttChatEventMapper_Factory.a(this.f36711x, a14);
            this.B = a15;
            HiveMqttController_Factory a16 = HiveMqttController_Factory.a(this.f36708u, this.f36690c, this.f36709v, this.f36707t, this.f36710w, a15);
            this.C = a16;
            this.D = DoubleCheck.provider(MqttControllerModule_ProvideMqttController$chat_core_releaseFactory.a(mqttControllerModule, a16));
            Provider<ChatExternalNetworkRepo> provider6 = DoubleCheck.provider(ChatCoreModule_ChatExternalNetworkRepoFactory.b(chatCoreModule));
            this.E = provider6;
            Provider<ChatNetworkRepoImpl> provider7 = DoubleCheck.provider(ChatNetworkRepoImpl_Factory.a(this.D, provider6));
            this.F = provider7;
            this.G = DoubleCheck.provider(ChatCoreModule_ProvideChatNetworkRepo$chat_core_releaseFactory.a(chatCoreModule, provider7));
            LocalRepoCleanerImpl_Factory a17 = LocalRepoCleanerImpl_Factory.a(this.f36694g, this.f36700m, this.f36704q, this.f36701n);
            this.H = a17;
            this.I = DoubleCheck.provider(ChatDbModule_CleanerRepository$chat_db_releaseFactory.b(chatDbModule, a17));
            this.J = DoubleCheck.provider(ChatCoreModule_ProvidePushDelegateFactory.a(chatCoreModule));
            Provider<RxSchedulers> provider8 = DoubleCheck.provider(ChatCoreModule_ProvideDepsFactory.a(chatCoreModule));
            this.K = provider8;
            Provider<QuickRepliesDelegateImpl> provider9 = DoubleCheck.provider(QuickRepliesDelegateImpl_Factory.a(this.f36707t, this.G, provider8, this.f36690c));
            this.L = provider9;
            this.M = DoubleCheck.provider(ChatCoreModule_ProvideQuickReplyDelegate$chat_core_releaseFactory.a(chatCoreModule, provider9));
            ChatLocalHistoryRepoImpl_Factory a18 = ChatLocalHistoryRepoImpl_Factory.a(this.f36699l, this.f36703p, this.f36706s, this.f36701n);
            this.N = a18;
            this.O = DoubleCheck.provider(ChatDbModule_ChatHistoryRepository$chat_db_releaseFactory.b(chatDbModule, a18));
            this.P = DoubleCheck.provider(ChatCoreModule_ProvideTerminationMessageProviderFactory.a(chatCoreModule));
            Provider<SecurityProviderInstaller> provider10 = DoubleCheck.provider(ChatCoreModule_ProvideSecurityProviderInstaller$chat_core_releaseFactory.a(chatCoreModule, this.f36692e, this.f36690c));
            this.Q = provider10;
            ChatEngineDependencies_Factory a19 = ChatEngineDependencies_Factory.a(this.f36699l, this.f36703p, this.f36706s, this.G, this.f36707t, this.I, this.f36713z, this.J, this.K, this.M, this.O, this.P, provider10);
            this.R = a19;
            Provider<InternalChatRepo> provider11 = DoubleCheck.provider(ChatCoreModule_ProvideInternalChatRepo$chat_core_releaseFactory.a(chatCoreModule, this.f36691d, a19));
            this.S = provider11;
            PushHandlerDependencies_Factory a20 = PushHandlerDependencies_Factory.a(provider11, this.f36695h, this.f36709v, this.K, this.f36711x, this.J);
            this.T = a20;
            this.U = DoubleCheck.provider(ChatCoreModule_ProvideChatPushHandler$chat_core_releaseFactory.a(chatCoreModule, this.f36691d, a20));
        }

        @Override // eu.bolt.android.chat.ChatDependencyProvider
        public ChatConnectionProvider a() {
            return this.f36707t.get();
        }

        @Override // eu.bolt.android.chat.ChatDependencyProvider
        public ReadMessageInteractor b() {
            return new ReadMessageInteractor(this.S.get());
        }

        @Override // eu.bolt.android.chat.ChatDependencyProvider
        public SendChatMessageInteractor c() {
            return new SendChatMessageInteractor(this.S.get(), this.f36713z.get(), this.f36695h.get(), this.f36690c.get());
        }

        @Override // eu.bolt.android.chat.ChatDependencyProvider
        public ChatPushHandler d() {
            return this.U.get();
        }

        @Override // eu.bolt.android.chat.ChatDependencyProvider
        public RequestReplySuggestionsInteractor e() {
            return new RequestReplySuggestionsInteractor(this.S.get(), this.f36713z.get());
        }

        @Override // eu.bolt.android.chat.ChatDependencyProvider
        public CreateChatInteractor f() {
            return new CreateChatInteractor(this.S.get());
        }

        @Override // eu.bolt.android.chat.ChatDependencyProvider
        public ChatRepo g() {
            return this.S.get();
        }

        private ChatComponentImpl(ChatCoreModule chatCoreModule, ChatEngineModule chatEngineModule, ChatDbModule chatDbModule, MqttControllerModule mqttControllerModule, Context context) {
            this.f36688a = this;
            h(chatCoreModule, chatEngineModule, chatDbModule, mqttControllerModule, context);
        }
    }

    private DaggerChatComponent() {
    }

    public static ChatComponent.Builder a() {
        return new Builder();
    }
}
