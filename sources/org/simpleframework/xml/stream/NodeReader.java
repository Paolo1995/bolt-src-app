package org.simpleframework.xml.stream;

/* loaded from: classes5.dex */
class NodeReader {
    private final EventReader reader;
    private final StringBuilder text = new StringBuilder();
    private final InputStack stack = new InputStack();

    public NodeReader(EventReader eventReader) {
        this.reader = eventReader;
    }

    private void fillText(InputNode inputNode) throws Exception {
        EventNode peek = this.reader.peek();
        if (peek.isText()) {
            this.text.append(peek.getValue());
        }
    }

    private boolean isName(EventNode eventNode, String str) {
        String name = eventNode.getName();
        if (name == null) {
            return false;
        }
        return name.equals(str);
    }

    private String readBuffer(InputNode inputNode) throws Exception {
        if (this.text.length() > 0) {
            String sb = this.text.toString();
            this.text.setLength(0);
            return sb;
        }
        return null;
    }

    private InputNode readStart(InputNode inputNode, EventNode eventNode) throws Exception {
        InputElement inputElement = new InputElement(inputNode, this, eventNode);
        if (this.text.length() > 0) {
            this.text.setLength(0);
        }
        if (eventNode.isStart()) {
            return this.stack.push(inputElement);
        }
        return inputElement;
    }

    private String readText(InputNode inputNode) throws Exception {
        EventNode peek = this.reader.peek();
        while (this.stack.top() == inputNode && peek.isText()) {
            fillText(inputNode);
            this.reader.next();
            peek = this.reader.peek();
        }
        return readBuffer(inputNode);
    }

    public boolean isEmpty(InputNode inputNode) throws Exception {
        if (this.stack.top() == inputNode && this.reader.peek().isEnd()) {
            return true;
        }
        return false;
    }

    public boolean isRoot(InputNode inputNode) {
        if (this.stack.bottom() == inputNode) {
            return true;
        }
        return false;
    }

    public InputNode readElement(InputNode inputNode) throws Exception {
        if (this.stack.isRelevant(inputNode)) {
            EventNode next = this.reader.next();
            while (next != null) {
                if (next.isEnd()) {
                    if (this.stack.pop() == inputNode) {
                        return null;
                    }
                } else if (next.isStart()) {
                    return readStart(inputNode, next);
                }
                next = this.reader.next();
            }
            return null;
        }
        return null;
    }

    public InputNode readRoot() throws Exception {
        if (!this.stack.isEmpty()) {
            return null;
        }
        InputNode readElement = readElement(null);
        if (readElement != null) {
            return readElement;
        }
        throw new NodeException("Document has no root element");
    }

    public String readValue(InputNode inputNode) throws Exception {
        if (!this.stack.isRelevant(inputNode)) {
            return null;
        }
        if (this.text.length() <= 0 && this.reader.peek().isEnd()) {
            if (this.stack.top() == inputNode) {
                return null;
            }
            this.stack.pop();
            this.reader.next();
        }
        return readText(inputNode);
    }

    public void skipElement(InputNode inputNode) throws Exception {
        do {
        } while (readElement(inputNode) != null);
    }

    public InputNode readElement(InputNode inputNode, String str) throws Exception {
        if (this.stack.isRelevant(inputNode)) {
            EventNode peek = this.reader.peek();
            while (true) {
                if (peek == null) {
                    break;
                }
                if (peek.isText()) {
                    fillText(inputNode);
                } else if (peek.isEnd()) {
                    if (this.stack.top() == inputNode) {
                        return null;
                    }
                    this.stack.pop();
                } else if (peek.isStart()) {
                    if (isName(peek, str)) {
                        return readElement(inputNode);
                    }
                }
                this.reader.next();
                peek = this.reader.peek();
            }
            return null;
        }
        return null;
    }
}
