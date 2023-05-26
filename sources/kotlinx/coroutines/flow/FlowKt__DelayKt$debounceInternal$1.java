package kotlinx.coroutines.flow;

import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: Access modifiers changed from: package-private */
/* JADX INFO: Add missing generic type declarations: [T] */
/* compiled from: Delay.kt */
@DebugMetadata(c = "kotlinx.coroutines.flow.FlowKt__DelayKt$debounceInternal$1", f = "Delay.kt", l = {222, 355}, m = "invokeSuspend")
/* loaded from: classes5.dex */
public final class FlowKt__DelayKt$debounceInternal$1<T> extends SuspendLambda implements Function3<CoroutineScope, FlowCollector<? super T>, Continuation<? super Unit>, Object> {

    /* renamed from: g  reason: collision with root package name */
    Object f51462g;

    /* renamed from: h  reason: collision with root package name */
    Object f51463h;

    /* renamed from: i  reason: collision with root package name */
    int f51464i;

    /* renamed from: j  reason: collision with root package name */
    private /* synthetic */ Object f51465j;

    /* renamed from: k  reason: collision with root package name */
    /* synthetic */ Object f51466k;

    /* renamed from: l  reason: collision with root package name */
    final /* synthetic */ Function1<T, Long> f51467l;

    /* renamed from: m  reason: collision with root package name */
    final /* synthetic */ Flow<T> f51468m;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public FlowKt__DelayKt$debounceInternal$1(Function1<? super T, Long> function1, Flow<? extends T> flow, Continuation<? super FlowKt__DelayKt$debounceInternal$1> continuation) {
        super(3, continuation);
        this.f51467l = function1;
        this.f51468m = flow;
    }

    @Override // kotlin.jvm.functions.Function3
    /* renamed from: h */
    public final Object l(CoroutineScope coroutineScope, FlowCollector<? super T> flowCollector, Continuation<? super Unit> continuation) {
        FlowKt__DelayKt$debounceInternal$1 flowKt__DelayKt$debounceInternal$1 = new FlowKt__DelayKt$debounceInternal$1(this.f51467l, this.f51468m, continuation);
        flowKt__DelayKt$debounceInternal$1.f51465j = coroutineScope;
        flowKt__DelayKt$debounceInternal$1.f51466k = flowCollector;
        return flowKt__DelayKt$debounceInternal$1.invokeSuspend(Unit.f50853a);
    }

    /* JADX WARN: Can't wrap try/catch for region: R(11:50|26|30|31|32|33|(1:35)|36|37|(1:39)|(1:41)(1:42)) */
    /* JADX WARN: Code restructure failed: missing block: B:41:0x00f7, code lost:
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x00f8, code lost:
        r10.b0(r0);
     */
    /* JADX WARN: Removed duplicated region for block: B:38:0x00e0 A[Catch: all -> 0x00f7, TryCatch #0 {all -> 0x00f7, blocks: (B:36:0x00dc, B:38:0x00e0, B:39:0x00ea), top: B:51:0x00dc }] */
    /* JADX WARN: Removed duplicated region for block: B:45:0x0105  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x010a A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:48:0x010b  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:48:0x010b -> B:11:0x006f). Please submit an issue!!! */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r18) {
        /*
            Method dump skipped, instructions count: 276
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.flow.FlowKt__DelayKt$debounceInternal$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
