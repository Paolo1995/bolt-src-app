package eu.bolt.chat.extensions;

import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

/* compiled from: ChatRxExtensions.kt */
/* loaded from: classes5.dex */
public final class ChatRxExtensionsKt$andThen$1 extends Lambda implements Function1<Object, Object> {

    /* renamed from: f  reason: collision with root package name */
    final /* synthetic */ Function1<Object, Object> f39096f;

    /* renamed from: g  reason: collision with root package name */
    final /* synthetic */ Function0<Unit> f39097g;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ChatRxExtensionsKt$andThen$1(Function1<Object, Object> function1, Function0<Unit> function0) {
        super(1);
        this.f39096f = function1;
        this.f39097g = function0;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        Object invoke = this.f39096f.invoke(obj);
        this.f39097g.invoke();
        return invoke;
    }
}
