package com.latico.commons.net.socket.nio.tcp.common;

import java.nio.channels.SelectionKey;

/**
 * <PRE>
 *
 * </PRE>
 *
 * @author: latico
 * @date: 2019-01-21 11:41
 * @version: 1.0
 */
public class SelectionKeyHandler {
    private final SelectionKey selectionKey;

    public SelectionKeyHandler(SelectionKey selectionKey) {

        this.selectionKey = selectionKey;
    }

    public SelectionKey getSelectionKey() {
        return selectionKey;
    }
}
