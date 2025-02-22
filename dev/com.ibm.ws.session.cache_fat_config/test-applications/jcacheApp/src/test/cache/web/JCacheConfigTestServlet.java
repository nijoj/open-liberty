/*******************************************************************************
 * Copyright (c) 2018 IBM Corporation and others.
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
package test.cache.web;

import javax.cache.Caching;
import javax.cache.spi.CachingProvider;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import componenttest.app.FATServlet;

@SuppressWarnings("serial")
@WebServlet("/JCacheConfigTestServlet")
public class JCacheConfigTestServlet extends FATServlet {
    /**
     * Have the application obtain and close the caching provider instance for the configured Hazelcast library.
     * The session cache implementation ultimately uses this library but would like to do so in a way that is
     * isolated from applications so that it controls its own life cycle and makes it more difficult for
     * applications to access cached session data other than through the proper HttpSession API.
     */
    public void testCloseCachingProvider(HttpServletRequest request, HttpServletResponse response) throws Exception {
        // Try to end up with the same CachingProvider instance as the sessionCache feature by using the configured library's class loader.
        ClassLoader hazelcastClassLoader = Class.forName("com.hazelcast.cache.HazelcastCachingProvider").getClassLoader();
        System.out.println("Class loader for HazelcastCachingProvider is " + hazelcastClassLoader);
        CachingProvider cachingProvider = Caching.getCachingProvider(hazelcastClassLoader);
        System.out.println("Provider instance is " + Integer.toHexString(System.identityHashCode(cachingProvider)) + " " + cachingProvider);
        cachingProvider.close();
    }
}
