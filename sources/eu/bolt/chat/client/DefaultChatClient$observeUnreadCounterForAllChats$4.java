package eu.bolt.chat.client;

import eu.bolt.chat.async.ObservableStateFlow;
import java.util.List;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.internal.CombineKt;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: DefaultChatClient.kt */
@DebugMetadata(c = "eu.bolt.chat.client.DefaultChatClient$observeUnreadCounterForAllChats$4", f = "DefaultChatClient.kt", l = {}, m = "invokeSuspend")
/* loaded from: classes5.dex */
public final class DefaultChatClient$observeUnreadCounterForAllChats$4 extends SuspendLambda implements Function2<List<? extends ObservableStateFlow<Integer>>, Continuation<? super Flow<? extends Integer>>, Object> {

    /* renamed from: g  reason: collision with root package name */
    int f38783g;

    /* renamed from: h  reason: collision with root package name */
    /* synthetic */ Object f38784h;

    /* JADX INFO: Access modifiers changed from: package-private */
    public DefaultChatClient$observeUnreadCounterForAllChats$4(Continuation<? super DefaultChatClient$observeUnreadCounterForAllChats$4> continuation) {
        super(2, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        DefaultChatClient$observeUnreadCounterForAllChats$4 defaultChatClient$observeUnreadCounterForAllChats$4 = new DefaultChatClient$observeUnreadCounterForAllChats$4(continuation);
        defaultChatClient$observeUnreadCounterForAllChats$4.f38784h = obj;
        return defaultChatClient$observeUnreadCounterForAllChats$4;
    }

    @Override // kotlin.jvm.functions.Function2
    /* renamed from: h */
    public final Object s(List<ObservableStateFlow<Integer>> list, Continuation<? super Flow<Integer>> continuation) {
        return ((DefaultChatClient$observeUnreadCounterForAllChats$4) create(list, continuation)).invokeSuspend(Unit.f50853a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        List H0;
        IntrinsicsKt__IntrinsicsKt.d();
        if (this.f38783g == 0) {
            ResultKt.b(obj);
            H0 = CollectionsKt___CollectionsKt.H0((List) this.f38784h);
            Object[] array = H0.toArray(new Flow[0]);
            if (array != null) {
                final Flow[] flowArr = (Flow[]) array;
                return new Flow<Integer>() { // from class: eu.bolt.chat.client.DefaultChatClient$observeUnreadCounterForAllChats$4$invokeSuspend$$inlined$combine$1

                    /* compiled from: Zip.kt */
                    @DebugMetadata(c = "eu.bolt.chat.client.DefaultChatClient$observeUnreadCounterForAllChats$4$invokeSuspend$$inlined$combine$1$3", f = "DefaultChatClient.kt", l = {292}, m = "invokeSuspend")
                    /* renamed from: eu.bolt.chat.client.DefaultChatClient$observeUnreadCounterForAllChats$4$invokeSuspend$$inlined$combine$1$3  reason: invalid class name */
                    /* loaded from: classes5.dex */
                    public static final class AnonymousClass3 extends SuspendLambda implements Function3<FlowCollector<? super Integer>, Integer[], Continuation<? super Unit>, Object> {

                        /* renamed from: g  reason: collision with root package name */
                        int f38681g;

                        /* renamed from: h  reason: collision with root package name */
                        private /* synthetic */ Object f38682h;

                        /* renamed from: i  reason: collision with root package name */
                        /* synthetic */ Object f38683i;

                        public AnonymousClass3(Continuation continuation) {
                            super(3, continuation);
                        }

                        @Override // kotlin.jvm.functions.Function3
                        /* renamed from: h */
                        public final Object l(FlowCollector<? super Integer> flowCollector, Integer[] numArr, Continuation<? super Unit> continuation) {
                            AnonymousClass3 anonymousClass3 = new AnonymousClass3(continuation);
                            anonymousClass3.f38682h = flowCollector;
                            anonymousClass3.f38683i = numArr;
                            return anonymousClass3.invokeSuspend(Unit.f50853a);
                        }

                        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                        public final Object invokeSuspend(Object obj) {
                            Object d8;
                            int c02;
                            d8 = IntrinsicsKt__IntrinsicsKt.d();
                            int i8 = this.f38681g;
                            if (i8 != 0) {
                                if (i8 == 1) {
                                    ResultKt.b(obj);
                                } else {
                                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                                }
                            } else {
                                ResultKt.b(obj);
                                c02 = ArraysKt___ArraysKt.c0((Integer[]) ((Object[]) this.f38683i));
                                Integer b8 = Boxing.b(c02);
                                this.f38681g = 1;
                                if (((FlowCollector) this.f38682h).b(b8, this) == d8) {
                                    return d8;
                                }
                            }
                            return Unit.f50853a;
                        }
                    }

                    @Override // kotlinx.coroutines.flow.Flow
                    public Object a(FlowCollector<? super Integer> flowCollector, Continuation continuation) {
                        Object d8;
                        final Flow[] flowArr2 = flowArr;
                        Object a8 = CombineKt.a(flowCollector, flowArr2, new Function0<Integer[]>() { // from class: eu.bolt.chat.client.DefaultChatClient$observeUnreadCounterForAllChats$4$invokeSuspend$$inlined$combine$1.2
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(0);
                            }

                            @Override // kotlin.jvm.functions.Function0
                            /* renamed from: b */
                            public final Integer[] invoke() {
                                return new Integer[flowArr2.length];
                            }
                        }, new AnonymousClass3(null), continuation);
                        d8 = IntrinsicsKt__IntrinsicsKt.d();
                        if (a8 == d8) {
                            return a8;
                        }
                        return Unit.f50853a;
                    }
                };
            }
            throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
