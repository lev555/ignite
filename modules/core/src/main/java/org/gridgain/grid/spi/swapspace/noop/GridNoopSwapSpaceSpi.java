/* @java.file.header */

/*  _________        _____ __________________        _____
 *  __  ____/___________(_)______  /__  ____/______ ____(_)_______
 *  _  / __  __  ___/__  / _  __  / _  / __  _  __ `/__  / __  __ \
 *  / /_/ /  _  /    _  /  / /_/ /  / /_/ /  / /_/ / _  /  _  / / /
 *  \____/   /_/     /_/   \_,__/   \____/   \__,_/  /_/   /_/ /_/
 */

package org.gridgain.grid.spi.swapspace.noop;

import org.apache.ignite.*;
import org.apache.ignite.lang.*;
import org.apache.ignite.resources.*;
import org.gridgain.grid.spi.*;
import org.gridgain.grid.spi.swapspace.*;
import org.gridgain.grid.util.*;
import org.gridgain.grid.util.typedef.internal.*;
import org.jetbrains.annotations.*;

import java.util.*;

/**
 * No-op implementation of {@link GridSwapSpaceSpi}. Exists for testing and benchmarking purposes.
 */
@GridSpiNoop
@GridSpiMultipleInstancesSupport(true)
public class GridNoopSwapSpaceSpi extends IgniteSpiAdapter implements GridSwapSpaceSpi {
    /** Logger. */
    @IgniteLoggerResource
    private IgniteLogger log;

    /** {@inheritDoc} */
    @Override public void spiStart(@Nullable String gridName) throws IgniteSpiException {
        U.warn(log, "Swap space is disabled. To enable use GridFileSwapSpaceSpi.");
    }

    /** {@inheritDoc} */
    @Override public void spiStop() throws IgniteSpiException {
        // No-op.
    }

    /** {@inheritDoc} */
    @Override public void clear(@Nullable String space) throws IgniteSpiException {
        // No-op.
    }

    /** {@inheritDoc} */
    @Override public long size(@Nullable String space) throws IgniteSpiException {
        return 0;
    }

    /** {@inheritDoc} */
    @Override public long count(@Nullable String space) throws IgniteSpiException {
        return 0;
    }

    /** {@inheritDoc} */
    @Override @Nullable public byte[] read(@Nullable String spaceName, GridSwapKey key, GridSwapContext ctx)
        throws IgniteSpiException {
        return null;
    }

    /** {@inheritDoc} */
    @Override public Map<GridSwapKey, byte[]> readAll(@Nullable String spaceName, Iterable<GridSwapKey> keys,
        GridSwapContext ctx) throws IgniteSpiException {
        return Collections.emptyMap();
    }

    /** {@inheritDoc} */
    @Override public void remove(@Nullable String spaceName, GridSwapKey key, @Nullable IgniteInClosure<byte[]> c,
        GridSwapContext ctx) throws IgniteSpiException {
        // No-op.
    }

    /** {@inheritDoc} */
    @Override public void removeAll(@Nullable String spaceName, Collection<GridSwapKey> keys,
        @Nullable IgniteBiInClosure<GridSwapKey, byte[]> c, GridSwapContext ctx) throws IgniteSpiException {
        // No-op.
    }

    /** {@inheritDoc} */
    @Override public void store(@Nullable String spaceName, GridSwapKey key, @Nullable byte[] val,
        GridSwapContext ctx) throws IgniteSpiException {
        // No-op.
    }

    /** {@inheritDoc} */
    @Override public void storeAll(@Nullable String spaceName, Map<GridSwapKey, byte[]> pairs,
        GridSwapContext ctx) throws IgniteSpiException {
        // No-op.
    }

    /** {@inheritDoc} */
    @Override public void setListener(@Nullable GridSwapSpaceSpiListener evictLsnr) {
        // No-op.
    }

    /** {@inheritDoc} */
    @Override public Collection<Integer> partitions(@Nullable String spaceName) throws IgniteSpiException {
        return Collections.emptyList();
    }

    /** {@inheritDoc} */
    @Override public <K> IgniteSpiCloseableIterator<K> keyIterator(@Nullable String spaceName,
        GridSwapContext ctx) throws IgniteSpiException {
        return new GridEmptyCloseableIterator<>();
    }

    /** {@inheritDoc} */
    @Override public IgniteSpiCloseableIterator<Map.Entry<byte[], byte[]>> rawIterator(
        @Nullable String spaceName) throws IgniteSpiException {
        return new GridEmptyCloseableIterator<>();
    }

    /** {@inheritDoc} */
    @Override public IgniteSpiCloseableIterator<Map.Entry<byte[], byte[]>> rawIterator(@Nullable String spaceName,
        int part) throws IgniteSpiException {
        return new GridEmptyCloseableIterator<>();
    }

    /** {@inheritDoc} */
    @Override public String toString() {
        return S.toString(GridNoopSwapSpaceSpi.class, this);
    }
}
