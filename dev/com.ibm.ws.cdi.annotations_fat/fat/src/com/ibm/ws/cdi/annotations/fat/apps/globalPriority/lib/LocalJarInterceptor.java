/*******************************************************************************
 * Copyright (c) 2014 IBM Corporation and others.
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
package com.ibm.ws.cdi.annotations.fat.apps.globalPriority.lib;

import javax.interceptor.Interceptor;

import com.ibm.ws.cdi.annotations.fat.apps.utils.Intercepted;

/**
 * Enabled for this bean archive in beans.xml.
 */
@Interceptor
@Intercepted
public class LocalJarInterceptor extends AbstractInterceptor {

    public LocalJarInterceptor() {
        super(LocalJarInterceptor.class);
    }
}
