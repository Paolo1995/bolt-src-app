package eu.bolt.chat.extensions;

import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* compiled from: ChatRxExtensions.kt */
/* loaded from: classes5.dex */
public final class ChatRxExtensionsKt$andThen$2 extends Lambda implements Function0<Object> {

    /* renamed from: f  reason: collision with root package name */
    final /* synthetic */ Function0<Object> f39098f;

    /* renamed from: g  reason: collision with root package name */
    final /* synthetic */ Function0<Unit> f39099g;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ChatRxExtensionsKt$andThen$2(Function0<Object> function0, Function0<Unit> function02) {
        super(0);
        this.f39098f = function0;
        this.f39099g = function02;
    }

    @Override // kotlin.jvm.functions.Function0
    public final Object invoke() {
        Object invoke = this.f39098f.invoke();
        this.f39099g.invoke();
        return invoke;
    }
}
