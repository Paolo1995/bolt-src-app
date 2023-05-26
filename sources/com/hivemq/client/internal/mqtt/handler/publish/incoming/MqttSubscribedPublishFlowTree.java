package com.hivemq.client.internal.mqtt.handler.publish.incoming;

import com.hivemq.client.internal.mqtt.datatypes.MqttTopicFilterImpl;
import com.hivemq.client.internal.mqtt.datatypes.MqttTopicIterator;
import com.hivemq.client.internal.mqtt.datatypes.MqttTopicLevel;
import com.hivemq.client.internal.mqtt.datatypes.MqttTopicLevels;
import com.hivemq.client.internal.mqtt.handler.publish.incoming.MqttSubscribedPublishFlowTree;
import com.hivemq.client.internal.mqtt.message.publish.MqttPublish;
import com.hivemq.client.internal.mqtt.message.subscribe.MqttSubscription;
import com.hivemq.client.internal.util.collections.HandleList;
import com.hivemq.client.internal.util.collections.Index;
import com.hivemq.client.internal.util.collections.NodeList;
import j$.util.Comparator;
import j$.util.Map;
import j$.util.function.Consumer;
import j$.util.function.Function;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.TreeMap;

/* loaded from: classes3.dex */
public class MqttSubscribedPublishFlowTree implements MqttSubscribedPublishFlows {

    /* renamed from: a  reason: collision with root package name */
    private TopicTreeNode f18234a;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public static class IteratorNode {

        /* renamed from: a  reason: collision with root package name */
        final TopicTreeNode f18235a;

        /* renamed from: b  reason: collision with root package name */
        final MqttTopicLevel f18236b;

        IteratorNode(TopicTreeNode topicTreeNode, MqttTopicLevel mqttTopicLevel) {
            this.f18235a = topicTreeNode;
            this.f18236b = mqttTopicLevel;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public static class TopicTreeEntry extends NodeList.Node<TopicTreeEntry> {

        /* renamed from: c  reason: collision with root package name */
        final int f18237c;

        /* renamed from: d  reason: collision with root package name */
        final byte f18238d;

        /* renamed from: e  reason: collision with root package name */
        final byte[] f18239e;

        /* renamed from: f  reason: collision with root package name */
        MqttSubscribedPublishFlow f18240f;

        /* renamed from: g  reason: collision with root package name */
        HandleList.Handle<MqttTopicFilterImpl> f18241g;

        /* renamed from: h  reason: collision with root package name */
        boolean f18242h;

        TopicTreeEntry(MqttSubscription mqttSubscription, int i8, MqttSubscribedPublishFlow mqttSubscribedPublishFlow) {
            HandleList.Handle<MqttTopicFilterImpl> i9;
            this.f18237c = i8;
            this.f18238d = mqttSubscription.e();
            MqttTopicFilterImpl g8 = mqttSubscription.g();
            this.f18239e = g8.s();
            this.f18240f = mqttSubscribedPublishFlow;
            if (mqttSubscribedPublishFlow == null) {
                i9 = null;
            } else {
                i9 = mqttSubscribedPublishFlow.p().i(g8);
            }
            this.f18241g = i9;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public static class TopicTreeNode {

        /* renamed from: g  reason: collision with root package name */
        private static final Index.Spec<TopicTreeNode, MqttTopicLevel> f18243g = new Index.Spec<>(new Function() { // from class: com.hivemq.client.internal.mqtt.handler.publish.incoming.d
            @Override // j$.util.function.Function
            public /* synthetic */ Function andThen(Function function) {
                return Function.CC.$default$andThen(this, function);
            }

            @Override // j$.util.function.Function
            public final Object apply(Object obj) {
                MqttTopicLevel mqttTopicLevel;
                mqttTopicLevel = ((MqttSubscribedPublishFlowTree.TopicTreeNode) obj).f18245b;
                return mqttTopicLevel;
            }

            @Override // j$.util.function.Function
            public /* synthetic */ Function compose(Function function) {
                return Function.CC.$default$compose(this, function);
            }
        }, 4);

        /* renamed from: a  reason: collision with root package name */
        private TopicTreeNode f18244a;

        /* renamed from: b  reason: collision with root package name */
        private MqttTopicLevel f18245b;

        /* renamed from: c  reason: collision with root package name */
        private Index<TopicTreeNode, MqttTopicLevel> f18246c;

        /* renamed from: d  reason: collision with root package name */
        private TopicTreeNode f18247d;

        /* renamed from: e  reason: collision with root package name */
        private NodeList<TopicTreeEntry> f18248e;

        /* renamed from: f  reason: collision with root package name */
        private NodeList<TopicTreeEntry> f18249f;

        TopicTreeNode(TopicTreeNode topicTreeNode, MqttTopicLevel mqttTopicLevel) {
            this.f18244a = topicTreeNode;
            this.f18245b = mqttTopicLevel;
        }

        private static boolean A(NodeList<TopicTreeEntry> nodeList, MqttTopicFilterImpl mqttTopicFilterImpl) {
            if (nodeList != null) {
                byte[] s7 = mqttTopicFilterImpl.s();
                TopicTreeEntry d8 = nodeList.d();
                while (true) {
                    TopicTreeEntry topicTreeEntry = d8;
                    if (topicTreeEntry != null) {
                        if (Arrays.equals(s7, topicTreeEntry.f18239e) && topicTreeEntry.f18242h) {
                            MqttSubscribedPublishFlow mqttSubscribedPublishFlow = topicTreeEntry.f18240f;
                            if (mqttSubscribedPublishFlow != null) {
                                mqttSubscribedPublishFlow.p().g(topicTreeEntry.f18241g);
                                if (topicTreeEntry.f18240f.p().f()) {
                                    topicTreeEntry.f18240f.onComplete();
                                }
                            }
                            nodeList.g(topicTreeEntry);
                        }
                        d8 = topicTreeEntry.a();
                    } else {
                        return nodeList.f();
                    }
                }
            } else {
                return false;
            }
        }

        private static void d(MqttStatefulPublishWithFlows mqttStatefulPublishWithFlows, NodeList<TopicTreeEntry> nodeList) {
            if (nodeList != null) {
                mqttStatefulPublishWithFlows.f18231g = true;
                TopicTreeEntry d8 = nodeList.d();
                while (true) {
                    TopicTreeEntry topicTreeEntry = d8;
                    if (topicTreeEntry != null) {
                        MqttSubscribedPublishFlow mqttSubscribedPublishFlow = topicTreeEntry.f18240f;
                        if (mqttSubscribedPublishFlow != null) {
                            mqttStatefulPublishWithFlows.i(mqttSubscribedPublishFlow);
                        }
                        d8 = topicTreeEntry.a();
                    } else {
                        return;
                    }
                }
            }
        }

        private static void f(NodeList<TopicTreeEntry> nodeList, MqttSubscribedPublishFlow mqttSubscribedPublishFlow) {
            if (nodeList != null) {
                TopicTreeEntry d8 = nodeList.d();
                while (true) {
                    TopicTreeEntry topicTreeEntry = d8;
                    if (topicTreeEntry != null) {
                        if (topicTreeEntry.f18240f == mqttSubscribedPublishFlow) {
                            topicTreeEntry.f18240f = null;
                            topicTreeEntry.f18241g = null;
                            return;
                        }
                        d8 = topicTreeEntry.a();
                    } else {
                        return;
                    }
                }
            }
        }

        private static void h(NodeList<TopicTreeEntry> nodeList, Throwable th) {
            TopicTreeEntry d8 = nodeList.d();
            while (true) {
                TopicTreeEntry topicTreeEntry = d8;
                if (topicTreeEntry != null) {
                    MqttSubscribedPublishFlow mqttSubscribedPublishFlow = topicTreeEntry.f18240f;
                    if (mqttSubscribedPublishFlow != null && topicTreeEntry.f18242h) {
                        mqttSubscribedPublishFlow.onError(th);
                    }
                    d8 = topicTreeEntry.a();
                } else {
                    return;
                }
            }
        }

        private void i() {
            boolean z7;
            TopicTreeNode topicTreeNode = this.f18244a;
            if (topicTreeNode != null && this.f18248e == null && this.f18249f == null) {
                TopicTreeNode topicTreeNode2 = this.f18247d;
                boolean z8 = false;
                if (topicTreeNode2 != null) {
                    z7 = true;
                } else {
                    z7 = false;
                }
                Index<TopicTreeNode, MqttTopicLevel> index = this.f18246c;
                if (index != null) {
                    z8 = true;
                }
                if (!z7 && !z8) {
                    topicTreeNode.t(this);
                    this.f18244a.i();
                } else if (z7 && !z8) {
                    l(topicTreeNode2);
                } else if (!z7 && index.m() == 1) {
                    l(this.f18246c.c());
                }
            }
        }

        private static TopicTreeNode k(TopicTreeNode topicTreeNode, MqttTopicIterator mqttTopicIterator) {
            if (topicTreeNode == null) {
                return null;
            }
            MqttTopicLevel mqttTopicLevel = topicTreeNode.f18245b;
            if (mqttTopicLevel instanceof MqttTopicLevels) {
                if (!mqttTopicIterator.l((MqttTopicLevels) mqttTopicLevel)) {
                    return null;
                }
                return topicTreeNode;
            }
            return topicTreeNode;
        }

        private void l(TopicTreeNode topicTreeNode) {
            TopicTreeNode topicTreeNode2 = this.f18244a;
            MqttTopicLevels l8 = MqttTopicLevels.l(this.f18245b, topicTreeNode.f18245b);
            topicTreeNode.f18244a = topicTreeNode2;
            topicTreeNode.f18245b = l8;
            if (l8.e()) {
                topicTreeNode2.f18247d = topicTreeNode;
            } else {
                topicTreeNode2.f18246c.h(topicTreeNode);
            }
        }

        private TopicTreeNode m(TopicTreeNode topicTreeNode, MqttTopicIterator mqttTopicIterator) {
            MqttTopicLevels mqttTopicLevels;
            int m8;
            MqttTopicLevel k8;
            MqttTopicLevel mqttTopicLevel = topicTreeNode.f18245b;
            if ((mqttTopicLevel instanceof MqttTopicLevels) && (k8 = mqttTopicLevels.k((m8 = mqttTopicIterator.m((mqttTopicLevels = (MqttTopicLevels) mqttTopicLevel))))) != mqttTopicLevels) {
                MqttTopicLevel j8 = mqttTopicLevels.j(m8);
                TopicTreeNode topicTreeNode2 = new TopicTreeNode(this, k8);
                if (k8.e()) {
                    this.f18247d = topicTreeNode2;
                } else {
                    this.f18246c.h(topicTreeNode2);
                }
                topicTreeNode.f18244a = topicTreeNode2;
                topicTreeNode.f18245b = j8;
                if (j8.e()) {
                    topicTreeNode2.f18247d = topicTreeNode;
                } else {
                    Index<TopicTreeNode, MqttTopicLevel> index = new Index<>(f18243g);
                    topicTreeNode2.f18246c = index;
                    index.h(topicTreeNode);
                }
                return topicTreeNode2;
            }
            return topicTreeNode;
        }

        private static void o(NodeList<TopicTreeEntry> nodeList, MqttTopicLevel mqttTopicLevel, boolean z7, Map<Integer, List<MqttSubscription>> map) {
            boolean z8 = false;
            for (TopicTreeEntry e8 = nodeList.e(); e8 != null; e8 = e8.b()) {
                if (e8.f18242h) {
                    byte[] bArr = e8.f18239e;
                    if (bArr == null) {
                        if (!z8) {
                            z8 = true;
                        }
                    }
                    ((List) Map.EL.computeIfAbsent(map, Integer.valueOf(e8.f18237c), new Function() { // from class: com.hivemq.client.internal.mqtt.handler.publish.incoming.c
                        @Override // j$.util.function.Function
                        public /* synthetic */ Function andThen(Function function) {
                            return Function.CC.$default$andThen(this, function);
                        }

                        @Override // j$.util.function.Function
                        public final Object apply(Object obj) {
                            List r7;
                            r7 = MqttSubscribedPublishFlowTree.TopicTreeNode.r((Integer) obj);
                            return r7;
                        }

                        @Override // j$.util.function.Function
                        public /* synthetic */ Function compose(Function function) {
                            return Function.CC.$default$compose(this, function);
                        }
                    })).add(new MqttSubscription(MqttTopicLevel.h(bArr, mqttTopicLevel, z7), MqttSubscription.b(e8.f18238d), MqttSubscription.a(e8.f18238d), MqttSubscription.d(e8.f18238d), MqttSubscription.c(e8.f18238d)));
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ void q(Queue queue, MqttTopicLevel mqttTopicLevel, TopicTreeNode topicTreeNode) {
            queue.add(new IteratorNode(topicTreeNode, mqttTopicLevel));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ List r(Integer num) {
            return new LinkedList();
        }

        private void t(TopicTreeNode topicTreeNode) {
            if (topicTreeNode.f18245b.e()) {
                this.f18247d = null;
                return;
            }
            this.f18246c.j(topicTreeNode.f18245b);
            if (this.f18246c.m() == 0) {
                this.f18246c = null;
            }
        }

        private static boolean v(NodeList<TopicTreeEntry> nodeList, MqttTopicFilterImpl mqttTopicFilterImpl, int i8, boolean z7) {
            if (nodeList != null) {
                byte[] s7 = mqttTopicFilterImpl.s();
                TopicTreeEntry d8 = nodeList.d();
                while (true) {
                    TopicTreeEntry topicTreeEntry = d8;
                    if (topicTreeEntry != null) {
                        if (topicTreeEntry.f18237c == i8 && Arrays.equals(s7, topicTreeEntry.f18239e)) {
                            if (!z7) {
                                topicTreeEntry.f18242h = true;
                            } else {
                                MqttSubscribedPublishFlow mqttSubscribedPublishFlow = topicTreeEntry.f18240f;
                                if (mqttSubscribedPublishFlow != null) {
                                    mqttSubscribedPublishFlow.p().g(topicTreeEntry.f18241g);
                                }
                                nodeList.g(topicTreeEntry);
                            }
                        }
                        d8 = topicTreeEntry.a();
                    } else {
                        return nodeList.f();
                    }
                }
            } else {
                return false;
            }
        }

        private TopicTreeNode x(MqttTopicIterator mqttTopicIterator) {
            MqttTopicLevel p8 = mqttTopicIterator.p();
            if (p8.e()) {
                return y(this.f18247d, mqttTopicIterator);
            }
            Index<TopicTreeNode, MqttTopicLevel> index = this.f18246c;
            if (index != null) {
                return y(index.g(p8), mqttTopicIterator);
            }
            return null;
        }

        private static TopicTreeNode y(TopicTreeNode topicTreeNode, MqttTopicIterator mqttTopicIterator) {
            if (topicTreeNode == null) {
                return null;
            }
            MqttTopicLevel mqttTopicLevel = topicTreeNode.f18245b;
            if (mqttTopicLevel instanceof MqttTopicLevels) {
                if (!mqttTopicIterator.k((MqttTopicLevels) mqttTopicLevel)) {
                    return null;
                }
                return topicTreeNode;
            }
            return topicTreeNode;
        }

        TopicTreeNode e(MqttTopicIterator mqttTopicIterator, MqttSubscribedPublishFlow mqttSubscribedPublishFlow) {
            if (mqttTopicIterator.o()) {
                return x(mqttTopicIterator);
            }
            if (mqttTopicIterator.n()) {
                f(this.f18249f, mqttSubscribedPublishFlow);
                return null;
            }
            f(this.f18248e, mqttSubscribedPublishFlow);
            return null;
        }

        TopicTreeNode g(Throwable th) {
            Index<TopicTreeNode, MqttTopicLevel> index = this.f18246c;
            if (index != null) {
                return index.c();
            }
            TopicTreeNode topicTreeNode = this.f18247d;
            if (topicTreeNode != null) {
                return topicTreeNode;
            }
            NodeList<TopicTreeEntry> nodeList = this.f18248e;
            if (nodeList != null) {
                h(nodeList, th);
                this.f18248e = null;
            }
            NodeList<TopicTreeEntry> nodeList2 = this.f18249f;
            if (nodeList2 != null) {
                h(nodeList2, th);
                this.f18249f = null;
            }
            TopicTreeNode topicTreeNode2 = this.f18244a;
            if (topicTreeNode2 != null) {
                topicTreeNode2.t(this);
            }
            return this.f18244a;
        }

        TopicTreeNode j(MqttTopicIterator mqttTopicIterator, MqttStatefulPublishWithFlows mqttStatefulPublishWithFlows) {
            TopicTreeNode topicTreeNode = null;
            if (mqttTopicIterator.o()) {
                d(mqttStatefulPublishWithFlows, this.f18249f);
                MqttTopicLevel p8 = mqttTopicIterator.p();
                Index<TopicTreeNode, MqttTopicLevel> index = this.f18246c;
                if (index != null) {
                    topicTreeNode = index.g(p8);
                }
                TopicTreeNode topicTreeNode2 = this.f18247d;
                if (topicTreeNode == null) {
                    return k(topicTreeNode2, mqttTopicIterator);
                }
                if (topicTreeNode2 == null) {
                    return k(topicTreeNode, mqttTopicIterator);
                }
                MqttTopicIterator j8 = mqttTopicIterator.j();
                TopicTreeNode k8 = k(topicTreeNode, mqttTopicIterator);
                if (k8 == null) {
                    return k(topicTreeNode2, mqttTopicIterator);
                }
                TopicTreeNode k9 = k(topicTreeNode2, j8);
                if (k9 == null) {
                    return k8;
                }
                while (k9 != null) {
                    k9 = k9.j(j8, mqttStatefulPublishWithFlows);
                }
                return k8;
            }
            d(mqttStatefulPublishWithFlows, this.f18248e);
            d(mqttStatefulPublishWithFlows, this.f18249f);
            return null;
        }

        void n(MqttTopicLevel mqttTopicLevel, java.util.Map<Integer, List<MqttSubscription>> map, final Queue<IteratorNode> queue) {
            final MqttTopicLevel mqttTopicLevel2;
            MqttTopicLevel mqttTopicLevel3;
            if (mqttTopicLevel != null && (mqttTopicLevel3 = this.f18245b) != null) {
                mqttTopicLevel2 = MqttTopicLevels.l(mqttTopicLevel, mqttTopicLevel3);
            } else {
                mqttTopicLevel2 = this.f18245b;
            }
            NodeList<TopicTreeEntry> nodeList = this.f18248e;
            if (nodeList != null) {
                o(nodeList, mqttTopicLevel2, false, map);
            }
            NodeList<TopicTreeEntry> nodeList2 = this.f18249f;
            if (nodeList2 != null) {
                o(nodeList2, mqttTopicLevel2, true, map);
            }
            Index<TopicTreeNode, MqttTopicLevel> index = this.f18246c;
            if (index != null) {
                index.f(new Consumer() { // from class: com.hivemq.client.internal.mqtt.handler.publish.incoming.e
                    @Override // j$.util.function.Consumer
                    public final void accept(Object obj) {
                        MqttSubscribedPublishFlowTree.TopicTreeNode.q(queue, mqttTopicLevel2, (MqttSubscribedPublishFlowTree.TopicTreeNode) obj);
                    }

                    @Override // j$.util.function.Consumer
                    public /* synthetic */ Consumer andThen(Consumer consumer) {
                        return Consumer.CC.$default$andThen(this, consumer);
                    }
                });
            }
            TopicTreeNode topicTreeNode = this.f18247d;
            if (topicTreeNode != null) {
                queue.add(new IteratorNode(topicTreeNode, mqttTopicLevel2));
            }
        }

        boolean p() {
            if (this.f18246c == null && this.f18247d == null && this.f18248e == null && this.f18249f == null) {
                return true;
            }
            return false;
        }

        TopicTreeNode u(MqttTopicIterator mqttTopicIterator, MqttTopicFilterImpl mqttTopicFilterImpl, int i8, boolean z7) {
            if (mqttTopicIterator.o()) {
                return x(mqttTopicIterator);
            }
            if (mqttTopicIterator.n()) {
                if (v(this.f18249f, mqttTopicFilterImpl, i8, z7)) {
                    this.f18249f = null;
                }
            } else if (v(this.f18248e, mqttTopicFilterImpl, i8, z7)) {
                this.f18248e = null;
            }
            i();
            return null;
        }

        TopicTreeNode w(MqttTopicIterator mqttTopicIterator, TopicTreeEntry topicTreeEntry) {
            TopicTreeNode topicTreeNode = null;
            if (mqttTopicIterator.o()) {
                MqttTopicLevel p8 = mqttTopicIterator.p();
                if (p8.e()) {
                    TopicTreeNode topicTreeNode2 = this.f18247d;
                    if (topicTreeNode2 == null) {
                        TopicTreeNode topicTreeNode3 = new TopicTreeNode(this, p8.i());
                        this.f18247d = topicTreeNode3;
                        return topicTreeNode3;
                    }
                    return m(topicTreeNode2, mqttTopicIterator);
                }
                Index<TopicTreeNode, MqttTopicLevel> index = this.f18246c;
                if (index == null) {
                    this.f18246c = new Index<>(f18243g);
                } else {
                    topicTreeNode = index.g(p8);
                }
                if (topicTreeNode == null) {
                    TopicTreeNode topicTreeNode4 = new TopicTreeNode(this, p8.i());
                    this.f18246c.h(topicTreeNode4);
                    return topicTreeNode4;
                }
                return m(topicTreeNode, mqttTopicIterator);
            }
            if (mqttTopicIterator.n()) {
                if (this.f18249f == null) {
                    this.f18249f = new NodeList<>();
                }
                this.f18249f.a(topicTreeEntry);
            } else {
                if (this.f18248e == null) {
                    this.f18248e = new NodeList<>();
                }
                this.f18248e.a(topicTreeEntry);
            }
            return null;
        }

        TopicTreeNode z(MqttTopicIterator mqttTopicIterator, MqttTopicFilterImpl mqttTopicFilterImpl) {
            if (mqttTopicIterator.o()) {
                return x(mqttTopicIterator);
            }
            if (mqttTopicIterator.n()) {
                if (A(this.f18249f, mqttTopicFilterImpl)) {
                    this.f18249f = null;
                }
            } else if (A(this.f18248e, mqttTopicFilterImpl)) {
                this.f18248e = null;
            }
            i();
            return null;
        }
    }

    private void h() {
        TopicTreeNode topicTreeNode = this.f18234a;
        if (topicTreeNode != null && topicTreeNode.p()) {
            this.f18234a = null;
        }
    }

    @Override // com.hivemq.client.internal.mqtt.handler.publish.incoming.MqttSubscribedPublishFlows
    public void a(MqttStatefulPublishWithFlows mqttStatefulPublishWithFlows) {
        MqttTopicIterator r7 = MqttTopicIterator.r(((MqttPublish) mqttStatefulPublishWithFlows.f18228d.c()).q());
        TopicTreeNode topicTreeNode = this.f18234a;
        while (topicTreeNode != null) {
            topicTreeNode = topicTreeNode.j(r7, mqttStatefulPublishWithFlows);
        }
    }

    @Override // com.hivemq.client.internal.mqtt.handler.publish.incoming.MqttSubscribedPublishFlows
    public void b(MqttSubscription mqttSubscription, int i8, MqttSubscribedPublishFlow mqttSubscribedPublishFlow) {
        TopicTreeEntry topicTreeEntry = new TopicTreeEntry(mqttSubscription, i8, mqttSubscribedPublishFlow);
        MqttTopicIterator q8 = MqttTopicIterator.q(mqttSubscription.g());
        TopicTreeNode topicTreeNode = this.f18234a;
        if (topicTreeNode == null) {
            topicTreeNode = new TopicTreeNode(null, null);
            this.f18234a = topicTreeNode;
        }
        while (topicTreeNode != null) {
            topicTreeNode = topicTreeNode.w(q8, topicTreeEntry);
        }
    }

    @Override // com.hivemq.client.internal.mqtt.handler.publish.incoming.MqttSubscribedPublishFlows
    public void c(MqttTopicFilterImpl mqttTopicFilterImpl, int i8, boolean z7) {
        MqttTopicIterator q8 = MqttTopicIterator.q(mqttTopicFilterImpl);
        TopicTreeNode topicTreeNode = this.f18234a;
        while (topicTreeNode != null) {
            topicTreeNode = topicTreeNode.u(q8, mqttTopicFilterImpl, i8, z7);
        }
        h();
    }

    @Override // com.hivemq.client.internal.mqtt.handler.publish.incoming.MqttSubscribedPublishFlows
    public void d(Throwable th) {
        TopicTreeNode topicTreeNode = this.f18234a;
        while (topicTreeNode != null) {
            topicTreeNode = topicTreeNode.g(th);
        }
        this.f18234a = null;
    }

    @Override // com.hivemq.client.internal.mqtt.handler.publish.incoming.MqttSubscribedPublishFlows
    public java.util.Map<Integer, List<MqttSubscription>> e() {
        TreeMap treeMap = new TreeMap(Comparator.CC.reverseOrder());
        if (this.f18234a != null) {
            LinkedList linkedList = new LinkedList();
            linkedList.add(new IteratorNode(this.f18234a, null));
            while (!linkedList.isEmpty()) {
                IteratorNode iteratorNode = (IteratorNode) linkedList.poll();
                iteratorNode.f18235a.n(iteratorNode.f18236b, treeMap, linkedList);
            }
        }
        return treeMap;
    }

    @Override // com.hivemq.client.internal.mqtt.handler.publish.incoming.MqttSubscribedPublishFlows
    public void f(MqttTopicFilterImpl mqttTopicFilterImpl) {
        MqttTopicIterator q8 = MqttTopicIterator.q(mqttTopicFilterImpl);
        TopicTreeNode topicTreeNode = this.f18234a;
        while (topicTreeNode != null) {
            topicTreeNode = topicTreeNode.z(q8, mqttTopicFilterImpl);
        }
        h();
    }

    @Override // com.hivemq.client.internal.mqtt.handler.publish.incoming.MqttSubscribedPublishFlows
    public void g(MqttSubscribedPublishFlow mqttSubscribedPublishFlow) {
        Object d8 = mqttSubscribedPublishFlow.p().d();
        while (true) {
            HandleList.Handle handle = (HandleList.Handle) d8;
            if (handle != null) {
                MqttTopicIterator q8 = MqttTopicIterator.q((MqttTopicFilterImpl) handle.c());
                TopicTreeNode topicTreeNode = this.f18234a;
                while (topicTreeNode != null) {
                    topicTreeNode = topicTreeNode.e(q8, mqttSubscribedPublishFlow);
                }
                d8 = handle.a();
            } else {
                return;
            }
        }
    }
}
