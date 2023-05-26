package eu.bolt.coroutines.dispatchers;

import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.Dispatchers;

/* compiled from: DispatchersBundleImpl.kt */
/* loaded from: classes5.dex */
public final class DispatchersBundleImpl implements DispatchersBundle {

    /* renamed from: a  reason: collision with root package name */
    private final CoroutineDispatcher f40345a;

    /* renamed from: b  reason: collision with root package name */
    private final CoroutineDispatcher f40346b;

    /* renamed from: c  reason: collision with root package name */
    private final CoroutineDispatcher f40347c;

    /* renamed from: d  reason: collision with root package name */
    private final CoroutineDispatcher f40348d;

    /* renamed from: e  reason: collision with root package name */
    private final CoroutineDispatcher f40349e;

    public DispatchersBundleImpl() {
        this(null, null, null, null, null, 31, null);
    }

    public DispatchersBundleImpl(CoroutineDispatcher io2, CoroutineDispatcher unconfined, CoroutineDispatcher main, CoroutineDispatcher immediate, CoroutineDispatcher coroutineDispatcher) {
        Intrinsics.f(io2, "io");
        Intrinsics.f(unconfined, "unconfined");
        Intrinsics.f(main, "main");
        Intrinsics.f(immediate, "immediate");
        Intrinsics.f(coroutineDispatcher, "default");
        this.f40345a = io2;
        this.f40346b = unconfined;
        this.f40347c = main;
        this.f40348d = immediate;
        this.f40349e = coroutineDispatcher;
    }

    @Override // eu.bolt.coroutines.dispatchers.DispatchersBundle
    public CoroutineDispatcher a() {
        return this.f40349e;
    }

    public /* synthetic */ DispatchersBundleImpl(CoroutineDispatcher coroutineDispatcher, CoroutineDispatcher coroutineDispatcher2, CoroutineDispatcher coroutineDispatcher3, CoroutineDispatcher coroutineDispatcher4, CoroutineDispatcher coroutineDispatcher5, int i8, DefaultConstructorMarker defaultConstructorMarker) {
        this((i8 & 1) != 0 ? Dispatchers.b() : coroutineDispatcher, (i8 & 2) != 0 ? Dispatchers.d() : coroutineDispatcher2, (i8 & 4) != 0 ? Dispatchers.c() : coroutineDispatcher3, (i8 & 8) != 0 ? Dispatchers.c().R0() : coroutineDispatcher4, (i8 & 16) != 0 ? Dispatchers.a() : coroutineDispatcher5);
    }
}
