/*******************************************************************************
 * Copyright (c) 2014, 2023 IBM Corporation and others.
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
package com.ibm.ws.cdi.extension.tests;

import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.ClassRule;
import org.junit.runner.RunWith;

import com.ibm.websphere.simplicity.ShrinkHelper;
import com.ibm.websphere.simplicity.ShrinkHelper.DeployOptions;
import com.ibm.websphere.simplicity.log.Log;
import com.ibm.ws.cdi.extension.apps.spi40.CrossWireTestServlet;
import com.ibm.ws.cdi.extension.apps.spi40.MisplacedTestServlet;
import com.ibm.ws.cdi.extension.apps.spi40.SPIExtensionServlet;

import componenttest.annotation.Server;
import componenttest.annotation.TestServlet;
import componenttest.annotation.TestServlets;
import componenttest.custom.junit.runner.FATRunner;
import componenttest.custom.junit.runner.Mode;
import componenttest.custom.junit.runner.Mode.TestMode;
import componenttest.rules.repeater.RepeatTests;
import componenttest.topology.impl.LibertyServer;
import componenttest.topology.utils.FATServletClient;

/**
 * Test the runtime extension to function correctly
 *
 * This is split from CDI12ExtensionSPITest because the test-bundle needs access to CDI internals.
 * getBuildCompatibleExtensions() is only avaialbe to internal components.
 * Rather than enable access to internals for everything I split the test so we can test with and without that access.
 */
@RunWith(FATRunner.class)
@Mode(TestMode.FULL)
public class CDI40ExtensionSPITest extends FATServletClient {

    public static final String APP_NAME = "SPI40Extension";
    public static final String SERVER_NAME = "cdi40SPIExtensionServer";

    @Server(SERVER_NAME)
    @TestServlets({
                    @TestServlet(servlet = SPIExtensionServlet.class, contextRoot = APP_NAME),
                    @TestServlet(servlet = CrossWireTestServlet.class, contextRoot = APP_NAME),
                    @TestServlet(servlet = MisplacedTestServlet.class, contextRoot = APP_NAME) })
    public static LibertyServer server;

    @ClassRule
    public static RepeatTests r = CDIExtensionRepeatActions.repeat(SERVER_NAME,
                                                                   CDIExtensionRepeatActions.EE10_PLUS,
                                                                   CDIExtensionRepeatActions.EE11_PLUS);

    @BeforeClass
    public static void setUp() throws Exception {
        System.out.println("Install the user feature bundle... cdi.internals");
        CDIExtensionRepeatActions.installSystemFeature(server, CDIExtensionRepeatActions.CDI_INTERNALS_BUNDLE_ID);
        CDIExtensionRepeatActions.installUserExtension(server, CDIExtensionRepeatActions.CDI_SPI_EXTENSION_BUNDLE_WITH_INTERNALS_ID);
        CDIExtensionRepeatActions.installUserBundle(server, CDIExtensionRepeatActions.CDI_SPI_MISPLACED_BUNDLE_ID);

        WebArchive classSPIExtension = ShrinkWrap.create(WebArchive.class, APP_NAME + ".war");
        classSPIExtension.addPackage(SPIExtensionServlet.class.getPackage());

        ShrinkHelper.exportDropinAppToServer(server, classSPIExtension, DeployOptions.SERVER_ONLY);
        server.startServer(true);
        server.waitForStringInLogUsingMark("CWWKZ0001I.*Application SPIExtension started");
    }

    @AfterClass
    public static void cleanup() throws Exception {
        try {
            final String METHOD_NAME = "cleanup";
            Log.info(CDI12ExtensionTest.class, METHOD_NAME, "Stopping the server.");
            if (server.isStarted()) {
                server.stopServer();
            }
            Log.info(CDI12ExtensionTest.class, METHOD_NAME, "Removing cdi extension test user feature files.");
        } finally {
            CDIExtensionRepeatActions.uninstallUserExtension(server, CDIExtensionRepeatActions.CDI_SPI_EXTENSION_BUNDLE_ID);
            CDIExtensionRepeatActions.uninstallUserBundle(server, CDIExtensionRepeatActions.CDI_SPI_MISPLACED_BUNDLE_ID);
            CDIExtensionRepeatActions.uninstallSystemFeature(server, CDIExtensionRepeatActions.CDI_SPI_EXTENSION_BUNDLE_WITH_INTERNALS_ID);
        }
    }
}
