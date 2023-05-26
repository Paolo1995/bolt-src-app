package org.simpleframework.xml.stream;

/* loaded from: classes5.dex */
interface EventNode extends Iterable<Attribute> {
    int getLine();

    String getName();

    String getPrefix();

    String getReference();

    Object getSource();

    String getValue();

    boolean isEnd();

    boolean isStart();

    boolean isText();
}
