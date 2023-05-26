package kotlin.coroutines.intrinsics;

import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.coroutines.jvm.internal.BaseContinuationImpl;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.coroutines.jvm.internal.RestrictedContinuationImpl;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: IntrinsicsJvm.kt */
/* loaded from: classes5.dex */
public class IntrinsicsKt__IntrinsicsJvmKt {
    public static <T> Continuation<Unit> a(final Function1<? super Continuation<? super T>, ? extends Object> function1, Continuation<? super T> completion) {
        Intrinsics.f(function1, "<this>");
        Intrinsics.f(completion, "completion");
        final Continuation<?> a8 = DebugProbesKt.a(completion);
        if (function1 instanceof BaseContinuationImpl) {
            return ((BaseContinuationImpl) function1).create(a8);
        }
        final CoroutineContext context = a8.getContext();
        if (context == EmptyCoroutineContext.f50912f) {
            return new RestrictedContinuationImpl(a8, function1) { // from class: kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt$createCoroutineUnintercepted$$inlined$createCoroutineFromSuspendFunction$IntrinsicsKt__IntrinsicsJvmKt$1

                /* renamed from: f  reason: collision with root package name */
                private int f50917f;

                /* renamed from: g  reason: collision with root package name */
                final /* synthetic */ Function1 f50918g;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(a8);
                    this.f50918g = function1;
                    Intrinsics.d(a8, "null cannot be cast to non-null type kotlin.coroutines.Continuation<kotlin.Any?>");
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                protected Object invokeSuspend(Object obj) {
                    int i8 = this.f50917f;
                    if (i8 != 0) {
                        if (i8 == 1) {
                            this.f50917f = 2;
                            ResultKt.b(obj);
                            return obj;
                        }
                        throw new IllegalStateException("This coroutine had already completed".toString());
                    }
                    this.f50917f = 1;
                    ResultKt.b(obj);
                    Intrinsics.d(this.f50918g, "null cannot be cast to non-null type kotlin.Function1<kotlin.coroutines.Continuation<T of kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt.createCoroutineUnintercepted$lambda$0>, kotlin.Any?>");
                    return ((Function1) TypeIntrinsics.e(this.f50918g, 1)).invoke(this);
                }
            };
        }
        return new ContinuationImpl(a8, context, function1) { // from class: kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt$createCoroutineUnintercepted$$inlined$createCoroutineFromSuspendFunction$IntrinsicsKt__IntrinsicsJvmKt$2

            /* renamed from: f  reason: collision with root package name */
            private int f50919f;

            /* renamed from: g  reason: collision with root package name */
            final /* synthetic */ Function1 f50920g;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(a8, context);
                this.f50920g = function1;
                Intrinsics.d(a8, "null cannot be cast to non-null type kotlin.coroutines.Continuation<kotlin.Any?>");
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            protected Object invokeSuspend(Object obj) {
                int i8 = this.f50919f;
                if (i8 != 0) {
                    if (i8 == 1) {
                        this.f50919f = 2;
                        ResultKt.b(obj);
                        return obj;
                    }
                    throw new IllegalStateException("This coroutine had already completed".toString());
                }
                this.f50919f = 1;
                ResultKt.b(obj);
                Intrinsics.d(this.f50920g, "null cannot be cast to non-null type kotlin.Function1<kotlin.coroutines.Continuation<T of kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt.createCoroutineUnintercepted$lambda$0>, kotlin.Any?>");
                return ((Function1) TypeIntrinsics.e(this.f50920g, 1)).invoke(this);
            }
        };
    }

    public static <R, T> Continuation<Unit> b(final Function2<? super R, ? super Continuation<? super T>, ? extends Object> function2, final R r7, Continuation<? super T> completion) {
        Intrinsics.f(function2, "<this>");
        Intrinsics.f(completion, "completion");
        final Continuation<?> a8 = DebugProbesKt.a(completion);
        if (function2 instanceof BaseContinuationImpl) {
            return ((BaseContinuationImpl) function2).create(r7, a8);
        }
        final CoroutineContext context = a8.getContext();
        if (context == EmptyCoroutineContext.f50912f) {
            return new RestrictedContinuationImpl(a8, function2, r7) { // from class: kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt$createCoroutineUnintercepted$$inlined$createCoroutineFromSuspendFunction$IntrinsicsKt__IntrinsicsJvmKt$3

                /* renamed from: f  reason: collision with root package name */
                private int f50921f;

                /* renamed from: g  reason: collision with root package name */
                final /* synthetic */ Function2 f50922g;

                /* renamed from: h  reason: collision with root package name */
                final /* synthetic */ Object f50923h;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(a8);
                    this.f50922g = function2;
                    this.f50923h = r7;
                    Intrinsics.d(a8, "null cannot be cast to non-null type kotlin.coroutines.Continuation<kotlin.Any?>");
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                protected Object invokeSuspend(Object obj) {
                    int i8 = this.f50921f;
                    if (i8 != 0) {
                        if (i8 == 1) {
                            this.f50921f = 2;
                            ResultKt.b(obj);
                            return obj;
                        }
                        throw new IllegalStateException("This coroutine had already completed".toString());
                    }
                    this.f50921f = 1;
                    ResultKt.b(obj);
                    Intrinsics.d(this.f50922g, "null cannot be cast to non-null type kotlin.Function2<R of kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt.createCoroutineUnintercepted$lambda$1, kotlin.coroutines.Continuation<T of kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt.createCoroutineUnintercepted$lambda$1>, kotlin.Any?>");
                    return ((Function2) TypeIntrinsics.e(this.f50922g, 2)).s(this.f50923h, this);
                }
            };
        }
        return new ContinuationImpl(a8, context, function2, r7) { // from class: kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt$createCoroutineUnintercepted$$inlined$createCoroutineFromSuspendFunction$IntrinsicsKt__IntrinsicsJvmKt$4

            /* renamed from: f  reason: collision with root package name */
            private int f50924f;

            /* renamed from: g  reason: collision with root package name */
            final /* synthetic */ Function2 f50925g;

            /* renamed from: h  reason: collision with root package name */
            final /* synthetic */ Object f50926h;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(a8, context);
                this.f50925g = function2;
                this.f50926h = r7;
                Intrinsics.d(a8, "null cannot be cast to non-null type kotlin.coroutines.Continuation<kotlin.Any?>");
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            protected Object invokeSuspend(Object obj) {
                int i8 = this.f50924f;
                if (i8 != 0) {
                    if (i8 == 1) {
                        this.f50924f = 2;
                        ResultKt.b(obj);
                        return obj;
                    }
                    throw new IllegalStateException("This coroutine had already completed".toString());
                }
                this.f50924f = 1;
                ResultKt.b(obj);
                Intrinsics.d(this.f50925g, "null cannot be cast to non-null type kotlin.Function2<R of kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt.createCoroutineUnintercepted$lambda$1, kotlin.coroutines.Continuation<T of kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt.createCoroutineUnintercepted$lambda$1>, kotlin.Any?>");
                return ((Function2) TypeIntrinsics.e(this.f50925g, 2)).s(this.f50926h, this);
            }
        };
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static <T> Continuation<T> c(Continuation<? super T> continuation) {
        ContinuationImpl continuationImpl;
        Continuation<T> continuation2;
        Intrinsics.f(continuation, "<this>");
        if (continuation instanceof ContinuationImpl) {
            continuationImpl = (ContinuationImpl) continuation;
        } else {
            continuationImpl = null;
        }
        if (continuationImpl != null && (continuation2 = (Continuation<T>) continuationImpl.intercepted()) != null) {
            return continuation2;
        }
        return continuation;
    }
}
