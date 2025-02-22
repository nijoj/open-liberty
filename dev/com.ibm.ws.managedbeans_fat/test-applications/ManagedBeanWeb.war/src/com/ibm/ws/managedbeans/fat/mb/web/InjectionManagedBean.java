/*******************************************************************************
 * Copyright (c) 2012, 2020 IBM Corporation and others.
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
package com.ibm.ws.managedbeans.fat.mb.web;

import java.sql.Connection;
import java.util.logging.Logger;

import javax.annotation.ManagedBean;
import javax.annotation.Resource;
import javax.ejb.EJB;
import javax.sql.DataSource;
import javax.transaction.UserTransaction;

/**
 * Simple Managed Bean that has been named and has simple injection.
 **/
@ManagedBean("InjectionManagedBean")
public class InjectionManagedBean {
    private static final String CLASS_NAME = InjectionManagedBean.class.getName();
    private static final Logger svLogger = Logger.getLogger(CLASS_NAME);
    private static int svNextID = 1;

    private final int ivID;
    private String ivValue = null;

    @Resource
    UserTransaction ivUserTran;

    @Resource(name = "jdbc/TestDS")
    DataSource testDS;

    @Resource(name = "TestDSfromWAR")
    DataSource testDSfromWAR;

    // NOTE: This injection should not occur because ejbLite should not be
    // enabled in the ManagedBeansServer.
    @EJB
    IgnoredStatelessBean ejbRef;

    public InjectionManagedBean() {
        // Use a unique id so it is easy to tell which instance is in use.
        synchronized (this) {
            svLogger.info("-- web.InjectionManagedBean.<init>:" + svNextID);
            ivID = svNextID++;
        }
    }

    /**
     * Returns the unique identifier of this instance.
     */
    public int getIdentifier() {
        svLogger.info("-- getIdentifier : " + this);
        return ivID;
    }

    /**
     * Returns the value.. to verify object is 'stateful'
     */
    public String getValue() {
        svLogger.info("-- getValue : " + this);
        return ivValue;
    }

    /**
     * Sets the value.. to verify object is 'stateful'
     */
    public void setValue(String value) {
        svLogger.info("-- setValue : " + ivValue + "->" + value + " : " + this);
        ivValue = value;
    }

    /**
     * Returns the injected UserTransaction.
     */
    public UserTransaction getUserTransaction() {
        return ivUserTran;
    }

    /**
     * Returns the injected DataSource.
     */
    public DataSource getDataSource() throws Exception {
        Connection conn = testDS.getConnection();
        conn.close();

        return testDS;
    }

    /**
     * Returns the injected DataSource defined by the WAR.
     */
    public DataSource getWARdefinedDataSource() throws Exception {
        Connection conn = testDSfromWAR.getConnection();
        conn.close();

        return testDSfromWAR;
    }

    @Override
    public String toString() {
        return "web.InjectionManagedBean(ID=" + ivID + "," + ivValue + ")";
    }

}
