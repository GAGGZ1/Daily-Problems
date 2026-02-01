class LockingNode {
    int data;
    LockingNode left, right, parent;

    boolean isLocked;
    int lockedDescendantCount;

    LockingNode(int data) {
        this.data = data;
        this.isLocked = false;
        this.lockedDescendantCount = 0;
    }
}
private boolean hasLockedAncestor(LockingNode node) {
    LockingNode current = node.parent;

    while (current != null) {
        if (current.isLocked) {
            return true;
        }
        current = current.parent;
    }
    return false;
}
public boolean isLocked(LockingNode node) {
    return node.isLocked;
}
public boolean lock(LockingNode node) {

    // Rule 1: If this node already locked, return false
    if (node.isLocked) {
        return false;
    }

    // Rule 2: If any descendant locked
    if (node.lockedDescendantCount > 0) {
        return false;
    }

    // Rule 3: If any ancestor locked
    if (hasLockedAncestor(node)) {
        return false;
    }

    // Lock this node
    node.isLocked = true;

    // Update all ancestors' lockedDescendantCount
    LockingNode current = node.parent;
    while (current != null) {
        current.lockedDescendantCount++;
        current = current.parent;
    }

    return true;
}
public boolean unlock(LockingNode node) {

    if (!node.isLocked) {
        return false;
    }

    node.isLocked = false;

    // Update ancestors
    LockingNode current = node.parent;
    while (current != null) {
        current.lockedDescendantCount--;
        current = current.parent;
    }

    return true;
}
