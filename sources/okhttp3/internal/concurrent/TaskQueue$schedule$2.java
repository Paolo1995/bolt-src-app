package okhttp3.internal.concurrent;

import kotlin.jvm.functions.Function0;

/* compiled from: TaskQueue.kt */
/* loaded from: classes5.dex */
public final class TaskQueue$schedule$2 extends Task {
    final /* synthetic */ Function0<Long> $block;
    final /* synthetic */ String $name;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TaskQueue$schedule$2(String str, Function0<Long> function0) {
        super(str, false, 2, null);
        this.$name = str;
        this.$block = function0;
    }

    @Override // okhttp3.internal.concurrent.Task
    public long runOnce() {
        return this.$block.invoke().longValue();
    }
}
