/*******************************************************************************
 * Copyright (c) 2017, 2022 IBM Corporation and others.
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
package com.ibm.ws.security.javaeesec.properties;

import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class ModuleProperties {
    private Map<Class<?>, Properties> authMechMap;
    private URL location;

    public ModuleProperties(URL location, Map<Class<?>, Properties> authMechMap) {
        this.authMechMap = authMechMap;
        this.location = location;
    }

    public ModuleProperties(Map<Class<?>, Properties> authMechMap) {
        this.authMechMap = authMechMap;
        this.location = null;
    }

    public ModuleProperties(URL location) {
        authMechMap = new HashMap<Class<?>, Properties>();
        this.location = location;
    }

    public ModuleProperties() {
        authMechMap = new HashMap<Class<?>, Properties>();
        location = null;
    }

    public Map<Class<?>, Properties> getAuthMechMap() {
        return authMechMap;
    }

    public Properties getFromAuthMechMap(Class<?> className) {
        return authMechMap.get(className);
    }

    public URL getLocation() {
        return location;
    }

    public Properties putToAuthMechMap(Class<?> className, Properties props) {
        return authMechMap.put(className, props);
    }
}
