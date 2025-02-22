/*******************************************************************************
 * Copyright (c) 2017 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-2.0/
 * 
 * SPDX-License-Identifier: EPL-2.0
 *
 * Contributors:
 *     IBM Corporation - initial API and implementation
 *******************************************************************************/
package io.openliberty.cdi40.internal.weld;

import java.util.ArrayList;

import org.jboss.weld.security.spi.SecurityContext;

import com.ibm.wsspi.threadcontext.ThreadContext;
import com.ibm.wsspi.threadcontext.ThreadContextDescriptor;

/**
 * The Liberty implementation of the
 * org.jboss.weld.security.spi.SecurityContext interface
 */
class CDI40SecurityContext implements SecurityContext {
    private ThreadContextDescriptor threadContextDesc = null;
    private ArrayList<ThreadContext> threadContext = null;

    CDI40SecurityContext(ThreadContextDescriptor tcd) {
        threadContextDesc = tcd;
    }

    /** {@inheritDoc} */
    @Override
    public void associate() {
        if (threadContextDesc != null)
            threadContext = threadContextDesc.taskStarting();
    }

    /** {@inheritDoc} */
    @Override
    public void close() {
        // noop
    }

    /** {@inheritDoc} */
    @Override
    public void dissociate() {
        if (threadContextDesc != null)
            threadContextDesc.taskStopping(threadContext);
    }

}