/*******************************************************************************
 * Copyright (c) 2010 IBM Corporation and others.
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
/** 
 * This package provides facilities to write first failure data capture (FFDC) records 
 * to assist in debugging problems.  Typical use of this facility is through the 
 * static methods on the {@link com.ibm.ws.ffdc.FFDCFilter} class, to write information when an unexpected 
 * exception has been caught; for example: 
 * <pre>
 * {@code
 * catch (Exception x) {
 *     FFDCFilter.processException(x, getClass().getName(), "129", this);
 *     throw x;
 * }
 * }
 * </pre>
 * 
 * @version 1.0 
 */
@org.osgi.annotation.versioning.Version("1.0")
@TraceOptions(traceGroup = com.ibm.ws.logging.internal.NLSConstants.GROUP, messageBundle = com.ibm.ws.logging.internal.NLSConstants.LOGGING_NLS)
package com.ibm.ws.ffdc;

import com.ibm.websphere.ras.annotation.TraceOptions;

