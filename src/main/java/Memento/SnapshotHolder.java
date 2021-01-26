package Memento;

import java.util.Stack;

public class SnapshotHolder {
    private final Stack<Snapshot> snapshots = new Stack<>();

    public Snapshot popSnapshot() {
        if (!snapshots.isEmpty()) {
            return snapshots.pop();
        }

        return null;
    }

    public void pushSnapshot(Snapshot snapshot) {
        snapshots.push(snapshot);
    }

}

