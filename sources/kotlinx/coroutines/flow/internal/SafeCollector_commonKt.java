package kotlinx.coroutines.flow.internal;

import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.internal.ScopeCoroutine;

/* compiled from: SafeCollector.common.kt */
/* loaded from: classes5.dex */
public final class SafeCollector_commonKt {
    public static final void a(final SafeCollector<?> safeCollector, CoroutineContext coroutineContext) {
        if (((Number) coroutineContext.l(0, new Function2<Integer, CoroutineContext.Element, Integer>() { // from class: kotlinx.coroutines.flow.internal.SafeCollector_commonKt$checkContext$result$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
            }

            public final Integer b(int i8, CoroutineContext.Element element) {
                int i9;
                CoroutineContext.Key<?> key = element.getKey();
                CoroutineContext.Element g8 = safeCollector.f51753g.g(key);
                if (key != Job.f51296d) {
                    if (element != g8) {
                        i9 = Integer.MIN_VALUE;
                    } else {
                        i9 = i8 + 1;
                    }
                    return Integer.valueOf(i9);
                }
                Job job = (Job) g8;
                Job b8 = SafeCollector_commonKt.b((Job) element, job);
                if (b8 == job) {
                    if (job != null) {
                        i8++;
                    }
                    return Integer.valueOf(i8);
                }
                throw new IllegalStateException(("Flow invariant is violated:\n\t\tEmission from another coroutine is detected.\n\t\tChild of " + b8 + ", expected child of " + job + ".\n\t\tFlowCollector is not thread-safe and concurrent emissions are prohibited.\n\t\tTo mitigate this restriction please use 'channelFlow' builder instead of 'flow'").toString());
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Integer s(Integer num, CoroutineContext.Element element) {
                return b(num.intValue(), element);
            }
        })).intValue() == safeCollector.f51754h) {
            return;
        }
        throw new IllegalStateException(("Flow invariant is violated:\n\t\tFlow was collected in " + safeCollector.f51753g + ",\n\t\tbut emission happened in " + coroutineContext + ".\n\t\tPlease refer to 'flow' documentation or use 'flowOn' instead").toString());
    }

    public static final Job b(Job job, Job job2) {
        while (job != null) {
            if (job == job2) {
                return job;
            }
            if (!(job instanceof ScopeCoroutine)) {
                return job;
            }
            job = ((ScopeCoroutine) job).k1();
        }
        return null;
    }
}
