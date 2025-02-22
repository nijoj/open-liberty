/*******************************************************************************
 * Copyright (c) 2014, 2019 IBM Corporation and others.
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
package com.ibm.ws.couchdb.fat;

import org.junit.ClassRule;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import com.ibm.ws.couchdb.fat.tests.CouchDBContainer;
import com.ibm.ws.couchdb.fat.tests.TestCouchDbWar;

import componenttest.containers.SimpleLogConsumer;
import componenttest.containers.TestContainerSuite;

@RunWith(Suite.class)
@SuiteClasses({ TestCouchDbWar.class })
public class FATSuite extends TestContainerSuite {
    // The Dockerfile for 'kyleaure/couchdb-ssl:1.0' can be found/rebuilt in the cloudant_fat project
    @ClassRule
    public static CouchDBContainer couchdb = new CouchDBContainer("kyleaure/couchdb-ssl:1.0")
                    .withLogConsumer(new SimpleLogConsumer(FATSuite.class, "couchdb"));

}