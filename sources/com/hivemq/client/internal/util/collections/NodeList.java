package com.hivemq.client.internal.util.collections;

import com.hivemq.client.internal.util.collections.NodeList.Node;

/* loaded from: classes3.dex */
public class NodeList<N extends Node<N>> {

    /* renamed from: a  reason: collision with root package name */
    private N f18730a;

    /* renamed from: b  reason: collision with root package name */
    private N f18731b;

    /* renamed from: c  reason: collision with root package name */
    private int f18732c;

    /* loaded from: classes3.dex */
    public static abstract class Node<N extends Node<N>> {

        /* renamed from: a  reason: collision with root package name */
        N f18733a;

        /* renamed from: b  reason: collision with root package name */
        N f18734b;

        public N a() {
            return this.f18734b;
        }

        public N b() {
            return this.f18733a;
        }
    }

    public void a(N n8) {
        N n9 = this.f18731b;
        if (n9 == null) {
            this.f18731b = n8;
            this.f18730a = n8;
        } else {
            n9.f18734b = n8;
            n8.f18733a = n9;
            this.f18731b = n8;
        }
        this.f18732c++;
    }

    public void b(N n8) {
        N n9 = this.f18730a;
        if (n9 == null) {
            this.f18731b = n8;
            this.f18730a = n8;
        } else {
            n9.f18733a = n8;
            n8.f18734b = n9;
            this.f18730a = n8;
        }
        this.f18732c++;
    }

    public void c() {
        this.f18730a = null;
        this.f18731b = null;
        this.f18732c = 0;
    }

    public N d() {
        return this.f18730a;
    }

    public N e() {
        return this.f18731b;
    }

    public boolean f() {
        if (this.f18730a == null) {
            return true;
        }
        return false;
    }

    public void g(N n8) {
        N n9 = n8.f18733a;
        N n10 = n8.f18734b;
        if (n9 == null) {
            this.f18730a = n10;
        } else {
            n9.f18734b = n10;
        }
        if (n10 == null) {
            this.f18731b = n9;
        } else {
            n10.f18733a = n9;
        }
        this.f18732c--;
    }

    public void h(N n8, N n9) {
        N n10 = n8.f18733a;
        N n11 = n8.f18734b;
        n9.f18733a = n10;
        n9.f18734b = n11;
        if (n10 == null) {
            this.f18730a = n9;
        } else {
            n10.f18734b = n9;
        }
        if (n11 == null) {
            this.f18731b = n9;
        } else {
            n11.f18733a = n9;
        }
    }
}
