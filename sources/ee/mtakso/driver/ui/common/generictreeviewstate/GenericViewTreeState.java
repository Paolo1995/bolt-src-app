package ee.mtakso.driver.ui.common.generictreeviewstate;

import ee.mtakso.driver.uikit.recyclerview.ListModel;
import ee.mtakso.driver.utils.AssertUtils;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: GenericViewTreeState.kt */
/* loaded from: classes3.dex */
public final class GenericViewTreeState {

    /* renamed from: a  reason: collision with root package name */
    private final Node f26360a;

    public GenericViewTreeState(Node root) {
        Intrinsics.f(root, "root");
        this.f26360a = root;
    }

    private final void b(Node node) {
        GenericViewState d8 = node.d();
        if (d8 != null) {
            d8.c(true);
        }
        for (Node node2 : node.a()) {
            b(node2);
        }
    }

    private final Node d(String str) {
        Node node;
        LinkedList linkedList = new LinkedList();
        linkedList.add(this.f26360a);
        while ((!linkedList.isEmpty()) && (node = (Node) linkedList.remove()) != null) {
            if (Intrinsics.a(node.c(), str)) {
                return node;
            }
            for (Node node2 : node.a()) {
                linkedList.add(node2);
            }
        }
        return null;
    }

    private final void e(Node node, List<Node> list) {
        if (node == null) {
            return;
        }
        GenericViewState d8 = node.d();
        if (d8 != null) {
            list.add(node);
        }
        boolean z7 = true;
        if (((d8 == null || !d8.a()) ? false : false) && d8.d()) {
            return;
        }
        for (Node node2 : node.a()) {
            e(node2, list);
        }
    }

    private final List<ListModel> g(List<Node> list) {
        ArrayList arrayList = new ArrayList();
        int size = list.size();
        for (int i8 = 0; i8 < size; i8++) {
            Node node = list.get(i8);
            GenericViewState d8 = node.d();
            if (d8 != null) {
                arrayList.add(d8.b(node.c(), node.b(), node.a().size()));
            }
        }
        return arrayList;
    }

    public final void a() {
        b(this.f26360a);
    }

    public final boolean c(String id) {
        GenericViewState genericViewState;
        Intrinsics.f(id, "id");
        Node d8 = d(id);
        if (d8 != null) {
            genericViewState = d8.d();
        } else {
            genericViewState = null;
        }
        if (d8 == null) {
            AssertUtils.a("You're trying to modify element, which is not presented in the view tree. Node id: " + id);
        } else if (genericViewState != null && genericViewState.a() && !d8.a().isEmpty()) {
            genericViewState.c(!genericViewState.d());
            return true;
        }
        return false;
    }

    public final List<ListModel> f() {
        ArrayList arrayList = new ArrayList();
        e(this.f26360a, arrayList);
        return g(arrayList);
    }

    /* compiled from: GenericViewTreeState.kt */
    /* loaded from: classes3.dex */
    public static final class Node {

        /* renamed from: a  reason: collision with root package name */
        private final String f26361a;

        /* renamed from: b  reason: collision with root package name */
        private final int f26362b;

        /* renamed from: c  reason: collision with root package name */
        private final GenericViewState f26363c;

        /* renamed from: d  reason: collision with root package name */
        private final List<Node> f26364d;

        public Node(String id, int i8, GenericViewState genericViewState, List<Node> children) {
            Intrinsics.f(id, "id");
            Intrinsics.f(children, "children");
            this.f26361a = id;
            this.f26362b = i8;
            this.f26363c = genericViewState;
            this.f26364d = children;
        }

        public final List<Node> a() {
            return this.f26364d;
        }

        public final int b() {
            return this.f26362b;
        }

        public final String c() {
            return this.f26361a;
        }

        public final GenericViewState d() {
            return this.f26363c;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof Node) {
                Node node = (Node) obj;
                return Intrinsics.a(this.f26361a, node.f26361a) && this.f26362b == node.f26362b && Intrinsics.a(this.f26363c, node.f26363c) && Intrinsics.a(this.f26364d, node.f26364d);
            }
            return false;
        }

        public int hashCode() {
            int hashCode = ((this.f26361a.hashCode() * 31) + this.f26362b) * 31;
            GenericViewState genericViewState = this.f26363c;
            return ((hashCode + (genericViewState == null ? 0 : genericViewState.hashCode())) * 31) + this.f26364d.hashCode();
        }

        public String toString() {
            String str = this.f26361a;
            int i8 = this.f26362b;
            GenericViewState genericViewState = this.f26363c;
            List<Node> list = this.f26364d;
            return "Node(id=" + str + ", depth=" + i8 + ", viewState=" + genericViewState + ", children=" + list + ")";
        }

        public /* synthetic */ Node(String str, int i8, GenericViewState genericViewState, List list, int i9, DefaultConstructorMarker defaultConstructorMarker) {
            this(str, i8, genericViewState, (i9 & 8) != 0 ? CollectionsKt__CollectionsKt.k() : list);
        }
    }
}
