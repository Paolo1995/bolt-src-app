package org.simpleframework.xml.stream;

/* loaded from: classes5.dex */
class InputStack extends Stack<InputNode> {
    public InputStack() {
        super(6);
    }

    public boolean isRelevant(InputNode inputNode) {
        if (!contains(inputNode) && !isEmpty()) {
            return false;
        }
        return true;
    }
}
