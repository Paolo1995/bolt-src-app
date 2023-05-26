package eu.bolt.chat.client;

import co.touchlab.kermit.Logger;
import co.touchlab.kermit.Severity;
import eu.bolt.chat.data.EndChatInfo;
import eu.bolt.chat.util.CoroutineRunner;
import eu.bolt.chat.util.CoroutineRunnerKt;
import java.util.Collection;
import java.util.HashMap;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.SupervisorKt;
import org.koin.core.parameter.ParametersHolder;
import org.koin.core.parameter.ParametersHolderKt;
import org.koin.core.scope.Scope;

/* compiled from: ChatManagerFactory.kt */
/* loaded from: classes5.dex */
public final class DefaultChatManagerFactory implements ChatManagerFactory {

    /* renamed from: a  reason: collision with root package name */
    private final CoroutineDispatcher f38840a;

    /* renamed from: b  reason: collision with root package name */
    private final Scope f38841b;

    /* renamed from: c  reason: collision with root package name */
    private final Logger f38842c;

    /* renamed from: d  reason: collision with root package name */
    private final Object f38843d;

    /* renamed from: e  reason: collision with root package name */
    private final HashMap<String, FactoryCacheEntry> f38844e;

    public DefaultChatManagerFactory(CoroutineDispatcher workerDispatcher, Scope injectionScope, Logger logger) {
        Intrinsics.f(workerDispatcher, "workerDispatcher");
        Intrinsics.f(injectionScope, "injectionScope");
        Intrinsics.f(logger, "logger");
        this.f38840a = workerDispatcher;
        this.f38841b = injectionScope;
        this.f38842c = logger;
        this.f38843d = new Object();
        this.f38844e = new HashMap<>();
    }

    private final FactoryCacheEntry b(final String str) {
        Logger logger = this.f38842c;
        Severity a8 = logger.c().a();
        Severity severity = Severity.Info;
        if (a8.compareTo(severity) <= 0) {
            String d8 = logger.d();
            logger.f(severity, d8, null, "Creating a chat manager for " + str);
        }
        CoroutineScope a9 = CoroutineScopeKt.a(SupervisorKt.b(null, 1, null).s0(this.f38840a));
        final CoroutineRunner a10 = CoroutineRunnerKt.a(a9);
        return new FactoryCacheEntry((InternalChatManager) this.f38841b.f(Reflection.b(InternalChatManager.class), null, new Function0<ParametersHolder>() { // from class: eu.bolt.chat.client.DefaultChatManagerFactory$createChatManagerEntry$chatManager$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            /* renamed from: b */
            public final ParametersHolder invoke() {
                return ParametersHolderKt.b(str, a10);
            }
        }), a9);
    }

    private final FactoryCacheEntry c(String str, EndChatInfo endChatInfo) {
        return new FactoryCacheEntry(new ChatManagerStub(str, endChatInfo), null, 2, null);
    }

    @Override // eu.bolt.chat.client.ChatManagerFactory
    public void a(String chatId, EndChatInfo endChatInfo) {
        CoroutineScope a8;
        Intrinsics.f(chatId, "chatId");
        Intrinsics.f(endChatInfo, "endChatInfo");
        synchronized (this.f38843d) {
            Logger logger = this.f38842c;
            Severity a9 = logger.c().a();
            Severity severity = Severity.Info;
            if (a9.compareTo(severity) <= 0) {
                String d8 = logger.d();
                logger.f(severity, d8, null, "Removing chat manager for " + chatId + " from the cache");
            }
            FactoryCacheEntry factoryCacheEntry = this.f38844e.get(chatId);
            if (factoryCacheEntry != null && (a8 = factoryCacheEntry.a()) != null) {
                CoroutineScopeKt.d(a8, null, 1, null);
            }
            this.f38844e.put(chatId, c(chatId, endChatInfo));
            Unit unit = Unit.f50853a;
        }
    }

    @Override // eu.bolt.chat.client.ChatManagerFactory
    public void clear() {
        synchronized (this.f38843d) {
            Logger logger = this.f38842c;
            Severity a8 = logger.c().a();
            Severity severity = Severity.Info;
            if (a8.compareTo(severity) <= 0) {
                logger.f(severity, logger.d(), null, "Clearing chat manager cache");
            }
            Collection<FactoryCacheEntry> values = this.f38844e.values();
            Intrinsics.e(values, "chatManagerCache.values");
            for (FactoryCacheEntry factoryCacheEntry : values) {
                CoroutineScope a9 = factoryCacheEntry.a();
                if (a9 != null) {
                    CoroutineScopeKt.d(a9, null, 1, null);
                }
            }
            this.f38844e.clear();
            Unit unit = Unit.f50853a;
        }
    }

    @Override // eu.bolt.chat.client.ChatManagerFactory
    public InternalChatManager get(String chatId) {
        InternalChatManager b8;
        Intrinsics.f(chatId, "chatId");
        synchronized (this.f38843d) {
            HashMap<String, FactoryCacheEntry> hashMap = this.f38844e;
            FactoryCacheEntry factoryCacheEntry = hashMap.get(chatId);
            if (factoryCacheEntry == null) {
                factoryCacheEntry = b(chatId);
                hashMap.put(chatId, factoryCacheEntry);
            }
            b8 = factoryCacheEntry.b();
        }
        return b8;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: ChatManagerFactory.kt */
    /* loaded from: classes5.dex */
    public static final class FactoryCacheEntry {

        /* renamed from: a  reason: collision with root package name */
        private final InternalChatManager f38845a;

        /* renamed from: b  reason: collision with root package name */
        private final CoroutineScope f38846b;

        public FactoryCacheEntry(InternalChatManager chatManager, CoroutineScope coroutineScope) {
            Intrinsics.f(chatManager, "chatManager");
            this.f38845a = chatManager;
            this.f38846b = coroutineScope;
        }

        public final CoroutineScope a() {
            return this.f38846b;
        }

        public final InternalChatManager b() {
            return this.f38845a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof FactoryCacheEntry) {
                FactoryCacheEntry factoryCacheEntry = (FactoryCacheEntry) obj;
                return Intrinsics.a(this.f38845a, factoryCacheEntry.f38845a) && Intrinsics.a(this.f38846b, factoryCacheEntry.f38846b);
            }
            return false;
        }

        public int hashCode() {
            int hashCode = this.f38845a.hashCode() * 31;
            CoroutineScope coroutineScope = this.f38846b;
            return hashCode + (coroutineScope == null ? 0 : coroutineScope.hashCode());
        }

        public String toString() {
            return "FactoryCacheEntry(chatManager=" + this.f38845a + ", coroutineScope=" + this.f38846b + ')';
        }

        public /* synthetic */ FactoryCacheEntry(InternalChatManager internalChatManager, CoroutineScope coroutineScope, int i8, DefaultConstructorMarker defaultConstructorMarker) {
            this(internalChatManager, (i8 & 2) != 0 ? null : coroutineScope);
        }
    }
}
