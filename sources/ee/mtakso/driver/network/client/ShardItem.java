package ee.mtakso.driver.network.client;

import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ShardItem.kt */
/* loaded from: classes3.dex */
public final class ShardItem<T> {

    /* renamed from: a  reason: collision with root package name */
    private final Function1<String, T> f21344a;

    /* renamed from: b  reason: collision with root package name */
    private String f21345b;

    /* renamed from: c  reason: collision with root package name */
    private T f21346c;

    /* JADX WARN: Multi-variable type inference failed */
    public ShardItem(Function1<? super String, ? extends T> itemFactory) {
        Intrinsics.f(itemFactory, "itemFactory");
        this.f21344a = itemFactory;
    }

    public final T a(String str) {
        T t7 = this.f21346c;
        if (!Intrinsics.a(str, this.f21345b) || t7 == null) {
            T invoke = this.f21344a.invoke(str);
            this.f21345b = str;
            this.f21346c = invoke;
            return invoke;
        }
        return t7;
    }
}
